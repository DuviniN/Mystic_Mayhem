package Character.Archers;
import Character.Character;

public class Shooter extends Archer {

    public Shooter(){
        super.setPrice(80);
        super.setAttack(11);
        super.setDefence(4);
        super.setHealth(6);
        super.setSpeed(9);
    }
    public void setBattleGround(String homeGround){
        switch (homeGround){
            case "Hillcrest":
                super.setAttack(super.getAttack()+1);
                super.setDefence(super.getDefence()+1);
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
                super.setAttack(super.getAttack()-1);
                super.setDefence(super.getDefence()-1);
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
