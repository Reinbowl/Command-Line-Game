public class Actions {
    public static final int ATTACK = 0;
    public static final int BLOCK =  1;

    public static void Attack(Attributes attacker, Attributes defender) {
        int damageDealt = attacker.getAttack() - defender.getDefense();
        if (damageDealt > 0) {
            int newHealth = defender.getHealth() - damageDealt;
            defender.setHealth(newHealth);
        }
    }
}
