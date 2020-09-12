import action.Actions;
import action.Phase;

import attribute.Mob;
import attribute.Monster;
import attribute.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static String userInput;
    private static final Scanner input = new Scanner(System.in);

    private static int Round = 1;
    private static int mobChosen;
    private static Player player;
    private static final int MOBNUM = 3;
    private static final ArrayList<Monster> mobs = new ArrayList<>();

    private static final String SPACING = "%-23s";
    private static final String[] PRINT_ORDER = {"N", "H", "A", "D", "S"};

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
        if (Data.loadData()) {
            System.out.println("Welcome back " + player.getName() + ".");
        } else {
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
            Data.saveData();
            System.out.println();
            System.out.println("Now loading into new world...");
            System.out.println();
            Data.closeFile();
        }
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
            Monster selectedMob = mobs.get(mobChosen - 1);
            System.out.println("Guess your fighting a " + selectedMob.getName() + ".");
            boolean isMobDefeated = false;
            while (!isMobDefeated) {
                player.setAction(getPlayerAction());
                switch (Phase.attackPhase(player, selectedMob)) {
                case DEFEAT:
                    System.out.println("Guess fighting a " + selectedMob.getName() + " was too tough eh.");
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
        System.out.println("Round " + Round);
        System.out.println("Choose an enemy to fight");
        System.out.println("--------------------------------------------------------");
        mobs.clear();
        for (int i = 1; i <= MOBNUM; i++) {
            mobs.add(new Mob());
        }
        printEnemy();
        printAttributes();
    }

    private static void printEnemy() {
        for (int i = 1; i <= MOBNUM; i++) {
            System.out.printf(SPACING, "Enemy #" + i);
        }
        System.out.println();
    }

    private static void printAttributes() {
        for (String s : PRINT_ORDER) {
            for (Monster m : mobs) {
                switch (s) {
                case "N":
                    System.out.printf(SPACING, m.getName());
                    break;
                case "H":
                    System.out.printf(SPACING, "Health: " + m.getMaxHealth());
                    break;
                case "A":
                    System.out.printf(SPACING, "Attack: " + m.getAttack());
                    break;
                case "D":
                    System.out.printf(SPACING, "Defense: " + m.getDefense());
                    break;
                case "S":
                    System.out.printf(SPACING, "Speed: " + m.getSpeed());
                    break;
                }
            }
            System.out.println();
        }
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
        if (player.getAction() == Actions.ATTACK) {
            return Actions.BLOCK;
        }
        return Actions.PBLOCK;
    }

    public static Player getPlayer() {
        return player;
    }

    public static int getRound() {
        return Round;
    }

    public static void setPlayer(Player player) {
        Game.player = player;
    }

    public static void setRound(int round) {
        Round = round;
    }
}
