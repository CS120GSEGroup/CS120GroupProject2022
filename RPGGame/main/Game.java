package RPGGame.main;


import RPGGame.characters.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Game {

    private GameCharacter mainCharacter;
    private int difficultyLevel;
    private boolean isGameOver;
    private ArrayList<GameCharacter> enemies;


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

    public ArrayList<GameCharacter> getEnemies() {
        return new ArrayList<GameCharacter>(enemies);
    }

    public void setEnemies(ArrayList<GameCharacter> enemies) {
        this.enemies = enemies;
    }

    public void battle() {
        setEnemies(makeEnemies());
        GameCharacter activePlayer = this.mainCharacter;
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
                printVictoryMessage();
                System.out.println();
                enemies.remove(counter);
                break;
            }
            System.out.println(enemies.get(counter).getName() + " has taken damage: " + enemies.get(counter).getHealth());
            enemies.get(counter).attack(activePlayer, enemies.get(counter));
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

    public void printActionMenu() {
        System.out.println("---Action Menu---");
        System.out.println("Press '1' to attack");
        System.out.println("Press '2' to attempt special ability");
        System.out.println("Press '3' to heal");
    }

    public void selectAction(GameCharacter activePlayer, GameCharacter opponent) throws NoSuchElementException {
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

    private ArrayList<GameCharacter> makeEnemies() {
        int numberOfEnemies = (int) ((Math.random() * (14 - 7)) + 7);
        ArrayList<GameCharacter> enemies = new ArrayList<>(numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(getRandomEnemy());
        }
        return enemies;
    }

    private GameCharacter getRandomEnemy() {
        GameCharacter[] enemyTypes = new GameCharacter[]{new Archer(), new Mage(), new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

    private void printVictoryMessage() {
        System.out.println(/*some image*/);
        System.out.println("Congratulations, " + this.mainCharacter.getName() + "you won!");
    }

    private void printDefeatMessage() {
        System.out.println(/*some image*/);
        System.out.println("You died. Try again");

    }

    private void printPlayerStats(GameCharacter gameCharacter) {
        System.out.println(gameCharacter.getName());
        System.out.println("Level: " + gameCharacter.getLevel());
        System.out.println("Health: " + gameCharacter.getHealth());
        System.out.println("Damage: " + gameCharacter.getDamage());
        System.out.println("Potions: " + gameCharacter.getPotions());

    }
}
