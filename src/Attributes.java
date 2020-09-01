public class Attributes {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int speed;

    public Attributes(String name, int health, int attack, int defense, int speed) {
        setName(name);
        setHealth(health);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }

    public int getAction() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }
}
