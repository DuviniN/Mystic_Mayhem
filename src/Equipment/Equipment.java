package Equipment;


public abstract class Equipment {
    private int price;

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }

    public abstract void equipto(Character character);
    public abstract void removefrom(Character character);
}
