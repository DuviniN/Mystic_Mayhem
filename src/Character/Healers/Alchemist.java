package Character.Healers;
import Character.Character;
public class Alchemist extends Healer {
    public Alchemist(){
        super.setPrice(150.0);
        super.setAttack(13);
        super.setDefence(13);
        super.setHealth(13.0);
        super.setSpeed(13);
    }
    public void setBattleGround(String homeGround){
        switch (homeGround){
            case "Hillcrest":
                super.setSpeed(super.getSpeed()-1);
                break;
            case "Marchland":
                super.setDefence(super.getDefence()+2);
                break;
            case "Desert":
                super.setHealth(super.getHealth()-1);
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
                super.setSpeed(super.getSpeed()+1);
                break;
            case "Marchland":
                super.setDefence(super.getDefence()-2);
                break;
            case "Desert":
                super.setHealth(super.getHealth()+1);
                break;
            case "Arcane":
                super.setDefence(super.getDefence()+1);
                super.setSpeed(super.getSpeed()+1);
                break;
            default:
                break;
        }
    }
    public void setDefaultHealth(){
        super.setHealth(13.0);
    }
    public void heal(Character character){
        double newHealth;
        newHealth=character.getHealth()+0.1*(super.getAttack());

        character.setHealth(newHealth);
        System.out.println("Alchemist heals "+character.getClass().getSimpleName());
        System.out.println(character.getClass().getSimpleName()+"'s New Health:"+newHealth);

    }
}
