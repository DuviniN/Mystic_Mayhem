import java.text.SimpleDateFormat;
import java.util.Date;
public class User {
    private String name;
    private String username;
    private int userId;
    private double goldCoin;
    private Guild guild;
    private int xp;
    private static int  usercount=0;

    public User(String name,String username){
        this.name=name;
        this.username=username;
        goldCoin=500;
        xp=0;
        userId=createUserId();
        guild=new Guild();
        usercount++;
    }
    private int createUserId(){
        Date dNow=new Date();
        SimpleDateFormat ft=new SimpleDateFormat("yyMMdd");
        String date= ft.format(dNow);
        String ID= date + usercount;
        return Integer.parseInt(ID);
    }

    public String getName(){
        return name;
    }
    public String getUsername(){
        return  username;
    }
    public int getUserId(){
        return userId;
    }
    public int getXp(){
        return xp;
    }

    public double getGoldCoin() {
        return goldCoin;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public void setGoldCoin(double goldCoin) {
        this.goldCoin = goldCoin;
    }

    public String toString(){
        return String.format("""
                Name: %s
                Gold Coin: %d
                XP: %d
                Archer: %s
                Knight: %s
                Mage: %s
                Healer: %s
                Mythical Creature: %s
                """,username,goldCoin,xp,guild.getArcher().getClass().getSimpleName(),guild.getKnight().getClass().getSimpleName(),guild.getHealer().getClass().getSimpleName(),guild.getMage().getClass().getSimpleName(),guild.getMythical_Creature().getClass().getSimpleName());

    }

}
