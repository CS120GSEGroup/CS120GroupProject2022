package RPGGame.main;


import RPGGame.characters.*;
import RPGGame.cli.GameConsole;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Game {

    private PlayableCharacter mainCharacter;
    private int difficultyLevel = 0;
    private ArrayList<NPC> enemies;


    public Game() {
        // populateEnemiesArray();
    }

    public Game(Game g) {
        setEnemies(g.getEnemies());
        setDifficultyLevel(g.getDifficultyLevel());
        this.mainCharacter = new PlayableCharacter(g.getMainCharacter());

    }


    public PlayableCharacter getMainCharacter() {
        return this.mainCharacter;
    }

    public void setMainCharacter(PlayableCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public void setEnemies(ArrayList<NPC> enemies) {
        this.enemies = new ArrayList<>(enemies);
    }

    public ArrayList<NPC> getEnemies() {
        return this.enemies;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }


    public void selectMainCharacter() {
        Scanner sc = new Scanner(System.in);
        while (getMainCharacter() == null) {
            GameConsole.printCharacterMenu();
            String choice = sc.next();
            switch (choice) {
                case "w" -> setMainCharacter(new Warrior());

                case "a" -> setMainCharacter(new Archer());

                case "m" -> setMainCharacter(new Mage());

                default -> GameConsole.invalidChoice();
            }

        }
    }


    public void selectDifficultyLevel() {
        Scanner sc = new Scanner(System.in);
        String selection;
        while (this.difficultyLevel == 0) {
            GameConsole.printDifficultyMenu();
            selection = sc.nextLine();
            switch (selection) {
                case "e" -> this.difficultyLevel = 1;

                case "m" -> this.difficultyLevel = 2;

                case "h" -> this.difficultyLevel = 3;

                default -> GameConsole.invalidChoice();
            }
        }
        System.out.println("You've chosen the " + this.difficultyToString() + " way.");
        populateEnemiesArray();
    }

    public boolean solvePuzzle() {
        Scanner sc = new Scanner(System.in);
        Narrator.printPuzzle();
        String answer;
        boolean isCorrect = false;
        for (int i = 3; i > 0; --i) {
            System.out.println("Tell me your answer");
            answer = sc.nextLine();
            if (answer.equals("man")) {
                isCorrect = true;
                break;
            } else {
                System.out.println("You have " + i + " attempts left.");
            }
        }
        return isCorrect;
    }


    public static void selectAction(PlayableCharacter activePlayer, NPC opponent) throws NoSuchElementException {
        Scanner actionScanner = new Scanner(System.in);
        GameConsole.printActionMenu();
        int selection = 0;
        while (selection < 1 || selection > 5) {
            selection = actionScanner.nextInt();
            switch (selection) {
                case 1 -> activePlayer.attack(opponent, activePlayer);

                case 2 -> activePlayer.useSpecialAbility(opponent, activePlayer);

                case 3 -> {
                    activePlayer.heal();
                    opponent.setDamage(0);
                }
                case 4 -> activePlayer.block(opponent);

                case 5 -> {
                    activePlayer.printPlayerStats();
                    opponent.setDamage(0);
                }

                default -> GameConsole.invalidChoice();
            }
        }
    }

    public static void selectAction(Boss boss, PlayableCharacter activePlayer) throws NoSuchElementException {
        int selection = (int) ((Math.random() * 4) + 1);
        switch (selection) {
            case 1 -> boss.attack(boss, activePlayer);
            case 2 -> boss.useSpecialAbility(boss, activePlayer);
            case 3 -> boss.heal();
            case 4 -> boss.block(activePlayer);
            default -> System.out.println("I WILL END YOUR LIFE\n");

        }
    }

    private NPC generateRandomEnemy() {
        NPC[] enemyTypes = new NPC[]{new Officer(), new Soldier()};
        return enemyTypes[(int) (Math.random() * enemyTypes.length)];
    }

    private void populateEnemiesArray() {
        int numberOfEnemies = ((int) (((Math.random() * (7 - 5)) + 5))) * getDifficultyLevel();
        setEnemies(new ArrayList<>(numberOfEnemies));
        for (int i = 0; i < numberOfEnemies; i++) {
            getEnemies().add(generateRandomEnemy());
            getEnemies().get(i).setHealth(getEnemies().get(i).getHealth() + 5 * difficultyLevel);
        }
        getEnemies().add(new Boss());
        getEnemies().get(getEnemies().size() - 1).setHealth(getEnemies().get(getEnemies().size() - 1).getHealth() + 10 * difficultyLevel);
    }

    public void battle() {
        PlayableCharacter player = getMainCharacter();
        NPC enemy = getEnemies().get(0);
        enemy.printImage();
        GameConsole.moveForward();
        int t1 = enemy.getDamage();
        while (true) {
            selectAction(player, enemy);
            printDamageReport(enemy);
            if (isBattleOver(enemy, player)) {
                break;
            }
            enemy.attack(enemy, player);
            printDamageReport(player);
            if (isBattleOver(enemy, player)) {
                break;
            }
            enemy.setDamage(t1);
        }
        announceResult(determineVictor(player, enemy));
    }

    private boolean isBattleOver(NPC n, PlayableCharacter p) {
        return n.getHealth() <= 0 || p.getHealth() <= 0;
    }

    private boolean isBattleOver(Boss b, PlayableCharacter p) {
        return b.getHealth() <= 0 || p.getHealth() <= 0;
    }

    public void bossBattle(Boss boss, PlayableCharacter player) {
        boss.printImage();
        int t1 = player.getDamage();
        int t2 = boss.getDamage();
        boolean flag = false;
        while (!flag) {
            selectAction(player, boss);
            printDamageReport(boss);
            if (isBattleOver(boss, player)) {
                flag = true;
            }
            selectAction(boss, player);
            printDamageReport(player);
            if (isBattleOver(boss, player)) {
                flag = true;
            }
            player.setDamage(t1);
            boss.setDamage(t2);
        }
        announceResult(determineVictor(player, boss));
    }


    public boolean isGameOver() {
        return this.getEnemies().size() == 0 || this.getMainCharacter().getHealth() == 0;
    }

    private GameCharacter determineVictor(GameCharacter p, GameCharacter o) {
        if (o.getHealth() <= 0) {
            death(o);
            return p;
        } else if (p.getHealth() <= 0)
            death(p);
        return o;

    }

    public void addPotion(){
        getMainCharacter().setPotions(getMainCharacter().getPotions()+1);
    }

    public void levelUp(){
        addPotion();
        getMainCharacter().setLevel(getMainCharacter().getLevel()+1);
        System.out.println("You've leveled up! +1 Potions +1 Level");
    }



    public void death(GameCharacter g) {
        if (g.equals(getMainCharacter())) {
            g.setHealth(0);
        } else if (g instanceof NPC) {
            g.setHealth(0);
            getEnemies().remove(g);
        }
    }

    public static void printDamageReport(GameCharacter g) {
        System.out.println(g.getName() + " has " + g.getHealth() + " Health Points left.");
    }

    public static void announceResult(GameCharacter g) {
        if (g instanceof PlayableCharacter && g.getHealth() <= 0) {
            System.out.println("You are dead.");
            System.exit(0);

        } else if (g instanceof NPC && g.getHealth() <= 0) {
            System.out.println("You win!");

        }
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
}
