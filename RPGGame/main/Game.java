package RPGGame.main;

import RPGGame.characters.*;

import java.util.ArrayList;

public class Game {

    private boolean isGameOver;
    private int difficultyLevel;

    private GameCharacter playerCharacter;

    private ArrayList<GameCharacter> enemies;

    public Game() {
        isGameOver = false;
        difficultyLevel = 4;
        playerCharacter = null;
    }

    private void makeEnemies() {
        int numberOfEnemies = (int) ((Math.random() * (14 - 7)) + 7);
        enemies = new ArrayList<>(numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(getRandomEnemy());
        }
        enemies.add(new Boss());
    }

    private GameCharacter getRandomEnemy() {
        GameCharacter[] enemyTypes = new GameCharacter[] {new Archer(), new Mage(), new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

    public void start() {

    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        switch (difficultyLevel) {
            case "e" -> this.difficultyLevel = 0;
            case "m" -> this.difficultyLevel = 2;
            case "h" -> this.difficultyLevel = 3;
            default -> System.out.println("Invalid difficulty level.");

        }
    }

    public GameCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(String playerType) {
        switch (playerType) {
            case "s" -> this.playerCharacter = new Soldier();
            case "w" -> this.playerCharacter = new Mage();
            case "a" -> this.playerCharacter = new Archer();
            default -> System.out.println("Invalid player type.");
        }
        makeEnemies();
    }
}
