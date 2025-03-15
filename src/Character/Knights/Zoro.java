package Character.Knights;
import Character.Character;

public class Zoro extends Knight {
    public Zoro(){
        super.setPrice(180);
        super.setAttack(17);
        super.setDefence(16);
        super.setHealth(13);
        super.setSpeed(14);
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
