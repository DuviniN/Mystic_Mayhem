package Equipment.Armour;
import Character.Archers.Archer;
import Character.Archers.Shooter;
import Character.Character;
public class Chainmail extends Armour {

    public Chainmail(){
        super.setPrice(70);
    }

    public void equipto(Character character){
        character.setDefence(character.getDefence() + 1);
        character.setSpeed(character.getSpeed() - 1);
        character.setPrice((character.getPrice()*20)/100 + super.getPrice());
    }
    public void removefrom(Character character){
        character.setDefence(character.getDefence() - 1);
        character.setSpeed(character.getSpeed() + 1);
        character.setPrice(super.getPrice()-(character.getPrice()*20)/100);
    }



}
