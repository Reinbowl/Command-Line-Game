public class AttackPattern {
    private static final int ATTACK = 0;
    private static final int BLOCK =  1;

    private static final int[] CHICKEN_PATTERN = {ATTACK};
    private static final int[] DOG_PATTERN = {ATTACK, ATTACK, BLOCK};
    private static final int[] BOAR_PATTERN = {ATTACK, BLOCK, BLOCK};

    public static int[] getPattern(String mobName) {
        switch (mobName) {
        case "chicken":
            return CHICKEN_PATTERN;
        case "dog":
            return DOG_PATTERN;
        case "boar":
            return BOAR_PATTERN;
        default:
            return new int[]{};
        }
    }
}
