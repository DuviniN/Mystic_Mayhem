package Equipment.Artefact;
import Character.Character;

public class Excalibur extends Artefact {


    public Excalibur(){
        super.setPrice(150);
    }

    public void getEquipment(Character character){
        character.setAttack(character.getAttack() + 2);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removeEquipment(Character character){
        character.setAttack(character.getAttack() -2);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
