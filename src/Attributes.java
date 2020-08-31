public class Attributes {
    protected int health;
    protected int attack;
    protected int defense;

    public Attributes(int health, int attack, int defense) {
        setHealth(health);
        setAttack(attack);
        setDefense(defense);
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

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
