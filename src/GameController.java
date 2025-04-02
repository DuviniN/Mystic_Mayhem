import java.util.*;
import Character.Character;
import  java.util.HashMap;
import Character.CharacterFactory;

public class GameController {
    private static HashMap<String,User>users=new HashMap<>();
    DisplayController displayController=new DisplayController();
    final Scanner input=new Scanner(System.in);

    public User login(){
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
                    else if (userInput == 6) {
                        return;
                    } else {
                        System.out.println("Invalid input, please enter again");
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
                    if(user.getGuild().getArcher() != null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character archer = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(archer);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have archer!");
                    }
                } else if (6 <= userInput && userInput <= 10 ) {
                    if(user.getGuild().getKnight() != null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character knight = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(knight);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have knight!");
                    }
                }
                else if (11 <= userInput && userInput <= 15 ) {
                    if(user.getGuild().getMage() != null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character mage = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(mage);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have mage!");
                    }
                }
                else if (16 <= userInput && userInput <= 20 ) {
                    if(user.getGuild().getHealer() != null){
                        if(user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)){
                            Character healer = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(healer);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
                        } else {
                            System.out.println("You don't have enough gold coins");
                        }
                    } else {
                        System.out.println("Already you have healer!");
                    }
                }
                else if (21 <= userInput && userInput <= 25 ) {
                    if (user.getGuild().getMythical_Creature() != null) {
                        if (user.getGoldCoin() >= CharacterFactory.getCharacterPrice(userInput)) {
                            Character mythicalCreature = CharacterFactory.createCharacter(userInput);
                            user.getGuild().addCharacter(mythicalCreature);
                            user.setGoldCoin(user.getGoldCoin() - CharacterFactory.getCharacterPrice(userInput));
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
        displayController.printArmourList();
        System.out.println("\n4. Back");

        System.out.println("\nYour Guild\n");
        System.out.println("Archer:"+user.getGuild().getArcherType()+"\nEquipments:"+user.getGuild().getArcher().getArmour());
        System.out.println("Knight:"+user.getGuild().getKnightType());
        System.out.println("Mage:"+user.getGuild().getMageType());
        System.out.println("Healer:"+user.getGuild().getHealerType());
        System.out.println("Mythical Creature;"+user.getGuild().getMythical_CreatureType());
        System.out.println("\nYour Gold Coin: "+user.getGoldCoin());
        System.out.println("Select character to buy");


    }




}
