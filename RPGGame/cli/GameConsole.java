package RPGGame.cli;

import RPGGame.main.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameConsole {

    Game gameInstance;

    public GameConsole() {

    }

    public void run() {
        Scanner mainScanner = new Scanner(System.in);
        printMenu();
        String selection = mainScanner.next();
        while(!selection.equals("e")) {
            switch (selection) {
                case "p":
                    gameInstance = new Game();
                    System.out.println("Select difficulty level");
                    System.out.println("(e) Easy");
                    System.out.println("(m) Medium");
                    System.out.println("(h) Hard");
                    gameInstance.setDifficultyLevel(mainScanner.next());

                    System.out.println("Select character type");
                    System.out.println("(s) Soldier");
                    System.out.println("(w) Wizard");
                    System.out.println("(a) Archer");
                    gameInstance.setPlayerCharacter(mainScanner.next());

                    while (!gameInstance.isGameOver()) {

                    }

                case "c":
                    printCredits();
                    break;
                default:
                    System.exit(0);
                    break;
            }
            printMenu();
            selection = mainScanner.next();
        }

        mainScanner.close();
    }

    private void printCredits() {
        System.out.println("Scenario: Surik Simonyan");
        System.out.println("Main Developer: Georgi Panosyan");
        System.out.println("Developer: Erik Khalatyan");
    }

    private void printMenu() {
        System.out.println("------Elden Square------");
        System.out.println("(p) Play");
        System.out.println("(c) Credits");
        System.out.println("(e) Exit");
    }
}
