package com.company.project1;

import java.util.Scanner;

public class HumanPlayer implements Player {
    public static Game g;
    private String name;
    private Position position;
    private int winNum;

    public int getWinNum() {
        return winNum;
    }

    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public Position getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(name + "님 놔둘 수의 좌표를 말해주세요 : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while(x > 3 || x <= 0 || y > 3|| y <= 0){
            System.out.println("놓는 수의 범위가 판을 벗어났습니다. 다시 입력하세요.");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }

        position = new Position(x, y);

        return position;
    }
}
