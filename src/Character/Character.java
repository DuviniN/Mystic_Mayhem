package Character;

import Equipment.Armour.Armour;
import Equipment.Artefact.Artefact;

public abstract class Character {
    private double price;
    private int attack;
    private int defence;
    private double health;
    private int speed;
    private Armour armour;
    private Artefact artefact;




    public double getPrice() {
        return price;
    }

    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public double getHealth() {
        return health;
    }
    public int getSpeed() {
        return speed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setArmour(Armour armour){
        this.armour=armour;
    }
    public void removeArmour(){
        this.armour=null;
    }
    public void setArtefact(Artefact artefact){
        this.artefact=artefact;
    }
    public void removeArtefact(){
        this.artefact=null;
    }
    public boolean isArmour(){
        return armour!=null;
    }
    public boolean isArtefact(){
        return artefact!=null;
    }
    public abstract void setBattleGround(String homeGround);
    public abstract void resetBattleGround(String homeGround);


}
