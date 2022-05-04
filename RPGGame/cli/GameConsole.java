package RPGGame.cli;


import RPGGame.characters.PlayableCharacter;
import RPGGame.main.Game;

import java.util.Scanner;

public class GameConsole {

    Game game;

    public GameConsole() {

    }

    public void run() {
        Scanner mainScanner = new Scanner(System.in);
        printMainMenu();
        String selection = mainScanner.next();

        while (true) {
            switch (selection) {
                case "p" -> start();
                case "c" -> printCredits();
                case "e" -> System.exit(0);
                default -> System.out.println("That isn't a valid choice");
            }
            printMainMenu();
            selection = mainScanner.next();
        }
    }

    private void start() {
        Scanner gameScanner = new Scanner(System.in);
        this.game = new Game();

        while (this.game.getDifficultyLevel() < 1 || this.game.getDifficultyLevel() > 3) {
            printDifficultyMenu();
            this.game.setDifficultyLevel(gameScanner.next());
        }
        System.out.println("You've chosen the " + this.game.difficultyToString() + " way.");


        while (this.game.getMainCharacter() == null) {
            printCharacterMenu();
            this.game.setMainCharacter(gameScanner.next());

        }
        PlayableCharacter player = new PlayableCharacter(game.getMainCharacter());

        while(game.getEnemies().size() > 1){
            System.out.println("Todd: Hey you, finally awake. You should be new here. What's your name stranger?");
            System.out.println("-----Select Name-----");
            player.setName(gameScanner.next());

            System.out.println("\nWait... you said " + player.getName() +
                    " ?\nSo it IS you. You're the man of prophecy who's supposed to lead us to freedom...\n No time, here, take my "
                    + player.weaponToString() +
                    "\nthey will be useful to you. Defeat these guards and I will explain everything to you.");
            moveForward();
            player.printPlayerStats();

            moveForward();
            game.battle();
            System.out.println("Todd: Yes, you're definitely him.\n");

            System.out.println(player.getName() + " : Explain what prophecy you're talking about?\n");
            moveForward();
            System.out.println("Todd: A long time ago, when Phil Oxlong killed Lord Gabe, Lord Gabe's soothsayer " +
                    "\npredicted that the time would come and he would be possessed by a man with the name \n"
                    + player.getName() + ", and then there would be peace. And you came, I knew it. It's not an easy road" +
                    "\n for you stranger, but I'll try to help you in any way I can. Keep your \n"
                    + player.weaponToString() + ", and follow this path, it will lead you to Phil Oxlong. " +
                    "\nGood luck");
        }


        if (game.getEnemies().size() == 0) {
            System.exit(0);

        }
    }

    private void printMainMenu() {
        System.out.println("------Elden Square------");
        System.out.println("(p) Play");
        System.out.println("(c) Credits");
        System.out.println("(e) Exit");
    }

    private void printCharacterMenu() {
        System.out.println("Select character type");
        System.out.println("(f) Fighter");
        System.out.println("(a) Archer");
        System.out.println("(m) Mage");
    }

    private void printDifficultyMenu() {
        System.out.println("Select difficulty level");
        System.out.println("(e) Easy");
        System.out.println("(m) Medium");
        System.out.println("(h) Hard");
    }

    private void printCredits() {
        System.out.println("Scenario: Surik Simonyan");
        System.out.println("Main Developer: Georgi Panosyan");
        System.out.println("Developer: Erik Khalatyan");
    }

    public static void moveForward() {
        Scanner ok = new Scanner(System.in);
        String ANSI_RED_BACKGROUND
                = "\u001B[41m";
        System.out.println("\n" + ANSI_RED_BACKGROUND+"Press 'o' to continue");
        String selection = ok.next();
        while (!selection.equals("o")) {
            System.out.println("\n" + "\u001bPress 'o' to continue");
            selection = ok.next();
        }


    }
}
