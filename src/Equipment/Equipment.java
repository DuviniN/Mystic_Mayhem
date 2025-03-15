package Equipment;
import Character.Character;



public abstract class Equipment {
    private double price;

    protected void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }

    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);
}
