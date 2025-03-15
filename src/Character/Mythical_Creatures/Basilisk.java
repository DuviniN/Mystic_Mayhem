package Character.Mythical_Creatures;
import Character.Character;

public class Basilisk extends Mythical_Creature {
    public Basilisk(){
        super.setPrice(165);
        super.setAttack(15);
        super.setDefence(11);
        super.setHealth(10);
        super.setSpeed(12);
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
    public void attack(Character character){

    }
}
