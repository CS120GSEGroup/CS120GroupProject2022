package RPGGame.main;


import RPGGame.characters.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Game {

    private  PlayableCharacter mainCharacter;
    private int difficultyLevel;
    private boolean isGameOver;
    private ArrayList<NPC> enemies;


    public Game() {
        isGameOver = false;

    }

    public void setMainCharacter(String playerType) {
        switch (playerType) {
            case "f" -> this.mainCharacter = new Fighter();
            case "a" -> this.mainCharacter = new Archer();
            case "m" -> this.mainCharacter = new Mage();
            default -> System.out.println("That isn't a valid choice");
        }
    }

    public GameCharacter getMainCharacter() {
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

    public ArrayList<NPC> getEnemies() {
        return new ArrayList<>(this.enemies);
    }

    public void setEnemies(ArrayList<NPC> enemies) {
        this.enemies = enemies;
    }

    public void battle() {
        setEnemies(makeEnemies());
        PlayableCharacter activePlayer = this.mainCharacter;
        int counter = enemies.size() - 1;
        boolean isValid = false;
        while ((activePlayer.getHealth() != 0 || enemies.get(counter).getHealth() != 0)) {
            while(!isValid){
                try {
                    selectAction(activePlayer, enemies.get(counter));
                    isValid = true;
                } catch (NoSuchElementException e) {
                    System.out.println("Try again");
                }
            }
            if (enemies.get(counter).getHealth() <= 0) {
                enemies.get(counter).setHealth(0);
                //printVictoryMessage();
                System.out.println();
                enemies.remove(counter);
                break;
            }
            System.out.println(enemies.get(counter).getName() + " has taken damage: " + enemies.get(counter).getHealth());
            enemies.get(counter).attack( enemies.get(counter),activePlayer);
            if (activePlayer.getHealth() <= 0) {
                activePlayer.setHealth(0);
                printDefeatMessage();
                System.out.println();
                break;
            }
            System.out.println(activePlayer.getName() + " has taken damage: " + activePlayer.getHealth());

        }

    }

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public static void printActionMenu() {
        System.out.println("---Action Menu---");
        System.out.println("Press '1' to attack");
        System.out.println("Press '2' to attempt special ability");
        System.out.println("Press '3' to heal");
    }

    public static void selectAction(PlayableCharacter activePlayer, NPC opponent) throws NoSuchElementException {
        Scanner actionScanner = new Scanner(System.in);
        printActionMenu();
        int selection = actionScanner.nextInt();
        switch (selection) {
            case 1 -> activePlayer.attack(opponent, activePlayer);
            case 2 -> activePlayer.useSpecialAbility(opponent, activePlayer);
            case 3 -> activePlayer.heal();
            //case 4 ->
            default -> System.out.println("That isn't a valid choice, try again\n");

        }

        actionScanner.close();
    }

    private ArrayList<NPC> makeEnemies() {
        int numberOfEnemies = (int) ((Math.random() * (14 - 7)) + 7);
        ArrayList<NPC> enemies = new ArrayList<>(numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(getRandomEnemy());
        }
        return enemies;
    }

    private NPC getRandomEnemy() {
        NPC[] enemyTypes = new NPC[]{ new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

//    private static void printVictoryMessage() {
//        System.out.println(/*some image*/);
//        System.out.println("Congratulations, " + mainCharacter.getName() + "you won!");
//    }

    private static void printDefeatMessage() {
        System.out.println(/*some image*/);
        System.out.println("You died. Try again");

    }

    private void printPlayerStats(PlayableCharacter c) {
        System.out.println(c.getName());
        System.out.println("Level: " + c.getLevel());
        System.out.println("Health: " + c.getHealth());
        System.out.println("Damage: " + c.getDamage());
        System.out.println("Potions: " + c.getPotions());

    }
}
