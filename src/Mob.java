import java.util.Random;

public class Mob extends Monster {
    private static final Random rand = new Random();
    private static final String[] mobNames = {"Chicken", "Dog", "Boar"};
    private static final int BASE_HEALTH = 3;
    private static final int HEALTH_RANGE = 3;
    private static final int BASE_ATTACK = 1;
    private static final int ATTACK_RANGE = 3;
    private static final int BASE_DEFENSE = 1;
    private static final int DEFENSE_RANGE = 3;
    private static final int BASE_SPEED = 3;
    private static final int SPEED_RANGE = 5;

    public Mob() {
        super(mobNames[rand.nextInt(mobNames.length)],
                rand.nextInt(HEALTH_RANGE) + BASE_HEALTH,
                rand.nextInt(ATTACK_RANGE) + BASE_ATTACK,
                rand.nextInt(DEFENSE_RANGE) + BASE_DEFENSE,
                rand.nextInt(SPEED_RANGE) + BASE_SPEED);
    }
}
