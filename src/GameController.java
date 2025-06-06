import java.sql.SQLOutput;
import java.util.*;

import Character.Archers.Archer;
import Character.Character;
import  java.util.HashMap;
import Character.CharacterFactory;
import Character.Healers.Healer;
import Character.Knights.Knight;
import Character.Mages.Mage;
import Character.Mythical_Creatures.Mythical_Creature;
import Equipment.Armour.Armour;
import Equipment.Armour.Chainmail;
import Equipment.Armour.Fleece;
import Equipment.Armour.Regalia;
import Equipment.Artefact.Artefact;
import Equipment.Artefact.Crystal;
import Equipment.Equipment;
import Equipment.EquipmentFactory;
import Character.CharacterState;

public class GameController {
    private static HashMap<String,User>users=new HashMap<>();
    DisplayController displayController=new DisplayController();
    final Scanner input=new Scanner(System.in);

    public GameController(){
        users=fetchUsers();
    }

    private HashMap<String, User>fetchUsers(){
        HashMap<String, User> userList=new HashMap<>();
        User user1=new User("Harvey","harvey123");
        user1.setGoldCoin(2340);
        user1.setXp(32);
        user1.getGuild().addCharacter(CharacterFactory.createCharacter(1));
        user1.getGuild().addCharacter(CharacterFactory.createCharacter(7));
        user1.getGuild().addCharacter(CharacterFactory.createCharacter(13));
        user1.getGuild().addCharacter(CharacterFactory.createCharacter(16));
        user1.getGuild().addCharacter(CharacterFactory.createCharacter(23));
        Armour armour1=new Regalia();
        armour1.getEquipment(user1.getGuild().getArcher());
        user1.getGuild().getArcher().setArmour(armour1);
        Artefact artefact1=new Crystal();
        artefact1.getEquipment(user1.getGuild().getArcher());
        user1.getGuild().getArcher().setArtefact(artefact1);
        userList.put(user1.getUsername(),user1);

        User user2=new User("Jonny","Jonny123");
        user2.setGoldCoin(2330);
        user2.setXp(31);
        user2.getGuild().addCharacter(CharacterFactory.createCharacter(2));
        user2.getGuild().addCharacter(CharacterFactory.createCharacter(8));
        user2.getGuild().addCharacter(CharacterFactory.createCharacter(14));
        user2.getGuild().addCharacter(CharacterFactory.createCharacter(17));
        user2.getGuild().addCharacter(CharacterFactory.createCharacter(24));
        Armour armour2=new Fleece();
        armour2.getEquipment(user1.getGuild().getArcher());
        user2.getGuild().getArcher().setArmour(armour2);
        Artefact artefact2=new Crystal();
        artefact2.getEquipment(user2.getGuild().getArcher());
        user2.getGuild().getArcher().setArtefact(artefact2);
        userList.put(user2.getUsername(),user2);

        User user3=new User("Nory","Nory123");
        user3.setGoldCoin(2345);
        user3.setXp(32);
        user3.getGuild().addCharacter(CharacterFactory.createCharacter(3));
        user3.getGuild().addCharacter(CharacterFactory.createCharacter(9));
        user3.getGuild().addCharacter(CharacterFactory.createCharacter(15));
        user3.getGuild().addCharacter(CharacterFactory.createCharacter(18));
        user3.getGuild().addCharacter(CharacterFactory.createCharacter(25));
        Armour armour3=new Regalia();
        armour3.getEquipment(user1.getGuild().getArcher());
        user3.getGuild().getArcher().setArmour(armour3);
        Artefact artefact3=new Crystal();
        artefact3.getEquipment(user3.getGuild().getArcher());
        user3.getGuild().getArcher().setArtefact(artefact3);

        userList.put(user3.getUsername(),user3);


        return userList;
    }

    public User login(){
        displayController.clearConsole();
        displayController.printTitle("Login");
        while (true){
            System.out.print("Enter username:");
            String username=input.nextLine();
            if(users.containsKey(username)){
                return users.get(username);
            }
            System.out.println("This username is not available.");
            System.out.println("1. re-enter");
            System.out.println("2. register");
            int chose;
            while (true){
                System.out.println("Please select an option:");
                if(input.hasNextInt()){
                    chose=input.nextInt();
                    input.nextLine();
                    if(chose==1  ||  chose==2){
                        break;
                    }
                }
                else{
                    input.nextLine();
                }
                System.out.println("Invalid input, please select 1 or 2");
            }
            if(chose==2){
               return  register();
            }
        }
    }
    public User register(){
        displayController.clearConsole();

        displayController.printTitle("Register");

        System.out.print("Enter your name:");
        String name=input.nextLine();
        System.out.print("Enter username:");
        String username=input.nextLine();
        while (users.containsKey(username)){
            System.out.println("User name is already exit. Enter Again another one");
            System.out.print("Enter username:");
            username=input.next();
        }
        User user=new User(name,username);
        users.put(username,user);
        createGuild(user);

        return user;
    }

    public void createGuild(User user){
        displayController.clearConsole();
        displayController.printCharacterList();
        String[] guild=displayController.guildSelection();
        try{
            for(String characterType:guild){
                user.getGuild().addCharacter(CharacterFactory.createCharacter(characterType));
                user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(characterType));
            }
        }
        catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    public void sellCharacter(User user){
        displayController.clearConsole();
        displayController.printTitle("Sell Character");
        if(user.getGoldCoin() <= 50){
            System.out.println("\nYou don't have enough gold coins to sell.");
            System.out.println("You need at least 50 gold coins to sell.");
            System.out.println("\nPress any key to go back to the menu.");
            input.nextLine();
        }
        else{
            System.out.println("\nYour Gold Coin: "+user.getGoldCoin());
            System.out.println("\nYour Guild");
            System.out.println("1.Archer: "+user.getGuild().getArcherType());
            System.out.println("2.Healer: "+user.getGuild().getHealerType());
            System.out.println("3.Knight: "+user.getGuild().getKnightType());
            System.out.println("4.Mage: "+user.getGuild().getMageType());
            System.out.println("5.Mythical Creature: "+user.getGuild().getMythical_CreatureType());
            System.out.println("6.Back");
            System.out.println("\nSelect character to sell");
            while (true){
                System.out.print("Enter[1-6]: ");
                try{
                    int userInput = input.nextInt();
                    if(userInput == 1){
                        if(user.getGuild().getArcher() != null){
                            System.out.println("You have sold your archer");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getArcher().getPrice()*0.9);
                            user.getGuild().removeArcher();
                        }
                        else{
                            System.out.println("You don't have archer");
                        }
                    }
                    else if(userInput == 2){
                        if(user.getGuild().getHealer() != null){
                            System.out.println("You have sold your healer");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getHealer().getPrice()*0.9);
                            user.getGuild().removeHealer();
                        }
                        else{
                            System.out.println("You don't have healer");
                        }
                    }
                    else if(userInput == 3){
                        if(user.getGuild().getKnight() != null){
                            System.out.println("You have sold your knight");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getKnight().getPrice()*0.9);
                            user.getGuild().removeKnight();
                        }
                        else{
                            System.out.println("You don't have knight");
                        }
                    }
                    else if(userInput == 4){
                        if(user.getGuild().getMage() != null){
                            System.out.println("You have sold your mage");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMage().getPrice()*0.9);
                            user.getGuild().removeMage();
                        }
                        else{
                            System.out.println("You don't have mage");
                        }
                    }
                    else if(userInput == 5){
                        if(user.getGuild().getMythical_Creature() != null){
                            System.out.println("You have sold your mythical creature");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMythical_Creature().getPrice()*0.9);
                            user.getGuild().removeMythical_Creatures();
                        }
                        else{
                            System.out.println("You don't have mythical creature");
                        }
                    }
                    else if(userInput == 6) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter again");
                    input.next();
                }
            }
        }
    }
    public void buyCharacter(User user){
        displayController.clearConsole();
        displayController.printTitle("Buy Character");
        displayController.printCharacterList();
        System.out.println("\n26. Back");

        System.out.println("\nYour Guild\n");
        System.out.println("Archer:"+user.getGuild().getArcherType());
        System.out.println("Knight:"+user.getGuild().getKnightType());
        System.out.println("Mage:"+user.getGuild().getMageType());
        System.out.println("Healer:"+user.getGuild().getHealerType());
        System.out.println("Mythical Creature;"+user.getGuild().getMythical_CreatureType());
        System.out.println("\nYour Gold Coin: "+user.getGoldCoin());
        System.out.println("Select character to buy");

        while (true){
            System.out.print("Enter[1-26]: ");
            try{
                int userInput = input.nextInt();
                if(1 <= userInput && userInput <= 5){
                    if(user.getGuild().getArcher() == null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character archer = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(archer);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                            System.out.println("Succuessfuly buy Archer");
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have archer!");
                    }
                } else if (6 <= userInput && userInput <= 10 ) {
                    if(user.getGuild().getKnight() == null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character knight = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(knight);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                            System.out.println("Succuessfuly buy Knight");
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have knight!");
                    }
                }
                else if (11 <= userInput && userInput <= 15 ) {
                    if(user.getGuild().getMage() == null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character mage = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(mage);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                            System.out.println("Succuessfuly buy Mage");
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have mage!");
                    }
                }
                else if (16 <= userInput && userInput <= 20 ) {
                    if(user.getGuild().getHealer() == null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character healer = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(healer);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                            System.out.println("Succuessfuly buy Healer");
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have healer!");
                    }
                }
                else if (21 <= userInput && userInput <= 25 ) {
                    if (user.getGuild().getMythical_Creature() == null) {
                        if (user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)) {
                            Character mythicalCreature = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(mythicalCreature);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                            System.out.println("Succuessfuly buy Mythical Creature");
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have mythical creature!");
                    }

                }else if (userInput == 26) {
                        return;
                } else {
                    System.out.println("Invalid input, please enter again");
                }
            } catch (Exception e){
                System.out.println("Invalid input, please enter again");
                input.next();
            }
        }
    }

    public void buyArmour(User user){
        displayController.clearConsole();
        displayController.printTitle("Buy Armour");
        displayController.EquipmentOfGuild(user);
        System.out.println("6.back");
        System.out.println(" ");
        displayController.printArmourList();
        System.out.println(" ");
        while(true){
            System.out.print("Enter the character[1-6]:");
            try{
                int userChose=input.nextInt();
                if(userChose==1){
                    if(user.getGuild().getArcher().isArmour()){
                        System.out.println("Already you Archer has Armour.");
                    }
                    else{
                        System.out.print("Choose Armour:");
                        int userChoseArmour=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforAmourPrice(userChoseArmour);
                        if(user.getGoldCoin()>=price){
                            Armour armour=(Armour)EquipmentFactory.createArmourEquipment(userChoseArmour);
                            armour.getEquipment(user.getGuild().getArcher());
                            user.getGuild().getArcher().setArmour(armour);
                            System.out.println("Successfully you have bought Armour to Archer");
                            user.setGoldCoin(user.getGoldCoin()-price);

                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==2){
                    if(user.getGuild().getHealer().isArmour()){
                        System.out.println("Already you Healer has Armour.");
                    }
                    else{
                        System.out.print("Choose Armour:");
                        int userChoseArmour=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforAmourPrice(userChoseArmour);
                        if(user.getGoldCoin()>=price){
                            Armour armour=(Armour)EquipmentFactory.createArmourEquipment(userChoseArmour);
                            armour.getEquipment(user.getGuild().getHealer());
                            user.getGuild().getHealer().setArmour(armour);
                            System.out.println("Successfully you have bought Armour to Healer");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==3){
                    if(user.getGuild().getKnight().isArmour()){
                        System.out.println("Already you Knight has Armour.");
                    }
                    else{
                        System.out.print("Choose Armour:");
                        int userChoseArmour=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforAmourPrice(userChoseArmour);
                        if(user.getGoldCoin()>=price){
                            Armour armour=(Armour)EquipmentFactory.createArmourEquipment(userChoseArmour);
                            armour.getEquipment(user.getGuild().getKnight());
                            user.getGuild().getKnight().setArmour(armour);
                            System.out.println("Successfully you have bought Armour to Knight");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==4){
                    if(user.getGuild().getMage().isArmour()){
                        System.out.println("Already you Mage has Armour.");
                    }
                    else{
                        System.out.print("Choose Armour:");
                        int userChoseArmour=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforAmourPrice(userChoseArmour);
                        if(user.getGoldCoin()>=price){
                            Armour armour=(Armour)EquipmentFactory.createArmourEquipment(userChoseArmour);
                            armour.getEquipment(user.getGuild().getMage());
                            user.getGuild().getMage().setArmour(armour);
                            System.out.println("Successfully you have bought Armour to Mage");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==5){
                    if(user.getGuild().getMythical_Creature().isArmour()){
                        System.out.println("Already you Mythical Creature has Armour.");
                    }
                    else{
                        System.out.print("Choose Armour:");
                        int userChoseArmour=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforAmourPrice(userChoseArmour);
                        if(user.getGoldCoin()>=price){
                            Armour armour=(Armour)EquipmentFactory.createArmourEquipment(userChoseArmour);
                            armour.getEquipment(user.getGuild().getMythical_Creature());
                            user.getGuild().getMythical_Creature().setArmour(armour);
                            System.out.println("Successfully you have bought Armour to Mythical Creature");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==6){
                    return;
                }
            }
            catch (Exception e){
                System.out.println("Invalid Input. Enter again.");
                input.next();
            }
        }
    }
    public void buyArtefact(User user){
        displayController.clearConsole();
        displayController.printTitle("Buy Artefact");
        displayController.EquipmentOfGuild(user);
        System.out.println("6.back");
        System.out.println(" ");
        displayController.printArtefactList();
        System.out.println(" ");
        while(true){
            System.out.print("Enter the character[1-6]:");
            try{
                int userChose=input.nextInt();
                if(userChose==1){
                    if(user.getGuild().getArcher().isArtefact()){
                        System.out.println("Already you Archer has Artefact.");
                    }
                    else{
                        System.out.print("Choose Artefact:");
                        int userChoseArtefact=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforArtefactPrice(userChoseArtefact);
                        if(user.getGoldCoin()>=price){
                            Artefact artefact=(Artefact)EquipmentFactory.createArtefactEquipment(userChoseArtefact);
                            artefact.getEquipment(user.getGuild().getArcher());
                            user.getGuild().getArcher().setArtefact(artefact);
                            System.out.println("Successfully you have bought Artefact to Archer");
                            user.setGoldCoin(user.getGoldCoin()-price);

                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==2){
                    if(user.getGuild().getHealer().isArtefact()){
                        System.out.println("Already you Healer has Artefact.");
                    }
                    else{
                        System.out.print("Choose Artefact:");
                        int userChoseArtefact=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforArtefactPrice(userChoseArtefact);
                        if(user.getGoldCoin()>=price){
                            Artefact artefact=(Artefact)EquipmentFactory.createArtefactEquipment(userChoseArtefact);
                            artefact.getEquipment(user.getGuild().getHealer());
                            user.getGuild().getHealer().setArtefact(artefact);
                            System.out.println("Successfully you have bought Artefact to Healer");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==3){
                    if(user.getGuild().getKnight().isArtefact()){
                        System.out.println("Already you Knight has Artefact.");
                    }
                    else{
                        System.out.print("Choose Artefact:");
                        int userChoseArtefact=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforArtefactPrice(userChoseArtefact);
                        if(user.getGoldCoin()>=price){
                            Artefact artefact=(Artefact)EquipmentFactory.createArtefactEquipment(userChoseArtefact);
                            artefact.getEquipment(user.getGuild().getKnight());
                            user.getGuild().getKnight().setArtefact(artefact);
                            System.out.println("Successfully you have bought Artefact to Knight");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==4){
                    if(user.getGuild().getMage().isArtefact()){
                        System.out.println("Already you Mage has Artefact.");
                    }
                    else{
                        System.out.print("Choose Artefact:");
                        int userChoseArtefact=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforArtefactPrice(userChoseArtefact);
                        if(user.getGoldCoin()>=price){
                            Artefact artefact=(Artefact)EquipmentFactory.createArtefactEquipment(userChoseArtefact);
                            artefact.getEquipment(user.getGuild().getMage());
                            user.getGuild().getMage().setArtefact(artefact);
                            System.out.println("Successfully you have bought Artefact to Mage");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==5){
                    if(user.getGuild().getMythical_Creature().isArtefact()){
                        System.out.println("Already you Mythical Creature has Artefact.");
                    }
                    else{
                        System.out.print("Choose Artefact:");
                        int userChoseArtefact=input.nextInt();
                        double price=EquipmentFactory.getEquipmentforArtefactPrice(userChoseArtefact);
                        if(user.getGoldCoin()>=price){
                            Artefact artefact=(Artefact)EquipmentFactory.createArtefactEquipment(userChoseArtefact);
                            artefact.getEquipment(user.getGuild().getMythical_Creature());
                            user.getGuild().getMythical_Creature().setArtefact(artefact);
                            System.out.println("Successfully you have bought Artefact to Mythical Creature");
                            user.setGoldCoin(user.getGoldCoin()-price);
                        }
                        else{
                            System.out.println("You don't have enough gold coins");
                        }
                    }
                }
                if(userChose==6){
                    return;
                }
            }
            catch (Exception e){
                System.out.println("Invalid Input. Enter again.");
                input.next();
            }
        }
    }

    public void sellArmour(User user){
        displayController.clearConsole();
        displayController.printTitle("Sell Armour");
        if(user.getGoldCoin() <= 50){
            System.out.println("\nYou don't have enough gold coins to sell.");
            System.out.println("You need at least 50 gold coins to sell.");
            System.out.println("\nPress any key to go back to the menu.");
            input.nextLine();
        }
        else {
            System.out.println("\nYour Gold Coin: " + user.getGoldCoin());
            System.out.println("\nYour Guild");
            displayController.EquipmentOfGuild(user);
            System.out.println("6.back\n");
            System.out.println(" ");
            System.out.println("\nSelect character to sell");
            while (true) {
                System.out.print("Enter[1-6]: ");
                try {
                    int userInput = input.nextInt();
                    if (userInput == 1) {
                        if (user.getGuild().getArcher().isArmour()) {
                            System.out.println("You have sold your archer's armour");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getArcher().getArmour().getPrice());
                            user.getGuild().getArcher().removeArmour();
                        } else {
                            System.out.println("You don't have archer's armour");
                        }
                    } else if (userInput == 2) {
                        if (user.getGuild().getHealer().isArmour()) {
                            System.out.println("You have sold your healer's armour");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getHealer().getArmour().getPrice());
                            user.getGuild().getHealer().removeArmour();
                        } else {
                            System.out.println("You don't have healer's armour");
                        }
                    } else if (userInput == 3) {
                        if (user.getGuild().getKnight().isArmour()) {
                            System.out.println("You have sold your knight's armour");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getKnight().getArmour().getPrice());
                            user.getGuild().getKnight().removeArmour();
                        } else {
                            System.out.println("You don't have knight's armour");
                        }
                    } else if (userInput == 4) {
                        if (user.getGuild().getMage().isArmour()) {
                            System.out.println("You have sold your healer's armour");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMage().getArmour().getPrice());
                            user.getGuild().getMage().removeArmour();
                        } else {
                            System.out.println("You don't have mage's armour");
                        }
                    } else if (userInput == 5) {
                        if (user.getGuild().getMythical_Creature().isArmour()) {
                            System.out.println("You have sold your mythical creature's armour");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMythical_Creature().getArmour().getPrice());
                            user.getGuild().getMythical_Creature().removeArmour();
                        } else {
                            System.out.println("You don't have mythical creature's armour");
                        }
                    }
                    else if(userInput==6){
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter again");
                    input.next();
                }
            }
        }
    }
    public void sellArtefact(User user) {
        displayController.clearConsole();
        displayController.printTitle("Sell Artefact");
        if (user.getGoldCoin() <= 50) {
            System.out.println("\nYou don't have enough gold coins to sell.");
            System.out.println("You need at least 50 gold coins to sell.");
            System.out.println("\nPress any key to go back to the menu.");
            input.nextLine();
        } else {
            displayController.EquipmentOfGuild(user);
            System.out.println("6.back\n");
            System.out.println(" ");
            System.out.println("\nSelect character to sell");
            while (true) {
                System.out.print("Enter[1-6]: ");
                try {
                    int userInput = input.nextInt();
                    if (userInput == 1) {
                        if (user.getGuild().getArcher().isArtefact()) {
                            System.out.println("You have sold your archer's artefact");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getArcher().getArtefact().getPrice());
                            user.getGuild().getArcher().removeArtefact();
                        } else {
                            System.out.println("You don't have archer's artefact");
                        }
                    } else if (userInput == 2) {
                        if (user.getGuild().getHealer().isArtefact()) {
                            System.out.println("You have sold your healer's artefact");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getHealer().getArtefact().getPrice());
                            user.getGuild().getHealer().removeArtefact();
                        } else {
                            System.out.println("You don't have healer's artefact");
                        }
                    } else if (userInput == 3) {
                        if (user.getGuild().getKnight().isArtefact()) {
                            System.out.println("You have sold your knight's artefact");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getKnight().getArtefact().getPrice());
                            user.getGuild().getKnight().removeArtefact();
                        } else {
                            System.out.println("You don't have knight's artefact");
                        }
                    } else if (userInput == 4) {
                        if (user.getGuild().getMage().isArtefact()) {
                            System.out.println("You have sold your mage's artefact");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMage().getArtefact().getPrice());
                            user.getGuild().getMage().removeArtefact();
                        } else {
                            System.out.println("You don't have healer's artefact");
                        }
                    } else if (userInput == 5) {
                        if (user.getGuild().getMythical_Creature().isArtefact()) {
                            System.out.println("You have sold your mythical creature's artefact");
                            user.setGoldCoin(user.getGoldCoin() + user.getGuild().getMythical_Creature().getArtefact().getPrice());
                            user.getGuild().getMythical_Creature().removeArtefact();
                        } else {
                            System.out.println("You don't have mythical creature's artefact");
                        }
                    }
                    else if(userInput==6){
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter again");
                    input.next();
                }
            }
        }
    }

    public void selectWinner(User user,User enemy,String battleGround){
        int userCharacterDeath=0;
        int enemyCharacterDeath=0;

        for(Character c: user.getGuild().getGuildList()){
            if(c.getState()== CharacterState.DEATH){
                userCharacterDeath++;
            }
        }
        for(Character c: enemy.getGuild().getGuildList()){
            if(c.getState()== CharacterState.DEATH){
                enemyCharacterDeath++;
            }
        }

        if(userCharacterDeath==5){
            System.out.println("You have lost the battle.");
            System.out.println("Your all characters are dead.");
            enemy.setGoldCoin(enemy.getGoldCoin()+user.getGoldCoin()*0.1);
            user.setGoldCoin(user.getGoldCoin()*0.9);
            enemy.setXp(enemy.getXp()+1);
        }
        else if(enemyCharacterDeath==5){
            System.out.println("You have win the battle.");
            user.setGoldCoin(user.getGoldCoin()+enemy.getGoldCoin()*0.1);
            enemy.setGoldCoin(enemy.getGoldCoin()*0.9);
            user.setXp(user.getXp()+1);
        }
        else{
            System.out.println("The battle is a draw.");
        }
        for(Character c:user.getGuild().getGuildList()){
            c.resetBattleGround(battleGround);
            c.setDefaultHealth();
        }
        for(Character c:enemy.getGuild().getGuildList()){
            c.resetBattleGround(battleGround);
            c.setDefaultHealth();
        }


    }

    public void battle(User user){
        displayController.clearConsole();
        displayController.printTitle("Battle");
        HashMap<String, User> userList=fetchUsers();

        User enemy=displayController.selectUser(userList);
        if(enemy!=null){
            displayController.clearConsole();
            displayController.printTitle("Battle");
            String battleGround = displayController.selectBattleGround();

            for(Character c:user.getGuild().getGuildList()){
                c.setBattleGround(battleGround);
            }
            for(Character c:enemy.getGuild().getGuildList()){
                c.setBattleGround(battleGround);
            }

            displayController.clearConsole();
            displayController.printTitle("Battle");

            int round=1;
            while(round<11){
                System.out.printf("\n\n<= Round[%d] =>\n",round);

                //User attack
                System.out.println("-------------------User Attack----------------->");
                Character userFastestCharacter=user.getGuild().getFastestCharacter();
                Character enemyDefendingCharacter=enemy.getGuild().getLowestDefenceCharacter();
                if(userFastestCharacter==null || enemyDefendingCharacter==null){
                    selectWinner(user,enemy,battleGround);
                    System.out.println("\n<=Battle is over=>");
                    break;
                }
                else if(userFastestCharacter instanceof Healer userHealer){
                    Character userLowestHealthCharacter=user.getGuild().getLowestHealthCharacter();
                    userHealer.heal(userLowestHealthCharacter);
                }
                else{
                    switch(userFastestCharacter){
                        case Archer archer->archer.attack(enemyDefendingCharacter);
                        case Knight knight ->knight.attack(enemyDefendingCharacter);
                        case Mage mage ->mage.attack(enemyDefendingCharacter);
                        case Mythical_Creature mythicalCreature ->mythicalCreature.attack(enemyDefendingCharacter);
                        default -> throw new IllegalStateException("Unexpected value: "+ userFastestCharacter);
                    }
                }

                //Enermy attack

                System.out.println("-------------------Opponent Attack----------------->");
                Character enemyFastestCharacter=enemy.getGuild().getFastestCharacter();
                Character userDefendingCharacter=user.getGuild().getLowestDefenceCharacter();
                if(enemyFastestCharacter==null || userDefendingCharacter==null){
                    selectWinner(user,enemy,battleGround);
                    System.out.println("<=Battle is over=>");
                    break;
                }
                else if(enemyFastestCharacter instanceof  Healer enemyHealer){
                    Character enemyLowestHealthCharacter=enemy.getGuild().getLowestHealthCharacter();
                    enemyHealer.heal(enemyLowestHealthCharacter);
                }
                else{
                    switch(enemyFastestCharacter){
                        case Archer archer -> archer.attack(userDefendingCharacter);
                        case Knight knight -> knight.attack(userDefendingCharacter);
                        case Mage mage -> mage.attack(userDefendingCharacter);
                        case Mythical_Creature mythicalCreature-> mythicalCreature.attack(userDefendingCharacter);
                        default -> throw new IllegalStateException("Unexpected value: "+ enemyFastestCharacter);
                    }
                }
                round++;

            }
            if(round<12){
                System.out.println("\nPress any key to go back to the menu.");
                input.nextLine();
            }


        }

    }



}
