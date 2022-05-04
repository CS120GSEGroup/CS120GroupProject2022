package RPGGame.main;


import RPGGame.characters.*;
import RPGGame.cli.GameConsole;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Game {

    private PlayableCharacter mainCharacter;
    private int difficultyLevel;
    private boolean isGameOver;
    private ArrayList<NPC> enemies;
    private Game saveGame;


    public Game() {
        isGameOver = false;
        difficultyLevel = 4;
        mainCharacter = null;
        setEnemies();
    }

    public Game(Game g) {
        this.mainCharacter = new PlayableCharacter(g.getMainCharacter());
        this.isGameOver = g.isGameOver();
        this.difficultyLevel = getDifficultyLevel();
        this.enemies = g.getEnemies();
        this.saveGame = null;
    }

    public void setMainCharacter(String playerType) {


        switch (playerType) {
            case "f" -> {
                new Fighter().printImage();
                finalizeChoice(playerType);
            }
            case "a" -> {
                new Archer().printImage();
                finalizeChoice(playerType);
            }
            case "m" -> {
                new Mage().printImage();
                finalizeChoice(playerType);
            }
            default -> System.out.println("That isn't a valid choice");


        }
    }



    public PlayableCharacter getMainCharacter() {
        return this.mainCharacter;
    }


    public void setDifficultyLevel(String difficultyLevel) {
        switch (difficultyLevel) {
            case "e" -> this.difficultyLevel = 1;
            case "m" -> this.difficultyLevel = 2;
            case "h" -> this.difficultyLevel = 3;
            default -> System.out.println("Invalid difficulty level.");

        }

    }

    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public static void selectAction(PlayableCharacter activePlayer, NPC opponent) throws NoSuchElementException {
        Scanner actionScanner = new Scanner(System.in);
        printActionMenu();
        int selection = actionScanner.nextInt();
        switch (selection) {
            case 1 -> activePlayer.attack(opponent, activePlayer);
            case 2 -> activePlayer.useSpecialAbility(opponent, activePlayer);
            case 3 -> activePlayer.heal();
            case 4 -> activePlayer.printPlayerStats();
            default -> System.out.println("That isn't a valid choice, try again\n");

        }
    }

    public static void selectAction(Boss boss, PlayableCharacter activePlayer) throws NoSuchElementException {
        int selection = (int)((Math.random()*3)+1);
        switch (selection) {
            case 1 -> boss.attack(boss, activePlayer);
            case 2 -> boss.useSpecialAbility(boss, activePlayer);
            case 3 -> boss.heal();
            default -> System.out.println("I WILL END YOUR LIFE\n");

        }
    }
    public void finalizeChoice(String playerType) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 'o' to select, press any other key to return to previous menu");
        String navigate = sc.next();
        switch (navigate) {
            case "o"-> {
                switch (playerType) {
                    case "f" -> this.mainCharacter = new Fighter();
                    case "a" -> this.mainCharacter = new Archer();
                    case "m" -> this.mainCharacter = new Mage();
                }
            }
            case "b"-> System.out.println("Character Select Menu");

            default -> System.out.println("That isn't a valid choice");
        }
    }

    public void battle() {
        PlayableCharacter activePlayer = this.mainCharacter;
        NPC enemyCharacter = enemies.get(0);
        enemyCharacter.printPlayerStats();
        GameConsole.moveForward();
        while ((activePlayer.getHealth() != 0 || enemyCharacter.getHealth() != 0)) {
            try {
                selectAction(activePlayer, enemyCharacter);
            } catch (NoSuchElementException e) {
                System.out.println("Try again");
            }

            if (enemyCharacter.getHealth() <= 0) {
                enemyCharacter.setHealth(0);
                printVictoryMessage();
                System.out.println();
                enemies.remove(enemyCharacter);
                break;
            }
            System.out.println(enemyCharacter.getName() + " has taken damage: " + enemyCharacter.getHealth());
            enemyCharacter.attack(enemyCharacter, activePlayer);
            if (activePlayer.getHealth() <= 0) {
                activePlayer.setHealth(0);
                printDefeatMessage();
                System.out.println();
                this.saveGame = new Game(this);
                break;
            }
            System.out.println(activePlayer.getName() + " has taken damage: " + activePlayer.getHealth());
        }
    }

    public void bossBattle() {
        PlayableCharacter activePlayer = getMainCharacter();
        Boss enemyCharacter = ((Boss) getEnemies().get(0));
        enemyCharacter.printPlayerStats();
        GameConsole.moveForward();
        while ((activePlayer.getHealth() != 0 || enemyCharacter.getHealth() != 0)) {
            try {
                selectAction(activePlayer, enemyCharacter);
            } catch (NoSuchElementException e) {
                System.out.println("Try again");
            }

            if (enemyCharacter.getHealth() <= 0) {
                enemyCharacter.setHealth(0);
                printVictoryMessage();
                System.out.println();
                enemies.remove(enemyCharacter);
                break;
            }
            System.out.println(enemyCharacter.getName() + " has taken damage: " + enemyCharacter.getHealth());
            try {
                selectAction(enemyCharacter, activePlayer);
            } catch (NoSuchElementException e) {
                System.out.println("You will die!");
            }
            if (activePlayer.getHealth() <= 0) {
                activePlayer.setHealth(0);
                printDefeatMessage();
                enemyCharacter.victorySpeech();
                System.out.println();
                this.saveGame = new Game(this);
                break;
            }
            System.out.println(activePlayer.getName() + " has taken damage: " + activePlayer.getHealth());
        }
    }

    public boolean isGameOver() {
       this.isGameOver = this.getEnemies().size() == 0 || this.getMainCharacter().getHealth() == 0;
        return this.isGameOver;
    }

    private void setEnemies() {
        int numberOfEnemies = (int) ((Math.random() * (7)) + 7);
        enemies = new ArrayList<>(numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(generateRandomEnemy());
        }
        enemies.add(new Boss());
    }

    public ArrayList<NPC> getEnemies() {
        return enemies;
    }

    private NPC generateRandomEnemy() {
        NPC[] enemyTypes = new NPC[]{new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

    public String difficultyToString() {
        switch (this.getDifficultyLevel()) {
            case 1 -> {
                return "Easy";
            }
            case 2 -> {
                return "Medium";
            }
            case 3 -> {
                return "Hard";
            }
            default -> {
                return "Invalid";
            }

        }
    }

    public static void printActionMenu() {
        System.out.println("---Action Menu---");
        System.out.println("Press '1' to attack");
        System.out.println("Press '2' to attempt special ability");
        System.out.println("Press '3' to heal");
        System.out.println("Press '4' to view stats");
    }

    private void printVictoryMessage() {
        System.out.println(/*some image*/);
        System.out.println("Congratulations, " + getMainCharacter().getName() + "you won!");
    }

    private static void printDefeatMessage() {
        System.out.println(/*some image*/);
        System.out.println("You died. Try again");
        System.exit(0);
    }




}
