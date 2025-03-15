package Character.Archers;

import Character.Archers.Archer;
import Character.Character;

public class Saggitarius extends Archer {
    public Saggitarius(){
        super.setPrice(230.0);
        super.setAttack(18);
        super.setDefence(7);
        super.setHealth(12.0);
        super.setSpeed(17);
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
    public void attact(Character character){

    }
}
