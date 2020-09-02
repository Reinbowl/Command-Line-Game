import java.util.Scanner;
import java.util.Random;

public class Game {
    private static String userInput;
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();

    private static int Round = 1;
    private static Player player;
    private static final int MOBNUM = 3;
    private static Monster[] mobs = new Monster[MOBNUM];

    private static boolean userChoice() {
        String choice;
        do {
            choice = input.nextLine().trim();
            if (choice.toLowerCase().equals("yes")) {
                return true;
            } else if (choice.toLowerCase().equals("no")) {
                return false;
            } else {
                System.out.println("Enter yes or no.");
            }
        } while (input.hasNextLine());
        return true;
    }

    public static void createPlayer() {
        do {
            System.out.print("Enter your name: ");
            userInput = input.nextLine();
            System.out.println("Confirm your name is " + userInput + "?");
        } while (!userChoice());
        System.out.println();

        do {
            player = new Player(userInput);
            System.out.println("This is your player stats:\n" + player);
            System.out.println("Do you want to reroll stats?");
        } while (userChoice());
        System.out.println();

        System.out.println("Now loading into new world...");
        System.out.println();
    }

    public static void startGame() {
        System.out.println("Welcome to the World of Anima");
        System.out.println();
        enemySelection();

    }

    private static void enemySelection() {
        System.out.printf("%28s%-23s\n", "Round ", Round);
        System.out.printf("%28s%-23s\n", "Choose an enemy", " to fight");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < MOBNUM; i++) {
            mobs[i] = new Mob();
        }
        System.out.printf("%-23s%-23s%s\n", "Enemy #1", "Enemy #2", "Enemy #3");
        System.out.printf("%-23s%-23s%s\n", mobs[0].getName(), mobs[1].getName(), mobs[2].getName());
        System.out.printf("%-23s%-23s%s\n", "Health: " + mobs[0].getHealth(),"Health: " + mobs[1].getHealth(), "Health: " + mobs[2].getHealth());
        System.out.printf("%-23s%-23s%s\n", "Attack: " + mobs[0].getAttack(),"Attack: " + mobs[1].getAttack(), "Attack: " + mobs[2].getAttack());
        System.out.printf("%-23s%-23s%s\n", "Defense: " + mobs[0].getDefense(),"Defense: " + mobs[1].getDefense(), "Defense: " + mobs[2].getDefense());
        System.out.printf("%-23s%-23s%s\n", "Speed: " + mobs[0].getSpeed(),"Speed: " + mobs[1].getSpeed(), "Speed: " + mobs[2].getSpeed());
    }
}
