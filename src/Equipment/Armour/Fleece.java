package Equipment.Armour;
import Character.Character;

public class Fleece extends Armour{

    public Fleece(){
        super.setPrice(150.0);
    }

    public void getEquipment(Character character){
        character.setDefence(character.getDefence() + 2);
        character.setHealth(character.getHealth() +1);
        character.setSpeed(character.getSpeed() - 1);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removeEquipment(Character character){
        character.setDefence(character.getDefence() - 2);
        character.setHealth(character.getHealth() - 1);
        character.setSpeed(character.getSpeed() + 1);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
