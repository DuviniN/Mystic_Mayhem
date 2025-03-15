package Equipment.Artefact;

import Equipment.Equipment;
import Character.Character;

public abstract class Artefact extends Equipment {


    public Artefact(){

        super.setPrice(100.0);
    }
    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);


}
