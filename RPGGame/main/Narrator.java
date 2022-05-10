package RPGGame.main;

import RPGGame.cli.GameConsole;


public class Narrator {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED = "\033[0;31m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";

    private static String playerName;
    private static String playerWeapon;

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String name) {
        Narrator.playerName = name;
    }

    public static String getPlayerWeapon() {
        return playerWeapon;
    }

    public static void setPlayerWeapon(String playerWeapon) {
        Narrator.playerWeapon = playerWeapon;
    }

    public static void printIntro() {
        System.out.println("Todd: Hey you, finally awake. You should be new here. What's your name, stranger?");
        System.out.println("-----Select Name-----");
    }

    public static void printLevelZeroText() {
        System.out.println("\nWait... you said " + getPlayerName() +
                " ?\nSo it IS you. You're the man of prophecy who's supposed to lead us to freedom..." +
                "\n No time, here, take my " + getPlayerWeapon() + "\nthey will be useful to you. " +
                "Defeat these guards and I will explain everything to you.");
    }

    public static void printLevelOneText() {
        System.out.println("Todd: Yes, you're definitely him.\n");
        System.out.println(getPlayerName() + " : Explain what prophecy you're talking about?\n");
        GameConsole.moveForward();
        System.out.println("Todd: A long time ago, when Phil Oxlong killed Lord Gabe, Lord Gabe's soothsayer " +
                "\npredicted that the time would come and he would be possessed by a man with the name \n"
                + getPlayerName() + ", and then there would be peace. And you came, I knew it. It's not an easy road" +
                "\n for you stranger, but I'll try to help you in any way I can. Keep your \n"
                + getPlayerWeapon() + ", and follow this path, it will lead you to Phil Oxlong. " +
                "\nGood luck");
    }

    public static void printLevelTwoText() {
        System.out.println("Todd: You're quite skilled with that " + getPlayerWeapon() + "." +
                "\nUp ahead lays the Sphinx. You must answer his riddle correctly to pass. If you" +
                "\nguess incorrectly three times, he will attack");


    }

    public static void printLevelThreeText(){
        System.out.println();
    }

    public static void printPuzzle() {
        System.out.println();
        System.out.println("THE MYSTERY OF THE SPHINX");
        System.out.println("What walks on four legs in the morning, two legs in the day, " +
                "\nand three legs in the evening?");
    }

    public static void puzzleSolved() {
        System.out.println("Todd: WOW, you solved it!" +
                "\nLet's get going before the Sphinx changes his mind");
    }

    public static void puzzleFailed() {
        System.out.println("Todd: I hope you're ready for the fight of your life...");
    }


}