package RPGGame.main;

import RPGGame.cli.GameConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameConsole gameConsoleInstance = new GameConsole();
        gameConsoleInstance.run();
    }
}
