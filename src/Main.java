import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DisplayController displayController =new DisplayController();
        GameController gameController =new GameController();
        final Scanner input =new Scanner(System.in);

        User user;

        int userChoice=displayController.loginPage();
        if(userChoice==1){
            user=gameController.login();
        }
        else{
            user=gameController.register();
        }

        while(true){
            userChoice=displayController.displayMenu();
            switch (userChoice){
                case 1->gameController.battle(user);
                case 2->gameController.buyCharacter(user);
                case 3->gameController.sellCharacter(user);
                case 4->gameController.buyArmour(user);
                case 5->gameController.buyArtefact(user);
                case 6->gameController.sellArmour(user);
                case 7->gameController.sellArtefact(user);

            }
        }

    }
}
