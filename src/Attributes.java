public class Attributes {
    protected String name;
    protected int maxHealth;
    protected int currHealth;
    protected int attack;
    protected int defense;
    protected int speed;

    public Attributes(String name, int health, int attack, int defense, int speed) {
        setName(name);
        setMaxHealth(health);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
        heal();
    }

    public int getAction() {
        return 0;
    }

    public void heal() {
        currHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrHealth() {
        return currHealth;
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

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
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
