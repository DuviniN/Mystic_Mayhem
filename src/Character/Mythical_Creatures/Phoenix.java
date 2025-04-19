package Character.Mythical_Creatures;
import Character.Character;
import Character.CharacterState;

public class Phoenix extends Mythical_Creature {
    public Phoenix(){
        super.setPrice(275.0);
        super.setAttack(17);
        super.setDefence(13);
        super.setHealth(17.0);
        super.setSpeed(19);
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
        super.setHealth(17.0);
    }
    public void attack(Character opponent){
        double newHealth;
        newHealth=opponent.getHealth()-0.5*(super.getAttack())-0.1*(opponent.getDefence());

        if(newHealth<=0){
            opponent.setHealth(0);
            opponent.setState(CharacterState.DEATH);
            System.out.println(opponent.getClass().getSimpleName()+" died");
            System.out.println("Phoenix attacks "+opponent.getClass().getSimpleName());
        }
        else{
            opponent.setHealth(newHealth);
            System.out.println("Phoenix attacks "+opponent.getClass().getSimpleName());
            System.out.println(opponent.getClass().getSimpleName()+"'s new health : "+" "+newHealth);
        }
    }

}
