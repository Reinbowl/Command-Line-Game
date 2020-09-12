package action;

import attributes.Attributes;
import attributes.Monster;
import attributes.Player;

public class Phase {
    public static Result attackPhase(Player player, Monster monster) {
        if (player.getAction() != Actions.ATTACK && monster.getAction() != Actions.ATTACK) {
            System.out.printf("Both %s and %s block at the same time. Nothing happens.\n", player.getName(), monster.getName());
            return Result.UNDECIDED;
        }
        Attributes attacker, defender;
        if (player.getSpeed() > monster.getSpeed()) {
            attacker = player;
            defender = monster;
        } else {
            attacker = monster;
            defender = player;
        }
        fight(attacker, defender);
        switch (endTurn(player, monster)) {
        case VICTORY:
            return Result.VICTORY;
        case DEFEAT:
            return Result.DEFEAT;
        }
        fight(defender, attacker);
        return (endTurn(player, monster));
    }

    private static void fight(Attributes attacker, Attributes defender) {
        if (attacker.getAction() == Actions.ATTACK) {
            switch (defender.getAction()) {
            case Actions.ATTACK:
                Actions.Attack(attacker, defender);
                break;
            case Actions.BLOCK:
                Actions.Block(attacker, defender);
                break;
            default:
                Actions.Pblock(attacker, defender);
            }
        }
    }

    public static Result endTurn(Attributes player, Attributes monster) {
        if (player.getCurrHealth() > 0) {
            return (monster.getCurrHealth() > 0) ? Result.UNDECIDED : Result.VICTORY;
        } else {
            return Result.DEFEAT;
        }
    }
}
