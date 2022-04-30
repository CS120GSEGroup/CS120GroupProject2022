//package RPGGame.main;
//
//
//import RPGGame.characters.Archer;
//import RPGGame.characters.Fighter;
//import RPGGame.characters.Mage;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Battle {
//    Character fighterOne = new Character(){
//        public void attack(Character opponent, Character activePlayer) {
//            return;
//        }
//
//        public int takeDamage(Character activePlayer) {
//            return 0;
//        }
//    };
//
//    Character fighterTwo = new Character(){
//        public void attack(Character opponent, Character activePlayer) {
//            return;
//        }
//
//        public int takeDamage(Character activePlayer) {
//            return 0;
//        }
//    };
//
//
//    public void chooseFighters() {
//        Random random = new Random();
//        Scanner scanner = new Scanner(System.in);
//
//        Fighter swordsman = new Fighter();
//        Archer archer = new Archer();
//        Mage mage = new Mage();
//
//        System.out.println("***********************THE GAME OF WAR***********************");
//        System.out.println();
//        System.out.println("Who will battle? Choose the first warrior " +
//                "\nChoose 1 for Caramon the Brave Swordsman" +
//                "\nChoose 2 for Tanis the Wise Archer" +
//                "\nChoose 3 for Raistlin the Dark Mage");
//
//        boolean choice1 = false;
//        while (!choice1) {
//            int fighter1 = scanner.nextInt();
//
//            switch (fighter1) {
//                case 1:
//                    fighterOne = swordsman;
//                    System.out.println("You chose the mighty swordsman!");
//                    System.out.println();
//                    choice1 = true;
//                    break;
//                case 2:
//                    fighterOne = archer;
//                    System.out.println("You chose the sharpshooting archer --->");
//                    System.out.println();
//                    choice1 = true;
//                    break;
//                case 3:
//                    fighterOne = mage;
//                    System.out.println("You chose the terrifying mage...");
//                    System.out.println();
//                    choice1 = true;
//                    break;
//                default:
//                    System.out.println("Please choose a warrior.");
//            }
//        }
//        System.out.println("Who will battle? Choose the second warrior " +
//                "\nChoose 1 for Caramon the Brave Swordsman" +
//                "\nChoose 2 for Tanis the Wise Archer" +
//                "\nChoose 3 for Raistlin the Dark Mage");
//
//        boolean choice2 = false;
//        while (!choice2) {
//            int fighter1 = scanner.nextInt();
//
//            switch (fighter1) {
//                case 1:
//                    fighterTwo = swordsman;
//                    System.out.println("You chose the mighty swordsman!");
//                    System.out.println();
//                    choice2 = true;
//                    break;
//                case 2:
//                    fighterTwo = archer;
//                    System.out.println("You chose the sharpshooting archer --->");
//                    System.out.println();
//                    choice2 = true;
//                    break;
//                case 3:
//                    fighterTwo = mage;
//                    System.out.println("You chose the terrifying mage...");
//                    System.out.println();
//                    choice2 = true;
//                    break;
//                default:
//                    System.out.println("Please choose a warrior.");
//            }
//        }
//    }
//
//    public void battle() {
//
//        while (true) {
//            fighterOne.attack(fighterTwo, fighterOne);
//            if (fighterTwo.getHealth() <= 0) {
//                fighterTwo.setHealth(0);
//                System.out.println(fighterTwo.getName() + "'s Health: " + fighterTwo.getHealth());
//                System.out.println("The Battle is over");
//                System.out.println(fighterOne.getName() + " wins!");
//                System.out.println();
//                break;
//            }
//            System.out.println(fighterTwo.getName() + " has taken damage: " + fighterTwo.getHealth());
//            fighterTwo.attack(fighterOne, fighterTwo);
//            if (fighterOne.getHealth() <= 0) {
//                fighterOne.setHealth(0);
//                System.out.println(fighterOne.getName() + "'s Health: " + fighterOne.getHealth());
//                System.out.println("The Battle is over");
//                System.out.println(fighterTwo.getName() + " wins!");
//                System.out.println();
//                break;
//            }
//            System.out.println(fighterOne.getName() + " has taken damage: " + fighterOne.getHealth());
//
//        }
//
//    }
//}
