import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DisplayController displayController =new DisplayController();
        GameController gameController =new GameController();
        final Scanner input =new Scanner(System.in);
        int userChoice= displayController.loginPage();

        User user;
        if(userChoice==1){
            displayController.clearConsole();
            user= gameController.login();
        }
        else{
            displayController.clearConsole();
            user= gameController.register();
        }

        while (true){
            userChoice = displayController.displayMenu();
            switch (userChoice){
                case 2 -> gameController.buyCharacter(user);
                case 3 -> gameController.sellCharacter(user);
            }
        }
    }
}
