import Character.Archers.Archer;

import java.util.*;
import java.util.concurrent.Callable;

import Character.Archers.Shooter;
import Character.Character;
import  java.util.HashMap;



import Character.CharacterFactory;
import jdk.jshell.PersistentSnippet;

public class GameController {
    private static HashMap<String,User>users=new HashMap<>();
    public static HashMap<Integer,Double>prices=new HashMap<>();
    public GameController(){
        prices.put(1,80.0);
        prices.put(2,115.0);
        prices.put(3,160.0);
        prices.put(4,200.0);
        prices.put(5,230.0);
        prices.put(6,85.0);
        prices.put(7,110.0);
        prices.put(8,155.0);
        prices.put(9,180.0);
        prices.put(10,250.0);
        prices.put(11,100.0);
        prices.put(12,120.0);
        prices.put(13,160.0);
        prices.put(14,195.0);
        prices.put(15,270.0);
        prices.put(16,95.0);
        prices.put(17,125.0);
        prices.put(18,150.0);
        prices.put(19,200.0);
        prices.put(20,260.0);
        prices.put(21,120.0);
        prices.put(22,165.0);
        prices.put(23,205.0);
        prices.put(24,275.0);
        prices.put(25,340.0);
    }




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
            }
        }
        catch(IllegalStateException e){
            System.out.println("Invalid character type");
        }
    }

    public void sellCharacter(User user){
        System.out.println("If you did not have at least 50 gold coins ,you can not sell.");
        if(user.getGoldCoin()>=50){
            System.out.println("1.Archer: "+user.getGuild().getArcherType());
            System.out.println("2.Healer: "+user.getGuild().getHealerType());
            System.out.println("3.Knight: "+user.getGuild().getKnightType());
            System.out.println("4.Mage: "+user.getGuild().getMageType());
            System.out.println("5.Mythical Creature: "+user.getGuild().getMythicalCreatureType());
            System.out.println("6.Back");
            double sellPrice;
            Scanner input=new Scanner(System.in);
            while(true){
                System.out.println("Select sell character");
                try{
                    int choseCharacter=input.nextInt();
                    switch (choseCharacter){
                        case 1:
                            sellPrice=user.getGuild().getArcher().getPrice()*0.9;
                            user.getGuild().removeArcher();
                            user.setGoldCoin(user.getGoldCoin()+sellPrice);
                            break;

                        case 2:
                            sellPrice=user.getGuild().getHealer().getPrice()*0.9;
                            user.getGuild().removeHealer();
                            user.setGoldCoin(user.getGoldCoin()+sellPrice);
                            break;
                        case 3:
                            sellPrice=user.getGuild().getKnight().getPrice()*0.9;
                            user.getGuild().removeKnight();
                            user.setGoldCoin(user.getGoldCoin()+sellPrice);
                            break;
                        case 4:
                            sellPrice=user.getGuild().getMage().getPrice()*0.9;
                            user.getGuild().removeMage();
                            user.setGoldCoin(user.getGoldCoin()+sellPrice);
                            break;
                        case 5:
                            sellPrice=user.getGuild().getMythical_Creature().getPrice()*0.9;
                            user.getGuild().removeMythical_Creatures();
                            user.setGoldCoin(user.getGoldCoin()+sellPrice);
                            break;
                        case 6:
                            displayController.displayMenu();
                            break;
                        default:
                            System.out.println("Invalid number");
                    }
                }
                catch(Exception e){
                    System.out.println("Enter again:");
                    input.next();
                }
            }
        }

    }


    public void buyCharacter(User user){
        displayController.clearConsole();
        displayController.printCharacterList();
        System.out.println("Your Army");
        System.out.println("1.Archer:"+user.getGuild().getArcherType());
        System.out.println("2.Healer:"+user.getGuild().getHealerType());
        System.out.println("3.Knight:"+user.getGuild().getKnightType());
        System.out.println("4.Mage:"+user.getGuild().getMageType());
        System.out.println("5.Mythical Creature;"+user.getGuild().getMythicalCreatureType());
        System.out.println("6.Back");

        while (true){
            System.out.print("Enter your selection number: ");
            try{
                int userChose=input.nextInt();
                if(userChose>=1 && userChose<=5){
                    if(user.getGuild().getArcher()==null){
                        switch (userChose){
                            case 1:
                                if(user.getGoldCoin()>=prices.get(1)){
                                    Character Shooter= CharacterFactory.createCharacter("Shooter");
                                    user.getGuild().addCharacter(Shooter);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(1));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 2:
                                if(user.getGoldCoin()>=prices.get(2)){
                                    Character Ranger= CharacterFactory.createCharacter("Ranger");
                                    user.getGuild().addCharacter(Ranger);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(2));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 3:
                                if(user.getGoldCoin()>=prices.get(3)){
                                    Character Sunfire= CharacterFactory.createCharacter("Sunfire");
                                    user.getGuild().addCharacter(Sunfire);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(3));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 4:
                                if(user.getGoldCoin()>=prices.get(4)){
                                    Character Zing= CharacterFactory.createCharacter("Zing");
                                    user.getGuild().addCharacter(Zing);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(4));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 5:
                                if(user.getGoldCoin()>=prices.get(5)){
                                    Character Saggitarius= CharacterFactory.createCharacter("Saggitarius");
                                    user.getGuild().addCharacter(Saggitarius);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(5));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }

                        }

                    }
                }
                else if(userChose>=6 && userChose<=10){
                    if(user.getGuild().getKnight()==null){
                        switch (userChose){
                            case 6:
                                if(user.getGoldCoin()>=prices.get(6)){
                                    Character Squire= CharacterFactory.createCharacter("Squire");
                                    user.getGuild().addCharacter(Squire);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(6));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 7:
                                if(user.getGoldCoin()>=prices.get(7)){
                                    Character Cavalier= CharacterFactory.createCharacter("Cavalier");
                                    user.getGuild().addCharacter(Cavalier);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(7));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 8:
                                if(user.getGoldCoin()>=prices.get(8)){
                                    Character Templar= CharacterFactory.createCharacter("Templar");
                                    user.getGuild().addCharacter(Templar);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(8));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 9:
                                if(user.getGoldCoin()>=prices.get(9)){
                                    Character Zoro= CharacterFactory.createCharacter("Zoro");
                                    user.getGuild().addCharacter(Zoro);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(9));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 10:
                                if(user.getGoldCoin()>=prices.get(10)){
                                    Character Swiftblade= CharacterFactory.createCharacter("Swiftblade");
                                    user.getGuild().addCharacter(Swiftblade);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(10));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }

                        }

                    }
                }
                if(userChose>=11 && userChose<=15){
                    if(user.getGuild().getMage()==null){
                        switch (userChose){
                            case 11:
                                if(user.getGoldCoin()>=prices.get(11)){
                                    Character Warlock= CharacterFactory.createCharacter("Warlock");
                                    user.getGuild().addCharacter(Warlock);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(11));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 12:
                                if(user.getGoldCoin()>=prices.get(12)){
                                    Character Illusionist= CharacterFactory.createCharacter("Illusionist");
                                    user.getGuild().addCharacter(Illusionist);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(12));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 13:
                                if(user.getGoldCoin()>=prices.get(13)){
                                    Character Enchanter= CharacterFactory.createCharacter("Enchanter");
                                    user.getGuild().addCharacter(Enchanter);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(13));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 14:
                                if(user.getGoldCoin()>=prices.get(14)){
                                    Character Conjurer= CharacterFactory.createCharacter("Conjurer");
                                    user.getGuild().addCharacter(Conjurer);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(14));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 15:
                                if(user.getGoldCoin()>=prices.get(15)){
                                    Character Eldritch= CharacterFactory.createCharacter("Eldritch");
                                    user.getGuild().addCharacter(Eldritch);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(15));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }

                        }

                    }
                }
                if(userChose>=16 && userChose<=20){
                    if(user.getGuild().getHealer()==null){
                        switch (userChose){
                            case 16:
                                if(user.getGoldCoin()>=prices.get(16)){
                                    Character Soother= CharacterFactory.createCharacter("Soother");
                                    user.getGuild().addCharacter(Soother);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(16));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 17:
                                if(user.getGoldCoin()>=prices.get(17)){
                                    Character Medic= CharacterFactory.createCharacter("Medic");
                                    user.getGuild().addCharacter(Medic);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(17));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 18:
                                if(user.getGoldCoin()>=prices.get(18)){
                                    Character Alchemist= CharacterFactory.createCharacter("Alchemist");
                                    user.getGuild().addCharacter(Alchemist);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(18));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 19:
                                if(user.getGoldCoin()>=prices.get(19)){
                                    Character Saint= CharacterFactory.createCharacter("Saint");
                                    user.getGuild().addCharacter(Saint);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(19));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 20:
                                if(user.getGoldCoin()>=prices.get(20)){
                                    Character Lightbringer= CharacterFactory.createCharacter("Lightbringer");
                                    user.getGuild().addCharacter(Lightbringer);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(20));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }

                        }

                    }
                }
                if(userChose>=21 && userChose<=25){
                    if(user.getGuild().getMythical_Creature()==null){
                        switch (userChose){
                            case 21:
                                if(user.getGoldCoin()>=prices.get(21)){
                                    Character Dragon= CharacterFactory.createCharacter("Dragon");
                                    user.getGuild().addCharacter(Dragon);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(21));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 22:
                                if(user.getGoldCoin()>=prices.get(22)){
                                    Character Basilisk= CharacterFactory.createCharacter("Basilisk");
                                    user.getGuild().addCharacter(Basilisk);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(22));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 23:
                                if(user.getGoldCoin()>=prices.get(23)){
                                    Character Hydra= CharacterFactory.createCharacter("Hydra");
                                    user.getGuild().addCharacter(Hydra);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(23));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 24:
                                if(user.getGoldCoin()>=prices.get(24)){
                                    Character Phoenix= CharacterFactory.createCharacter("Phoenix");
                                    user.getGuild().addCharacter(Phoenix);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(24));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }
                            case 25:
                                if(user.getGoldCoin()>=prices.get(25)){
                                    Character Pegasus= CharacterFactory.createCharacter("Pegasus");
                                    user.getGuild().addCharacter(Pegasus);
                                    user.setGoldCoin(user.getGoldCoin()-prices.get(25));
                                }
                                else{
                                    System.out.println("You can not buy new character");
                                }

                        }

                    }
                }
                else{
                    displayController.displayMenu();
                    break;
                }

            }
            catch (Exception e){
                System.out.println("Invalid input, Enter again: ");
                input.next();
            }


        }

    }


}
