import java.util.Scanner;
import java.util.HashMap;
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
}
