package Equipment;


public abstract class Equipment {
    private int price;
    public Equipment(int price) {
        this.price = price;
    }
    public Equipment() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void attack();
    public abstract void defence();
    public abstract void health();
    public abstract void speed();
}
