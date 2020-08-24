package com.company.project1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = null;
        Player player2 = null;

        Scanner scanner = new Scanner(System.in);


        System.out.println("PVP mode : 1, vs AI: 2, vs Advanced AI: 3");
        int mode = scanner.nextInt();
        scanner.nextLine();

        if(mode == 1){
            System.out.println("PVP mode : 플레이어의 이름을 차례대로 두가지 입력하시오 : ");
            String name1 = scanner.nextLine();
            String name2 = scanner.nextLine();

            player1 = new HumanPlayer(name1);
            player2 = new HumanPlayer(name2);
        } else if(mode == 2){
            System.out.println("AI mode : 플레이어 이름을 한 가지 입력하시오 : ");
            String name  = scanner.nextLine();

            player1 = new HumanPlayer(name);
            player2 = new AIPlayer();
        } else if(mode == 3){
            System.out.println("Advanced AI mode : 플레이어 이름을 한 가지 입력하시오 : ");
            String name  = scanner.nextLine();

            player1 = new AdvancedAIPlayer();
            player2 = new HumanPlayer(name);
        } else {
            System.out.println("잘못된 모드를 선택하였습니다!!!");
            System.exit(0);
        }

        System.out.println("게임 승리 횟수를 입력하세요 : ");
        int gameWinNumber = scanner.nextInt();

        Game game = new Game(player1, player2, gameWinNumber);
        AdvancedAIPlayer.g = game;
        AIPlayer.g = game;
        HumanPlayer.g = game;
        game.start();
    }
}
