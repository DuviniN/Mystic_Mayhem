package Character.Healers;
import Character.Character;

public class Lightbringer extends Healer {
    public Lightbringer(){
        super.setPrice(260.0);
        super.setAttack(17);
        super.setDefence(15);
        super.setHealth(19.0);
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
    public void setDefaultHealth(){
        super.setHealth(19.0);
    }
    public void heal(Character character){
        double newHealth;
        newHealth=character.getHealth()+0.1*(super.getAttack());
        character.setHealth(newHealth);
        System.out.println("Alchemist heals "+character.getClass().getSimpleName());
        System.out.println(character.getClass().getSimpleName()+"'s New Health:"+newHealth);

    }
}
