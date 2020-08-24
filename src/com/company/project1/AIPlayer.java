package com.company.project1;

public class AIPlayer implements Player {
    public static Game g;
    private Position position;
    private int winNum;

    public int getWinNum() {
        return winNum;
    }

    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    @Override
    public Position getInput() {
        System.out.println("AI가 수를 두었습니다.");
//        int x = (int)(Math.random() * 100) % 3 + 1;
//        int y = (int)(Math.random() * 100) % 3 + 1;
//
//        position = new Position(x, y);
//
//        return position;
        return attackOrDefend();
    }

    public Position attackOrDefend() {
        int countAI;
        int countHM;
        String[][] board = g.getBoard();

        for (int i = 0; i < 3; i++) { // 가로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("O")) {
                    countAI += 1;
                } else if (board[i][j].equals("X")) {
                    countHM += 1;
                }

                if((countAI == 2 && countHM == 0)){
                    System.out.println("가로20");
                    for (int k = 0; k < 3; k++) {
                        if (board[i][k].equals("-")) {
                            return new Position(i + 1, k + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 가로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("O")) {
                    countAI += 1;
                } else if (board[i][j].equals("X")) {
                    countHM += 1;
                }

                if ((countAI == 0 && countHM == 2)) {
                    System.out.println("가로02");
                    for (int k = 0; k < 3; k++) {
                        if (board[i][k].equals("-")) {
                            return new Position(i + 1, k + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 세로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals("O")) {
                    countAI += 1;
                } else if (board[j][i].equals("X")) {
                    countHM += 1;
                }

                if((countAI == 2 && countHM == 0)){
                    System.out.println("세로20");
                    for (int k = 0; k < 3; k++) {
                        if (board[k][i].equals("-")) {
                            return new Position(k + 1, i + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 세로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals("O")) {
                    countAI += 1;
                } else if (board[j][i].equals("X")) {
                    countHM += 1;
                }

                if ((countAI == 0 && countHM == 2)) {
                    System.out.println("세로02");
                    for (int k = 0; k < 3; k++) {
                        if (board[k][i].equals("-")) {
                            return new Position(k + 1, i + 1);
                        }
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //왼쪽 위에서
            if (board[i][i].equals("O")) {
                countAI += 1;
            } else if (board[i][i].equals("X")) {
                countHM += 1;
            }

            if((countAI == 2 && countHM == 0)){
                System.out.println("왼위20");
                for (int k = 0; k < 3; k++) {
                    if (board[k][k].equals("-")) {
                        return new Position(k + 1, k + 1);
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //왼쪽 위에서
            if (board[i][i].equals("O")) {
                countAI += 1;
            } else if (board[i][i].equals("X")) {
                countHM += 1;
            }

            if ((countAI == 0 && countHM == 2)) {
                System.out.println("왼위02");
                for (int k = 0; k < 3; k++) {
                    if (board[k][k].equals("-")) {
                        return new Position(k + 1, k + 1);
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //오른쪽 위에서
            if (board[i][2 - i].equals("O")) {
                countAI += 1;
            } else if (board[i][2 - i].equals("X")) {
                countHM += 1;
            }

            if((countAI == 2 && countHM == 0)){
                System.out.println("오위20");
                for (int k = 0; k < 3; k++) {
                    if (board[k][2 - k].equals("-")) {
                        return new Position(k + 1, 2 - k + 1);
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //오른쪽 위에서
            if (board[i][2 - i].equals("O")) {
                countAI += 1;
            } else if (board[i][2 - i].equals("X")) {
                countHM += 1;
            }

            if ((countAI == 0 && countHM == 2)) {
                System.out.println("오위02");
                for (int k = 0; k < 3; k++) {
                    if (board[k][2 - k].equals("-")) {
                        return new Position(k + 1, 2 - k + 1);
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 가로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("O")) {
                    countAI += 1;
                } else if (board[i][j].equals("X")) {
                    countHM += 1;
                }

                if ((countAI == 1 && countHM == 0)) {
                    for (int k = 0; k < 3; k++) {
                        if (board[i][k].equals("-")) {
                            return new Position(i + 1, k + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { // 세로 체크
            countAI = 0;
            countHM = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals("O")) {
                    countAI += 1;
                } else if (board[j][i].equals("X")) {
                    countHM += 1;
                }

                if ((countAI == 1 && countHM == 0)) {
                    for (int k = 0; k < 3; k++) {
                        if (board[k][i].equals("-")) {
                            return new Position(k + 1, i + 1);
                        }
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //왼쪽 위에서
            if (board[i][i].equals("O")) {
                countAI += 1;
            } else if (board[i][i].equals("X")) {
                countHM += 1;
            }

            if ((countAI == 1 && countHM == 0)) {
                for (int k = 0; k < 3; k++) {
                    if (board[k][k].equals("-")) {
                        return new Position(k + 1, k + 1);
                    }
                }
            }
        }

        countAI = 0;
        countHM = 0;
        for (int i = 0; i < 3; i++) { //오른쪽 위에서
            if (board[i][2 - i].equals("O")) {
                countAI += 1;
            } else if (board[i][2 - i].equals("X")) {
                countHM += 1;
            }

            if ((countAI == 1 && countHM == 0)) {
                for (int k = 0; k < 3; k++) {
                    if (board[k][2 - k].equals("-")) {
                        return new Position(k + 1, 2 - k + 1);
                    }
                }
            }
        }

        return new Position((int) (Math.random() * 100) % 3 + 1, (int) (Math.random() * 100) % 3 + 1);
    }
}
