package Character.Mages;
import Character.Character;

public class Eldritch extends Mage {
    public Eldritch(){
        super.setPrice(270);
        super.setAttack(19);
        super.setDefence(17);
        super.setHealth(18);
        super.setSpeed(14);
    }
    public void setBattleGround(String homeGround){
        switch (homeGround){
            case "Marchland":
                super.setSpeed(super.getSpeed()-1);
                break;
            case "Arcane":
                super.setSpeed(super.getSpeed()+2);
                break;
            default:
                break;
        }
    }
    public void resetBattleGround(String homeGround) {
        switch (homeGround) {
            case "Marchland":
                super.setSpeed(super.getSpeed()+1);
                break;
            case "Arcane":
                super.setSpeed(super.getSpeed()-2);
                break;
            default:
                break;
        }
    }
    public void attack(Character character){

    }
}
