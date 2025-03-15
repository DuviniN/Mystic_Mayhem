package Equipment;
import Character.Character;



public abstract class Equipment {
    private float price;

    protected void setPrice(float price){
        this.price=price;
    }
    public float getPrice(){
        return price;
    }

    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);
}
