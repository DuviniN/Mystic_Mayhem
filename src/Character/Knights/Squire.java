package Character.Knights;
import Character.Character;

public class Squire extends Knight {
    public Squire(){
        super.setPrice(85);
        super.setAttack(8);
        super.setDefence(9);
        super.setHealth(7);
        super.setSpeed(8);

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
