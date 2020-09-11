package attribute;

import action.AttackPattern;

public class Monster extends Attributes {
    protected int[] attackPattern;
    protected int patternNum;

    public Monster(String name, int health, int attack, int defense, int speed) {
        super(name, health, attack, defense, speed);
        attackPattern = AttackPattern.getPattern(name);
        patternNum = 0;
    }

    @Override
    public int getAction() {
        return attackPattern[patternNum];
    }

    public void nextAction() {
        patternNum = (patternNum+1)%attackPattern.length;
    }
}
