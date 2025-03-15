package Equipment.Artefact;
import Character.Character;

public class Amulet extends Artefact {

    public Amulet(){
        super.setPrice(200);
    }

    public void getEquipment(Character character){
        character.setAttack(character.getAttack() + 1);
        character.setSpeed(character.getSpeed() +1);
        character.setDefence(character.getDefence() -1);
        character.setHealth(character.getHealth() +1);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removeEquipment(Character character){
        character.setDefence(character.getDefence() +1);
        character.setSpeed(character.getSpeed() -1);
        character.setAttack(character.getAttack() -1);
        character.setHealth(character.getHealth() -1);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
