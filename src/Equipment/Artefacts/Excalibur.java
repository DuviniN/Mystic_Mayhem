package Equipment.Artefacts;
import Character.Character;

public class Excalibur extends Artefacts{

    public Excalibur(){
        super.setPrice(150);
    }
    public void defence(Character character) {
        character.getDefence();
    }
    public void speed(Character character) {
        character.getSpeed();
    }

    public void health(Character character) {
        character.getHealth();
    }
    public void attack(Character character) {
        character.setAttack(character.getAttack()+2);
    }
}
