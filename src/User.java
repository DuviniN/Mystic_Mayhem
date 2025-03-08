import Character.Character;
import Equipment.Equipment;

public class User {

    private String user_name;
    private String name;
    private int gold_coins=500;
    private int user_ID;
    private int xp;
    Character[] characters = new Character[5];



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getUser_name(){
        return user_name;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }
    public int getGold_coins(){
        return gold_coins;
    }

    public void setGold_coins(int gold_coins) {
        this.gold_coins = gold_coins;
    }

    public int getUser_ID() {
        return user_ID;
    }
    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

    public void buyCharacter(Character character){
        if(gold_coins>=character.getPrice()){
            gold_coins-=character.getPrice();
            System.out.println("You have bought a "+character);
        }
        else{
            System.out.println("You don't have enough gold coins to buy this character");
        }
    }
    public void sellCharacter(Character character){
        gold_coins+=(character.getPrice()*90)/100;
        System.out.println("You have sold a "+character);
    }

    public void buyEquipment(Equipment equipment){
        if(gold_coins>=equipment.getPrice()){
            gold_coins-=equipment.getPrice();
            System.out.println("You have bought a "+equipment);
        }
        else{
            System.out.println("You don't have enough gold coins to buy this equipment");
        }
    }
    public void display (){
        System.out.println("User name: "+user_name);
        System.out.println("Name: "+name);
        System.out.println("Gold coins: "+gold_coins);
        System.out.println("User ID: "+user_ID);
        System.out.println("XP: "+xp);
        System.out.println("Army");
        for(Character charact:characters){
            System.out.println(characters);
        }

    }
}
