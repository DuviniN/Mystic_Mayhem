package Equipment.Artefacts;
import Character.Character;

public class Amulet extends Artefacts{

    public Amulet(){
        super.setPrice(200);
    }

    public void equipto(Character character){
        character.setAttack(character.getAttack() + 1);
        character.setSpeed(character.getSpeed() +1);
        character.setDefence(character.getDefence() -1);
        character.setHealth(character.getHealth() +1);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removefrom(Character character){
        character.setDefence(character.getDefence() +1);
        character.setSpeed(character.getSpeed() -1);
        character.setAttack(character.getAttack() -1);
        character.setHealth(character.getHealth() -1);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
