package Character.Healers;
import Character.Character;

public class Lightbringer extends Healer {
    public Lightbringer(){
        super.setPrice(260);
        super.setAttack(17);
        super.setDefence(15);
        super.setHealth(19);
        super.setSpeed(12);
    }
    public void setBattleGround(String homeGround){
        switch (homeGround){
            case "Hillcrest":
                super.setSpeed(super.getSpeed()-1);
                break;
            case "Marchland":
                super.setAttack(super.getAttack()-1);
                break;
            case "Desert":
                super.setAttack(super.getAttack()+1);
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
                super.setAttack(super.getAttack()+1);
                break;
            case "Desert":
                super.setAttack(super.getAttack()-1);
                break;
            default:
                break;
        }
    }
    public void heal(Character character){

    }
}
