package Character.Mythical_Creatures;
import Character.Character;

public class Phoenix extends Mythical_Creature {
    public Phoenix(){
        super.setPrice(275);
        super.setAttack(17);
        super.setDefence(13);
        super.setHealth(17);
        super.setSpeed(19);
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
    public void attack(Character character){

    }
}
