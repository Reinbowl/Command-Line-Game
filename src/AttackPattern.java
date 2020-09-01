public class AttackPattern {
    private static final int[] CHICKEN_PATTERN = {Actions.ATTACK};
    private static final int[] DOG_PATTERN = {Actions.ATTACK, Actions.ATTACK, Actions.BLOCK};
    private static final int[] BOAR_PATTERN = {Actions.ATTACK, Actions.BLOCK, Actions.BLOCK};

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
