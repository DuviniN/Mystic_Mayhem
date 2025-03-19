import java.util.InputMismatchException;
import java.util.Scanner;
public class DisplayController {
    public int loginPage(){
        System.out.println("-----------------------------------MYSTIC MAYHEM---------------------------");
        Scanner input =new Scanner(System.in);
        while (true){
            try {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                int chose = input.nextInt();
                if (chose > 0 && chose < 4) {
                    return chose;
                } else {
                    System.out.println("invelid input , please chose again 1,2 or 3");
                }
            }
            catch(InputMismatchException exeption){
                    System.out.println("Invalid Input ,Please chose again:");
                    System.out.println("Please chose from selection");
                    input.next();
            }
        }
    }

    public void printTTitle(String title){
        int lineLength = 85;
        int titleLength=title.length();
        int padding = (lineLength - titleLength) / 2;

        String formattedTitle=" ".repeat(Math.max(0,padding))+title;

        System.out.println("-".repeat(lineLength));
        System.out.println(formattedTitle);
        System.out.println("-".repeat(lineLength));


    }
}
