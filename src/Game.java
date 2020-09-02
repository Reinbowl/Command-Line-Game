import java.util.Scanner;
import java.util.Random;

public class Game {
    private static String userInput;
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();

    private static int Round = 1;
    private static int mobChosen;
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

    private static boolean chooseMob() {
        try {
            mobChosen = Integer.parseInt(input.nextLine());
            return mobChosen <= MOBNUM;
        } catch (NumberFormatException e) {
            return false;
        }
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
        boolean isGameEnded = false;
        while (!isGameEnded) {
            enemySelection();
            while (!chooseMob()) {
                System.out.println("Enter one of the enemy number.");
            }
            Monster selectedMob = mobs[mobChosen - 1];
            System.out.println("Guess your fighting a " + selectedMob.getName() + ".");
            boolean isMobDefeated = false;
            while (!isMobDefeated) {
                player.setAction(getPlayerAction());
                switch (Phase.attackPhase(player,selectedMob)) {
                case DEFEAT:
                    System.out.println("Guess fighting a " +selectedMob.getName() + " was too tough eh.");
                    System.out.println("Well you made it to round " + Round + ".");
                    isMobDefeated = true;
                    isGameEnded = true;
                    break;
                case VICTORY:
                    System.out.println("Easy win.");
                    player.heal();
                    isMobDefeated = true;
                    Round++;
                    break;
                }
                selectedMob.nextAction();
            }
        }
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
        System.out.printf("%-23s%-23s%s\n", "Health: " + mobs[0].getMaxHealth(),"Health: " + mobs[1].getMaxHealth(), "Health: " + mobs[2].getMaxHealth());
        System.out.printf("%-23s%-23s%s\n", "Attack: " + mobs[0].getAttack(),"Attack: " + mobs[1].getAttack(), "Attack: " + mobs[2].getAttack());
        System.out.printf("%-23s%-23s%s\n", "Defense: " + mobs[0].getDefense(),"Defense: " + mobs[1].getDefense(), "Defense: " + mobs[2].getDefense());
        System.out.printf("%-23s%-23s%s\n", "Speed: " + mobs[0].getSpeed(),"Speed: " + mobs[1].getSpeed(), "Speed: " + mobs[2].getSpeed());
    }

    private static int getPlayerAction() {
        boolean isAnAction = false;
        do {
            userInput = input.nextLine().trim();
            switch (userInput.toLowerCase()) {
            case "attack":
                return Actions.ATTACK;
            case "block":
                isAnAction = true;
                break;
            default:
                System.out.println("Choose an action: attack or block.");
            }
        } while (!isAnAction);
        if(player.getAction() == Actions.ATTACK) {
            return Actions.BLOCK;
        }
        return Actions.PBLOCK;
    }
}
