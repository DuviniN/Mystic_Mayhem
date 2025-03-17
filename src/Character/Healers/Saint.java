package Character.Healers;
import Character.Character;

public class Saint extends Healer {
    public Saint(){
        super.setPrice(200.0);
        super.setAttack(16);
        super.setDefence(14);
        super.setHealth(17.0);
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
    public void setDefaultHealth(){
        super.setHealth(17.0);
    }
    public void heal(Character character){
        double newHealth;
        newHealth=character.getHealth()+0.1*(super.getAttack());
        character.setHealth(newHealth);
        System.out.println("Alchemist heals "+character.getClass().getSimpleName());
        System.out.println(character.getClass().getSimpleName()+"'s New Health:"+newHealth);

    }
}
