package action;

import attribute.Attributes;

public class Actions {
    public static final int ATTACK = 0;
    public static final int BLOCK =  1;
    public static final int PBLOCK = 2;

    public static void Attack(Attributes attacker, Attributes defender) {
        int damageDealt = attacker.getAttack();
        if (damageDealt > 0) {
            System.out.printf("%s attacks %s for %d damage.\n", attacker.getName(), defender.getName(), damageDealt);
            int newHealth = defender.getCurrHealth() - damageDealt;
            defender.setCurrHealth(newHealth);
        }
    }

    public static void Block(Attributes attacker, Attributes defender) {
        int damageDealt = attacker.getAttack() - defender.getDefense();
        if (damageDealt > 0) {
            System.out.printf("%s attacks while %s blocks, dealing %d damage instead.\n", attacker.getName(), defender.getName(), damageDealt);
            int newHealth = defender.getCurrHealth() - damageDealt;
            defender.setCurrHealth(newHealth);
        } else {
            System.out.printf("%s blocks %s attack completely.\n", defender.getName(), attacker.getName());
        }
    }

    public static void Pblock(Attributes attacker, Attributes defender) {
        int damageDealt = attacker.getAttack() - (int)Math.ceil(defender.getDefense()/2.0);
        if (damageDealt > 0) {
            System.out.printf("%s attacks while %s blocks again, dealing %d damage instead.\n", attacker.getName(), defender.getName(), damageDealt);
            int newHealth = defender.getCurrHealth() - damageDealt;
            defender.setCurrHealth(newHealth);
        } else {
            System.out.printf("%s blocks %s attack completely.\n", defender.getName(), attacker.getName());
        }
    }
}
