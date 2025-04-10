package Equipment;

import Equipment.Armour.Chainmail;
import Equipment.Armour.Fleece;
import Equipment.Armour.Regalia;
import Equipment.Artefact.Amulet;
import Equipment.Artefact.Crystal;
import Equipment.Artefact.Excalibur;

public class EquipmentFactory {
    public static Equipment createArmourEquipment(String equipmentType) {
        return switch (equipmentType) {
            case "Chainmail" -> new Chainmail();
            case "Regalia" -> new Regalia();
            case "Fleece" -> new Fleece();
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }
    public static Equipment createArtefactEquipment(String equipmentType) {
        return switch (equipmentType) {
            case "Excalibur" -> new Excalibur();
            case "Amulet" -> new Amulet();
            case "Crystal" -> new Crystal();
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }


    public static Equipment createArmourEquipment(int id) {
        return switch (id) {
            case 1 -> new Chainmail();
            case 2 -> new Regalia();
            case 3 -> new Fleece();

            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
    public static Equipment createArtefactEquipment(int id) {
        return switch (id) {
            case 1 -> new Excalibur();
            case 2-> new Amulet();
            case 3 -> new Crystal();
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    public static double getEquipmentforArmourPrice(String equipmentType) {
        return switch (equipmentType) {
            case "Chainmail" -> 70.0;
            case "Regalia" -> 105.0;
            case "Fleece" -> 150.0;
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }
    public static double getEquipmentforArtefactPrice(String equipmentType) {
        return switch (equipmentType) {
            case "Excalibur" -> 150.0;
            case "Amulet" -> 200.0;
            case "Crystal" -> 210.0;
            default -> throw new IllegalStateException("Unexpected value: " + equipmentType);
        };
    }

    public static double getEquipmentforAmourPrice(int id) {
        return switch (id) {
            case 1 -> 70.0;
            case 2 -> 105.0;
            case 3 -> 150.0;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
    public static double getEquipmentforArtefactPrice(int id) {
        return switch (id) {
            case 1 -> 150.0;
            case 2 -> 200.0;
            case 3 -> 210.0;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}