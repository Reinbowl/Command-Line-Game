public class Monster extends Attributes {
    protected String name;
    protected int[] attackPattern;
    protected int patternNum;

    public Monster(String name, int health, int attack, int defense) {
        super(health, attack, defense);
        setName(name);
        attackPattern = AttackPattern.getPattern(name);
        patternNum = 0;
    }

    public void nextPattern() {
        patternNum++;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
