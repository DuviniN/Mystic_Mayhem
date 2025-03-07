package Equipment.Armour;
import Character.Character;
public class Regalia extends Armour{
    public Regalia(){
        super.setPrice(105);
    }

    public void defence(Character character) {
        character.setDefence(character.getDefence()+1);
    }
    public void speed(Character character) {
        character.getSpeed();
    }

    public void health(Character character) {
        character.getHealth();
    }
    public void attack(Character character) {
        character.getAttack();
    }
}
