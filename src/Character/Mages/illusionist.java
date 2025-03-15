package Character.Mages;
import Character.Character;

public class illusionist extends Mage {
    public illusionist(){
        super.setPrice(120);
        super.setAttack(13);
        super.setDefence(8);
        super.setHealth(12);
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
