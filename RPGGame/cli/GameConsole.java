package RPGGame.cli;

import RPGGame.main.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameConsole {

    Game gameInstance;

    public GameConsole() throws FileNotFoundException {
        Scanner textScanner = new Scanner(new FileInputStream("scenario.txt"));

    }

    public void run() {
        Scanner mainScanner = new Scanner(System.in);
        System.out.println("------MENU------");
        System.out.println("Play -- press 'p'");
        System.out.println("Exit -- press 'e'");

        String selection = mainScanner.next();

        if (!"p".equals(selection)) {
            System.exit(0);
        } else {
            gameInstance = new Game();
            start();
        }
        mainScanner.close();
    }

    public void start() {

    }
}
