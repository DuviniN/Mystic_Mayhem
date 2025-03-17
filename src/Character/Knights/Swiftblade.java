package Character.Knights;
import Character.Character;

public class Swiftblade extends Knight {
    public Swiftblade() {
        super.setPrice(250.0);
        super.setAttack(18);
        super.setDefence(20);
        super.setHealth(17.0);
        super.setSpeed(13);
    }
    public void setBattleGround(String homeGround){
        switch (homeGround){
            case "Hillcrest":
                super.setSpeed(super.getSpeed()-1);
                break;
            case "Marchland":
                super.setDefence(super.getDefence()+2);
                break;
            case "Desert":
                super.setHealth(super.getHealth()-1);
                break;
            case "Arcane":
                super.setDefence(super.getDefence()-1);
                super.setSpeed(super.getSpeed()-1);
                break;
            default:
                break;
        }
    }
    public void resetBattleGround(String homeGround){
        switch (homeGround){
            case "Hillcrest":
                super.setSpeed(super.getSpeed()+1);
                break;
            case "Marchland":
                super.setDefence(super.getDefence()-2);
                break;
            case "Desert":
                super.setHealth(super.getHealth()+1);
                break;
            case "Arcane":
                super.setDefence(super.getDefence()+1);
                super.setSpeed(super.getSpeed()+1);
                break;
            default:
                break;
        }
    }
    public void setDefaultHealth(){
        super.setHealth(17.0);
    }
    public void attack(Character opponent){
        double newHealth;
        newHealth=opponent.getHealth()-0.5*(super.getAttack())-0.1*(opponent.getDefence());
        if(newHealth<=0){
            opponent.setHealth(0);
            System.out.println(opponent.getClass().getSimpleName()+" died");
            System.out.println("Swiftblade attacks "+opponent.getClass().getSimpleName());
        }
        else{
            opponent.setHealth(newHealth);
            System.out.println("Swiftblade attacks "+opponent.getClass().getSimpleName());
            System.out.println(opponent.getClass().getSimpleName()+"'s new health : "+" "+newHealth);
        }
    }
}
