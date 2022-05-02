package RPGGame.main;


import RPGGame.characters.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Game {

    private PlayableCharacter mainCharacter;
    private int difficultyLevel;
    private boolean isGameOver;
    private ArrayList<NPC> enemies;

    private boolean isFirstEnemy = true;


    public Game() {
        isGameOver = false;
        difficultyLevel = 4;
        mainCharacter = null;
        makeEnemies();
    }

    public void setMainCharacter(String playerType) {
        switch (playerType) {
            case "f" -> this.mainCharacter = new Fighter();
            case "a" -> this.mainCharacter = new Archer();
            case "m" -> this.mainCharacter = new Mage();
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

    public void battle() {
        PlayableCharacter activePlayer = this.mainCharacter;
        NPC enemyCharacter = enemies.get(0);
        boolean isValid = false;
        while ((activePlayer.getHealth() != 0 || enemyCharacter.getHealth() != 0)) {
            while (!isValid) {
                try {
                    selectAction(activePlayer, enemyCharacter);
                    isValid = true;
                } catch (NoSuchElementException e) {
                    System.out.println("Try again");
                }
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

    private void makeEnemies() {
        int numberOfEnemies = (int) ((Math.random() * (14 - 7)) + 7);
        enemies = new ArrayList<>(numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(getRandomEnemy());
        }
        enemies.add(new Boss());
    }

    private ArrayList<NPC> getEnemies() {
        return enemies;
    }

    private NPC getRandomEnemy() {
        NPC[] enemyTypes = new NPC[]{new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

    private void printVictoryMessage() {
        System.out.println(/*some image*/);
        if(isFirstEnemy) {
            System.out.println("Todd: Yes, you're definitely him.");
            System.out.println(mainCharacter.getName() + " : Explain what prophecy you're talking about?");
            System.out.println("Todd: A long time ago, when Phil Oxlong killed Lord Gabe, Lord Gabe's soothsayer predicted that the time would come and he would be possessed by a man with the name " + mainCharacter.getName() + ", and then there would be peace. And you came, I knew it. It's not an easy road for you stranger, but I'll try to help you in any way I can. Keep your " + mainCharacter.getWeaponsName() + ", and follow this path, it will lead you to Phil Oxlong. Good luck");
            isFirstEnemy = false;
        } else if(getEnemies().size() == 1) {
            System.out.println("Todd: I knew you would kill them all. Now, you need to kill Phil Oxlong. But you are still not as powerful as him. Here, take the poison of health, it should level the odds. Good luck.");
            //Give positions based on level
        } else if(getEnemies().size() == 0) {
            System.out.println("Todd: Yes, you did it. Thank you");
            System.out.println("You win!");
            System.exit(0);
        }
        System.out.println("Congratulations, " + mainCharacter.getName() + "you won!");
    }

    private static void printDefeatMessage() {
        System.out.println(/*some image*/);
        System.out.println("You died. Try again");
        System.exit(0);
    }

    private void printPlayerStats(PlayableCharacter c) {
        System.out.println(c.getName());
        System.out.println("Level: " + c.getLevel());
        System.out.println("Health: " + c.getHealth());
        System.out.println("Damage: " + c.getDamage());
        System.out.println("Potions: " + c.getPotions());

    }
}
