import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        DisplayController displayController =new DisplayController();
        GameController gameController =new GameController();
        final Scanner input =new Scanner(System.in);
        int userChoice= displayController.loginPage();

    }
}
