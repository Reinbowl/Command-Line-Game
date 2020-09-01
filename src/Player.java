public class Player extends Attributes {
    protected int action;

    public Player(String name, int health, int attack, int defense, int speed) {
        super(name, health, attack, defense, speed);
    }

    @Override
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
