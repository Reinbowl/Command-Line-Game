import java.util.Scanner;
import java.util.Random;

public class Game {
    private static String userInput;
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final int BASE_HEALTH = 5;
    private static final int BASE_ATTACK = 2;
    private static final int BASE_DEFENSE = 2;
    private static final int BASE_SPEED = 5;

    private static Player player;

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
            System.out.println("Confirm your name is " + userInput + ".");
        } while (!userChoice());
        System.out.println();

        do {
            player = new Player(userInput,
                    rand.nextInt(6) + BASE_HEALTH,
                    rand.nextInt(3) + BASE_ATTACK,
                    rand.nextInt(3) + BASE_DEFENSE,
                    rand.nextInt(6) + BASE_SPEED);
            System.out.println("This is your player stats:\n" + player);
            System.out.println("Do you want to reroll stats?");
        } while (userChoice());
        System.out.println();

        System.out.println("Now loading into new world...");
    }
}
