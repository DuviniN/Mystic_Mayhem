import Character.Archers.Archer;

import java.util.*;

import Character.Archers.Shooter;
import Character.Character;
public class GameController {
    private static HashMap<String,User>users=new HashMap<>();
    DisplayController displayController=new DisplayController();
    final Scanner input=new Scanner(System.in);
    public User login(){
        displayController.printTTitle("Login");
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

        displayController.printTTitle("Register");

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
        return user;
    }
    public String[] guildSelection(){
        System.out.println("Currently you have 500 gold coins. You can choose one guild from the following:");
        System.out.println("Select your guild");

        System.out.println("<-Guild 1 ->");
        System.out.println("Archer: Shooter, Knight: Squire, Mage:Warlock, Healer:Soother, Mythical Creature: Dragon");
        System.out.println("<-Guild 2 ->");
        System.out.println("Archer: Shooter, Knight: Squire, Mage: Illusionist, Healer: Soother, Mythical Creature: Dragon");

        String[] guild;
        while (true){
            try {
                System.out.println("Select 1 or 2:");
                int choice = input.nextInt();
                if(choice==1){
                    guild=new String[]{"Shooter","Squire","Warlock","Soother","Dragon"};
                    break;
                }
                else if(choice ==2){
                    guild=new String[]{"Shooter","Squire","Illusionist","Soother","Dragon"};
                    break;
                }
                else{
                    System.out.println("Invalid input,please enter 1 oe 2");
                    input.next();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, please enter 1 or 2");
                input.next();
            }

        }
        return guild;
    }

}
