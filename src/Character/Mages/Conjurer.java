package Character.Mages;
import Character.Character;
public class Conjurer extends Mage {
    public Conjurer(){
        super.setPrice(195.0);
        super.setAttack(18);
        super.setDefence(15);
        super.setHealth(14.0);
        super.setSpeed(12);
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
        super.setHealth(14.0);
    }
    public void attack(Character opponent){
        double newHealth;
        newHealth=opponent.getHealth()-0.5*(super.getAttack())-0.1*(opponent.getDefence());
        if(newHealth<=0){
            opponent.setHealth(0);
            System.out.println(opponent.getClass().getSimpleName()+" died");
            System.out.println("Conjurer attacks "+opponent.getClass().getSimpleName());
        }
        else{
            opponent.setHealth(newHealth);
            System.out.println("Conjurer attacks "+opponent.getClass().getSimpleName());
            System.out.println(opponent.getClass().getSimpleName()+"'s new health : "+" "+newHealth);
        }
    }
}
