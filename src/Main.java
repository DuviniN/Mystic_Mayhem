import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DisplayController displayController =new DisplayController();
        GameController gameController =new GameController();
        final Scanner input =new Scanner(System.in);
        int userChoice= displayController.loginPage();
       displayController.printArmourList();


        User user;
        if(userChoice==1){
            displayController.clearConsole();
            user= gameController.login();
        }
        else{
            displayController.clearConsole();
            user= gameController.register();
        }
        displayController.EquipmentOfGuild(user);


        while (true){

            switch (userChoice){
                case 2 -> gameController.buyCharacter(user);
                case 3 -> gameController.sellCharacter(user);
            }

        }
    }
}
