package Character;
public abstract class Character {
    private int price;
    private int attack;
    private int defence;
    private int health;
    private int speed;

    public Character(int price,int attack,int defence,int  health,int speed) {
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;

    }

    public Character(){

    }

    public int getPrice() {
        return price;
    }

    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public int getHealth() {
        return health;
    }
    public int getSpeed() {
        return speed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
