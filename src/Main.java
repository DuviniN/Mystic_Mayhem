import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DisplayController displayController =new DisplayController();
        GameController gameControl=new GameController();
        final Scanner input =new Scanner(System.in);
        int userChoice= displayController.loginPage();

        User user;
        if(userChoice==1){
            displayController.clearConsole();
            user=gameControl.login();
        }
        else{
            displayController.clearConsole();
            user=gameControl.register();
        }
        user.toString();
        displayController.displayMenu();







    }
}