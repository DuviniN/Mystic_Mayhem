package Equipment.Armour;
import Character.Character;
public class Regalia extends Armour{


    public Regalia(){
        super.setPrice(105);
    }

    public void getEquipment(Character character){
        character.setDefence(character.getDefence() + 1);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removeEquipment(Character character){
        character.setDefence(character.getDefence() - 2);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }
}
