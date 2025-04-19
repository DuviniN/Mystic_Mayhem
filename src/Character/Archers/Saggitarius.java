package Character.Archers;

import Character.Archers.Archer;
import Character.Character;
import Character.CharacterState;

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
    public void setDefaultHealth(){
        super.setHealth(12.0);
    }
    public void attack(Character opponent){
        double newHealth;
        newHealth=opponent.getHealth()-0.5*(super.getAttack())-0.1*(opponent.getDefence());

        if(newHealth<=0){
            opponent.setHealth(0);
            opponent.setState(CharacterState.DEATH);
            System.out.println(opponent.getClass().getSimpleName()+" died");
            System.out.println("Saggitarius attacks "+opponent.getClass().getSimpleName());
        }
        else{
            opponent.setHealth(newHealth);
            System.out.println("Saggitarius attacks "+opponent.getClass().getSimpleName());
            System.out.println(opponent.getClass().getSimpleName()+"'s new health : "+" "+newHealth);
        }
    }
}
