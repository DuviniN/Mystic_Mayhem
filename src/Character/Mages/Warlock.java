package Character.Mages;
import Character.Character;
import Character.CharacterState;

public class Warlock extends Mage {
    public Warlock(){
        super.setPrice(100.0);
        super.setAttack(12);
        super.setDefence(7);
        super.setHealth(10.0);
        super.setSpeed(12);
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
        super.setHealth(10.0);
    }
    public void attack(Character opponent){
        double newHealth;
        newHealth=opponent.getHealth()-0.5*(super.getAttack())-0.1*(opponent.getDefence());

        if(newHealth<=0){
            opponent.setHealth(0);
            opponent.setState(CharacterState.DEATH);
            System.out.println(opponent.getClass().getSimpleName()+" died");
            System.out.println("Warlock attacks "+opponent.getClass().getSimpleName());
        }
        else{
            opponent.setHealth(newHealth);
            System.out.println("Warlock attacks "+opponent.getClass().getSimpleName());
            System.out.println(opponent.getClass().getSimpleName()+"'s new health : "+" "+newHealth);
        }
    }
}
