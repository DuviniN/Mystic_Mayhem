package Character.Healers;
import Character.Character;

public class Saint extends Healer {
    public Saint(){
        super.setPrice(200);
        super.setAttack(16);
        super.setDefence(14);
        super.setHealth(17);
        super.setSpeed(9);
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
    public void heal(Character character){

    }
}
