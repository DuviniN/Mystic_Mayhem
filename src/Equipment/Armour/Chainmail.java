package Equipment.Armour;
import Character.Character;
public class Chainmail extends Armour {

    public Chainmail(){
        super.setPrice(70);
    }

    public void defence(Character character) {
        character.setDefence(character.getDefence()+1);
    }
    public void speed(Character character) {
        character.setSpeed(character.getSpeed()-1);
    }

    public void health(Character character) {
        character.getHealth();
    }
    public void attack(Character character) {
        character.getAttack();
    }
}
