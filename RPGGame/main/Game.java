package RPGGame.main;

import RPGGame.characters.Archer;
import RPGGame.characters.Character;
import RPGGame.characters.Mage;
import RPGGame.characters.Soldier;

public class Game {

    private boolean isGameOver;
    private int difficultyLevel;

    private Character playerCharacter;

    public Game() {
        isGameOver = false;
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
            default -> this.difficultyLevel = 3;
        }
    }

    public Character getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(String playerType) {
        switch (playerType) {
            case "s" -> this.playerCharacter = new Soldier();
            case "w" -> this.playerCharacter = new Mage();
            default -> this.playerCharacter = new Archer();
        }
    }
}
