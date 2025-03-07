package Equipment;

public abstract class Equipment {

    private int price;
    private String attack;
    private int defence;
    private String health;
    private int speed;

    public Equipment(int price,String attack,int defence,String health,int speed){
        this.price=price;
        this.attack=attack;
        this.defence=defence;
        this.health=health;
        this.speed=speed;
    }
    public Equipment(){

    }

    public int getPrice() {
        return price;
    }

    public String getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
