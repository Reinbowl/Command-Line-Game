import java.util.Random;

public class Player extends Attributes {
    private static final Random rand = new Random();
    private static final int BASE_HEALTH = 5;
    private static final int HEALTH_RANGE = 6;
    private static final int BASE_ATTACK = 2;
    private static final int ATTACK_RANGE = 3;
    private static final int BASE_DEFENSE = 2;
    private static final int DEFENSE_RANGE = 3;
    private static final int BASE_SPEED = 5;
    private static final int SPEED_RANGE = 6;

    protected int action;

    public Player(String name) {
        super(name,
                rand.nextInt(HEALTH_RANGE) + BASE_HEALTH,
                rand.nextInt(ATTACK_RANGE) + BASE_ATTACK,
                rand.nextInt(DEFENSE_RANGE) + BASE_DEFENSE,
                rand.nextInt(SPEED_RANGE) + BASE_SPEED);
    }

    @Override
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("Health: %d\nAttack: %d\nDefense: %d\nSpeed: %d", maxHealth, attack, defense, speed);
    }
}
