package Character.Healers;
import Character.Character;

public class Medic extends Healer {
    public Medic(){
        super.setPrice(125.0);
        super.setAttack(12);
        super.setDefence(9);
        super.setHealth(10.0);
        super.setSpeed(7);
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
    public void setDefaultHealth(){
        super.setHealth(10.0);
    }
    public void heal(Character character){
        double newHealth;
        newHealth=character.getHealth()+0.1*(super.getAttack());
        character.setHealth(newHealth);
        System.out.println("Alchemist heals "+character.getClass().getSimpleName());
        System.out.println(character.getClass().getSimpleName()+"'s New Health:"+newHealth);

    }
}
