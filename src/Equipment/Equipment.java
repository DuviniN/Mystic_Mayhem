package Equipment;
import Character.Character;



public abstract class Equipment {
    private int price;

    protected void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }

    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);
}
