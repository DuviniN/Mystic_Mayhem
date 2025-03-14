import Character.Archers.Archer;
import Character.Character;
import Character.Healers.Healer;
import Character.Knights.Knight;
import Character.Mages.Mage;
import Character.Mythical_Creatures.Mythical_Creature;
import Equipment.Equipment;
import java.util.Scanner;

public class User {

    private String user_name;
    private String name;
    private int gold_coins=500;
    private int user_ID;
    private int xp;
    Archer archer;
    Healer healer;
    Knight knight;
    Mage mage;
    Mythical_Creature mythicalCreature;




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

    public void display (){
        System.out.println("User name: "+user_name);
        System.out.println("Name: "+name);
        System.out.println("Gold coins: "+gold_coins);
        System.out.println("User ID: "+user_ID);
        System.out.println("XP: "+xp);
        System.out.println("Army");
        System.out.println(archer);
        System.out.println(healer);
        System.out.println(knight);
        System.out.println(mage);
        System.out.println(mythicalCreature);

    }
}
