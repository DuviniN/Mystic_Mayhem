package Character;

import Character.Archers.*;
import Character.Healers.*;
import Character.Knights.*;
import Character.Mages.*;
import Character.Mythical_Creatures.*;

public class CharacterFactory {
    public static Character createCharacter(String characterType){
        return switch (characterType){
            case "Ranger" ->new Ranger();
            case "Saggitarius" ->new Saggitarius();
            case "Shooter" ->new Shooter();
            case "Sunfire" ->new Sunfire();
            case "Zing" ->new Zing();
            case "Alchemist" ->new Alchemist();
            case "Lightbringer" ->new Lightbringer();
            case "Medic" ->new Medic();
            case "Saint" ->new Saint();
            case "Soother" ->new Soother();
            case "Cavalier" ->new Cavalier();
            case "Squire" ->new Squire();
            case "Swiftblade" ->new Swiftblade();
            case "Templar" ->new Templar();
            case "Zoro" ->new Zoro();
            case "Conjurer" ->new Conjurer();
            case "Eldritch" ->new Eldritch();
            case "Enchanter" ->new Enchanter();
            case "illusionist" ->new illusionist();
            case "Warlock" ->new Warlock();
            case "Basilisk" ->new Basilisk();
            case "Dragon" ->new Dragon();
            case "Hydra" ->new Hydra();
            case "Pegasus" ->new Pegasus();
            case "Phoenix" ->new Phoenix();
            default -> throw new IllegalStateException("Unexpected value: "+ characterType);
        };
    }
}
