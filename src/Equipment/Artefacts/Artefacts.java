package Equipment.Artefacts;

import Equipment.Equipment;
import Character.Character;

public abstract class Artefacts extends Equipment {


    public Artefacts(){

        super.setPrice(100);
    }
    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);


}
