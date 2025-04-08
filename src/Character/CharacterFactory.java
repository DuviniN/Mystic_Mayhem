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
        case "Illusionist" ->new Illusionist();
        case "Warlock" ->new Warlock();
        case "Basilisk" ->new Basilisk();
        case "Dragon" ->new Dragon();
        case "Hydra" ->new Hydra();
        case "Pegasus" ->new Pegasus();
        case "Phoenix" ->new Phoenix();
        default -> throw new IllegalStateException("Unexpected value: "+ characterType);
    };
}

    public static Character createCharacter(int id){
        return switch (id) {
            case 1 -> new Shooter();
            case 2 -> new Ranger();
            case 3 -> new Sunfire();
            case 4 -> new Zing();
            case 5 -> new Saggitarius();
            case 6 -> new Squire();
            case 7 -> new Cavalier();
            case 8 -> new Templar();
            case 9 -> new Zoro();
            case 10 -> new Swiftblade();
            case 11 -> new Warlock();
            case 12 -> new Illusionist();
            case 13 -> new Enchanter();
            case 14 -> new Conjurer();
            case 15 -> new Eldritch();
            case 16 -> new Soother();
            case 17 -> new Medic();
            case 18 -> new Alchemist();
            case 19 -> new Saint();
            case 20 -> new Lightbringer();
            case 21 -> new Dragon();
            case 22 -> new Basilisk();
            case 23 -> new Hydra();
            case 24 -> new Phoenix();
            case 25 -> new Pegasus();
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    public static double getCharacterPrice(String characterType){
        return switch (characterType){
            case "Shooter" -> 80.0;
            case "Ranger" -> 115.0;
            case "Sunfire" -> 160.0;
            case "Zing" -> 200.0;
            case "Saggitarius" -> 230.0;
            case "Squire" -> 85.0;
            case "Cavalier" -> 110.0;
            case "Templar" -> 155.0;
            case "Zoro" -> 180.0;
            case "Swiftblade" -> 250.0;
            case "Warlock" -> 100.0;
            case "Illusionist" -> 120.0;
            case "Enchanter" -> 160.0;
            case "Conjurer" -> 195.0;
            case "Eldritch" -> 270.0;
            case "Soother" -> 95.0;
            case "Medic" -> 125.0;
            case "Alchemist" -> 150.0;
            case "Saint" -> 200.0;
            case "Lightbringer" -> 260.0;
            case "Dragon" -> 120.0;
            case "Basilisk" -> 165.0;
            case "Hydra" -> 205.0;
            case "Phoenix" -> 275.0;
            case "Pegasus" -> 340.0;
            default -> throw new IllegalStateException("Unexpected value: "+ characterType);
        };
    }

    public static double getCharacterPrice(int id){
        return switch (id) {
            case 1 -> 80.0;
            case 2 -> 115.0;
            case 3 -> 160.0;
            case 4 -> 200.0;
            case 5 -> 230.0;
            case 6 -> 85.0;
            case 7 -> 110.0;
            case 8 -> 155.0;
            case 9 -> 180.0;
            case 10 -> 250.0;
            case 11 -> 100.0;
            case 12 -> 120.0;
            case 13 -> 160.0;
            case 14 -> 195.0;
            case 15 -> 270.0;
            case 16 -> 95.0;
            case 17 -> 125.0;
            case 18 -> 150.0;
            case 19 -> 200.0;
            case 20 ->260.0;
            case 21 ->120.0;
            case 22 ->165.0;
            case 23 ->205.0;
            case 24 ->275.0;
            case 25 ->340.0;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}
