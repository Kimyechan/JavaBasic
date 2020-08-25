package com.company.project1;

public class AdvancedAIPlayer extends AIPlayer{
    public static Game g;
    private int winNum;
    private int caseNum;
    private int motionOrderNum = 0;

    public void setMotionOrderNum(int motionOrderNum) {
        this.motionOrderNum = motionOrderNum;
    }

    public int getWinNum() {
        return winNum;
    }

    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    @Override
    public Position getInput() {
        String[][] board = g.getBoard();
        System.out.println("Advanced AI가 수를 뒀습니다.");

        if (motionOrderNum == 0) {
            motionOrderNum++;
            return new Position(3, 1);
        } else if (motionOrderNum == 1) {
            if (board[1][1].equals("-")) {
                if (board[0][0].equals("-") && board[1][0].equals("-") && board[1][2].equals("-")) {
                    motionOrderNum++;
                    caseNum = 11;
                    return new Position(1, 1);
                } else if (board[2][2].equals("-") && board[2][1].equals("-") && board[0][1].equals("-")) {
                    motionOrderNum++;
                    caseNum = 33;
                    return new Position(3, 3);
                }
            } else {
                return attackOrDefend();
            }
        } else if (motionOrderNum == 2) {
            if(caseNum == 11){
                if(board[0][1].equals("-") && board[0][2].equals("-")){
                    return new Position(1, 3);
                } else if(board[2][1].equals("-") && board[2][2].equals("-")){
                    return new Position(3, 3);
                }
            }
        }
//        else if (motionOrderNum == 3) {
//            if (board[2][2].equals("-")) {
//                return new Position(1, 2);
//            } else if (board[2][0].equals("-")) {
//                return attackOrDefend();
//            }
//        }
        System.out.println("last !!!");
        return attackOrDefend();
    }
}
