package Equipment.Artefacts;
import Character.Character;

public class Excalibur extends Artefacts{


    public Excalibur(){
        super.setPrice(150);
    }

    public void equipto(Character character){
        character.setAttack(character.getAttack() + 2);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removefrom(Character character){
        character.setAttack(character.getAttack() -2);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
