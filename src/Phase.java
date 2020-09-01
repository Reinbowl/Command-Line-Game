public class Phase {
    public static Result attackPhase(Player player, Monster monster) {
        Attributes attacker, defender;
        if (player.getSpeed() > monster.getSpeed()) {
            attacker = player;
            defender = monster;
        } else {
            attacker = monster;
            defender = attacker;
        }

        switch (defender.getAction()) {
        case Actions.BLOCK:
            break;
        default:
            Actions.Attack(attacker, defender);
        }
        switch (endPhase(player, monster)) {
        case VICTORY:
            return Result.VICTORY;
        case DEFEAT:
            return Result.DEFEAT;
        default:
            switch (attacker.getAction()) {
            case Actions.BLOCK:
                break;
            default:
                Actions.Attack(defender, attacker);
            }
        }
        return (endPhase(player, monster));
    }

    public static Result endPhase(Attributes player, Attributes monster) {
        if (player.getHealth() > 0) {
            return (monster.getHealth() > 0) ? Result.UNDECIDED : Result.VICTORY;
        } else {
            return Result.DEFEAT;
        }
    }
}
