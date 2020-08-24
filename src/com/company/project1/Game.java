package com.company.project1;


public class Game {
    private String[][] board = new String[3][3];
    private Player player1;
    private Player player2;
    private int gameWinNumber;


    public Game(Player player1, Player player2, int gameWinNumber) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameWinNumber = gameWinNumber;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
    }

    public void start() {
        initialize();

        while (player1.getWinNum() != gameWinNumber && player2.getWinNum() != gameWinNumber) { // 누구든지 승리 횟수 달성하면 끝
            printBoard(player1);
            if (isFinishedWin()) {
                player1.setWinNum(player1.getWinNum() + 1);
                printScore();
                if(player1 instanceof AdvancedAIPlayer){
                    ((AdvancedAIPlayer) player1).setMotionOrderNum(0);
                }
                initialize();
            } else {
                if(isFinishedDraw()){
                    System.out.println("비겼습니다.!!!");
                    initialize();
                    continue;
                }
                printBoard(player2);
            }

            if (isFinishedWin()) {
                player2.setWinNum(player2.getWinNum() + 1);
                printScore();
                initialize();
            }

            if(isFinishedDraw()){
                System.out.println("비겼습니다.!!!");
                initialize();
            }
        }

        System.out.println("게임이 종료되었습니다!!!");
    }

    public void printBoard(Player player) {
        Position position = player.getInput();

        while (true) {
            if (board[position.getX() - 1][position.getY() - 1].equals("O") || board[position.getX() - 1][position.getY() - 1].equals("X")) {
                if (player instanceof HumanPlayer) {
                    System.out.println("이미 수가 놓아진 위치입니다. 다시 입력하세요!");
                }
            } else {
                break;
            }
            position = player.getInput();
        }

        if (player.equals(player1)) {
            board[position.getX() - 1][position.getY() - 1] = "O";
        } else {
            board[position.getX() - 1][position.getY() - 1] = "X";
        }

        for (String[] line1 : board) {
            for (String line2 : line1) {
                System.out.print(line2);
            }
            System.out.println("");
        }
    }

    public boolean isFinishedWin() { // 한 게임이 종료되었는지 파악
        int checkCount;
        boolean checkFinish = false;

        for (int i = 0; i < 3; i++) { // 가로 체크
            checkCount = 0;
            for (int j = 0; j < 2; j++) {
                if (board[i][j].equals(board[i][j + 1]) && !board[i][j].equals("-")) {
                    checkCount += 1;
                }
                if (checkCount == 2) {
                    checkFinish = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 세로 체크
            checkCount = 0;
            for (int j = 0; j < 2; j++) {
                if (board[j][i].equals(board[j + 1][i]) && !board[j][i].equals("-")) {
                    checkCount += 1;
                }
                if (checkCount == 2) {
                    checkFinish = true;
                }
            }
        }

        checkCount = 0;
        for (int i = 0; i < 2; i++) { //왼쪽 위에서
            if (board[i][i].equals(board[i + 1][i + 1]) && !board[i][i].equals("-")) {
                checkCount++;
            }
            if (checkCount == 2) {
                checkFinish = true;
            }
        }

        checkCount = 0;
        for (int i = 0; i < 2; i++) { // 오른쪽 위에서
            if (board[i][2 - i].equals(board[i + 1][1 - i]) && !board[i][2 - i].equals("-")) {
                checkCount++;
            }
            if (checkCount == 2) {
                checkFinish = true;
            }
        }

        return checkFinish;
    }

    public boolean isFinishedDraw(){
        int drawCount = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!board[i][j].equals("-")){
                    drawCount++;
                }
            }
        }
        return drawCount == 9;
    }

    public void printScore() {
        if(player1 instanceof AdvancedAIPlayer){
            ((AdvancedAIPlayer) player1).setMotionOrderNum(0);
        }
        System.out.println("현재 스코어 : " + player1.getWinNum() + "-" + player2.getWinNum());
    }
}
