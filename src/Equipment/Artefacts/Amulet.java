package Equipment.Artefacts;
import Character.Character;

public class Amulet extends Artefacts{
    public Amulet(){
        super.setPrice(200);
    }
    public void defence(Character character) {
        character.setDefence(character.getDefence()-1);
    }
    public void speed(Character character) {
        character.setSpeed(character.getSpeed()+1);
    }

    public void health(Character character) {
        character.setHealth(character.getHealth()+1);
    }
    public void attack(Character character) {
        character.setAttack(character.getAttack()+1);
    }
}
