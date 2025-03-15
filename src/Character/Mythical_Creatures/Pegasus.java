package Character.Mythical_Creatures;
import Character.Character;

public class Pegasus extends Mythical_Creature {
    public Pegasus(){
        super.setPrice(340);
        super.setAttack(14);
        super.setDefence(18);
        super.setHealth(20);
        super.setSpeed(20);
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
