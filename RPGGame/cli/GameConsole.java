package RPGGame.cli;

import RPGGame.main.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameConsole {

    Game gameInstance;

    public  GameConsole(){

    }

//    public GameConsole() throws FileNotFoundException {
//        Scanner textScanner = new Scanner(new FileInputStream("scenario.txt"));
//
//    }

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
        gameInstance = new Game();
        while (gameInstance.getDifficultyLevel() < 1 || gameInstance.getDifficultyLevel() > 3) {
            printDifficultyMenu();
            gameInstance.setDifficultyLevel(gameScanner.next());
        }
        System.out.println("You've chosen the " + gameInstance.difficultyToString() + " way.");

        while (gameInstance.getMainCharacter() == null) {
            printCharacterMenu();
            gameInstance.setMainCharacter(gameScanner.next());
        }
        System.out.println("Prompt for character naming");
        gameInstance.getMainCharacter().setName(gameScanner.next());

        gameInstance.battle();
    }

    private void printMainMenu() {
        System.out.println("------Elden Square------");
        System.out.println("(p) Play");
        System.out.println("(c) Credits");
        System.out.println("(e) Exit");
    }

    private void printCharacterMenu() {
        System.out.println("Select character type");
        System.out.println("(f) Soldier");
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
}
