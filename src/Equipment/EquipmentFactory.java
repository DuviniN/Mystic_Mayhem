package Equipment;

import Equipment.Armour.Chainmail;
import Equipment.Armour.Fleece;
import Equipment.Armour.Regalia;
import Equipment.Artefact.Amulet;
import Equipment.Artefact.Crystal;
import Equipment.Artefact.Excalibur;

public class EquipmentFactory {
    public static Equipment createEquipment(String equipmentType) {
        return switch (equipmentType) {
            case "Chainmail" -> new Chainmail();
            case "Regalia" -> new Regalia();
            case "Fleece" -> new Fleece();
            case "Excalibur" -> new Excalibur();
            case "Amulet" -> new Amulet();
            case "Crystal" -> new Crystal();
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }

    public static Equipment createEquipment(int id) {
        return switch (id) {
            case 1 -> new Chainmail();
            case 2 -> new Regalia();
            case 3 -> new Fleece();
            case 4 -> new Excalibur();
            case 5 -> new Amulet();
            case 6 -> new Crystal();
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    public static double getEquipmentPrice(String equipmentType) {
        return switch (equipmentType) {
            case "Chainmail" -> 70.0;
            case "Regalia" -> 105.0;
            case "Fleece" -> 150.0;
            case "Excalibur" -> 150.0;
            case "Amulet" -> 200.0;
            case "Crystal" -> 210.0;
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }

    public static double getEquipmentPrice(int id) {
        return switch (id) {
            case 1 -> 70.0;
            case 2 -> 105.0;
            case 3 -> 150.0;
            case 4-> 150.0;
            case 5 -> 200.0;
            case 6 -> 210.0;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}