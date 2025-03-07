package Equipment.Armour;
import Character.Character;

public class Fleece extends Armour{
    public Fleece(){
        super.setPrice(150);
    }
    public void defence(Character character) {
        character.setDefence(character.getDefence()+2);
    }
    public void speed(Character character) {
        character.setSpeed(character.getSpeed()-1);
    }

    public void health(Character character) {
        character.setHealth(character.getHealth()+1);
    }
    public void attack(Character character) {
        character.getAttack();
    }
}
