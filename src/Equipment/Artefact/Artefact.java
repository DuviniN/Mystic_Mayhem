package Equipment.Artefact;

import Equipment.Equipment;
import Character.Character;

public abstract class Artefact extends Equipment {


    public abstract void getEquipment(Character character);
    public abstract void removeEquipment(Character character);


}
