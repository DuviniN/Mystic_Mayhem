import Character.Archers.Archer;
import Character.Healers.Healer;
import Character.Knights.Knight;
import Character.Mages.Mage;
import Character.Mythical_Creatures.Mythical_Creature;
import Equipment.Armour.Armour;
import Equipment.Armour.Chainmail;
import Equipment.Artefact.Artefact;

import java.util.InputMismatchException;
import java.util.Scanner;
import Character.Character;


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

    public void printTitle(String title){
        int lineLength = 85;
        int titleLength=title.length();
        int padding = (lineLength - titleLength) / 2;

        String formattedTitle=" ".repeat(Math.max(0,padding))+title;

        System.out.println("-".repeat(lineLength));
        System.out.println(formattedTitle);
        System.out.println("-".repeat(lineLength));
    }
    public void clearConsole(){
        try{
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            else{
                System.out.println("\\033[H\033[2J");
                System.out.flush();
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void printCharacterList(){
        String[][] characters={
                {"---Archer---","","","","",""},
                {"1.Shooter","80gc","11","4","6","9"},
                {"2.Ranger","115gc","14","5","8","10"},
                {"3.Sunfire","160gc","15","5","7","14"},
                {"4.Zing","200gc","16","9","11","14"},
                {"5.Saggitarius","230gc","18","7","12","17"},

                {"---Knights---","","","","",""},
                {"6.Squire","85gc","8","9","7","8"},
                {"7.Cavalier","115gc","10","12","7","10"},
                {"8.Templar","155gc","14","16","12","12"},
                {"9.Zoro","180gc","17","16","13","14"},
                {"10.Swiftblade","230gc","18","20","17","133"},

                {"---Mages---","","","","",""},
                {"11.Warlock","100gc","12","7","10","12"},
                {"12.Illusionist","120gc","13","8","12","14"},
                {"13.Enchanter","160gc","16","10","13","16"},
                {"14.Conjurer","195gc","18","15","14","12"},
                {"15.Eldritch","270gc","19","17","18","14"},

                {"---Healers---","","","","",""},
                {"16.Soother","95gc","10","8","9","6"},
                {"17.Medic","125gc","12","9","10","7"},
                {"18.Alchemist","150gc","13","13","13","13"},
                {"19.Saint","200gc","16","14","17","9"},
                {"20.Lightbringer","260gc","17","15","19","12"},

                {"---Mythical Creature---","","","","",""},
                {"21.Dragon","120gc","12","14","15","8"},
                {"22.Basilisk","165gc","15","11","10","12"},
                {"23.Hydra","205gc","12","16","15","11"},
                {"24.Phoenix","275gc","17","13","17","29"},
                {"25.Pegasus","340gc","14","18","20","20"},
        };
        System.out.printf("%-20s  | %-20s  | %-20s  | %-20s | %-20s | %-20s |%n",
                "Type","Price","Attack","Defence","Health","Speed");

        int index=1;
        for(String[] character: characters){
            if(character[1].isEmpty()){
                System.out.printf("%n%s%n",character[0]);
            }
            else{
                System.out.printf("%-2d | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
                        index++, character[0],character[1],character[2],character[3],character[4],character[5]);
            }
        }
    }
    public void printArmourList(){

        String[][] armour={
                {"1.Chainmail","70","no change","-1","no change","-1"},
                {"2,Regalia","105","no change","+1","no change","no change"},
                {"3.Fleece","150","no change","+2","+1","-1"},
        };
        System.out.printf(" %-15s  | %-12s  | %-15s  | %-12s  | %-15s  | %-15s  |%n",
                "Type","Price","Attack","Defence","Health","Speed");
        int index=1;
        for(String[] equipment:armour){
            System.out.printf(" %-15s  | %-12s  | %-15s  | %-12s  | %-15s  | %-15s  |%n",
                    equipment[0],equipment[1],equipment[2],equipment[3],equipment[4],equipment[5]);
        }


    }

    public void printArtefactList(){

        String[][] artefact={
                {"1.Excalibur","150","+2","no change","no change","no change"},
                {"2,Amulet","200","+1","-1","+1","+1"},
                {"3.Crystal","210","+2","+1","-1","-1"},
        };
        System.out.printf(" %-15s  | %-12s  | %-15s  | %-12s  | %-15s  | %-15s  |%n",
                "Type","Price","Attack","Defence","Health","Speed");
        int index=1;
        for(String[] equipment:artefact){
            System.out.printf(" %-15s  | %-12s  | %-15s  | %-12s  | %-15s  | %-15s  |%n",
                    equipment[0],equipment[1],equipment[2],equipment[3],equipment[4],equipment[5]);
        }


    }
    public String[] guildSelection(){
        System.out.println("Currently you have 500 gold coins. You can choose one guild from the following:");
        System.out.println("Select your guild");
        System.out.println(" ");
        System.out.println("<-Guild 1 ->");
        System.out.println("Archer: Shooter, Knight: Squire, Mage:Warlock, Healer:Soother, Mythical Creature: Dragon");
        System.out.println();
        System.out.println("<-Guild 2 ->");
        System.out.println("Archer: Shooter, Knight: Squire, Mage: Illusionist, Healer: Soother, Mythical Creature: Dragon");
        System.out.println();

        String[] guild;
        Scanner input=new Scanner(System.in);
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
    public int displayMenu(){
        clearConsole();
        printTitle("Menu");
        Scanner input=new Scanner(System.in);
        int userChoice;
        System.out.println("1.Battle");
        System.out.println("2.Buy Characters");
        System.out.println("3.Sell Characters");
        System.out.println("4.Buy Armour");
        System.out.println("5.Buy Artefact");
        System.out.println("6.Sell Armour");
        System.out.println("7.Sell Artefact");
        System.out.println("8.Exit");
        System.out.println();
        while(true){
            try{
                System.out.print("Select your choice:");
                userChoice=input.nextInt();
                return userChoice;

            } catch (Exception e) {
                System.out.println("Invalid input , please Enter again");
                input.next();
            }
        }
    }


    public void EquipmentOfGuild(User user) {
        clearConsole();
        String archer;
        String healer;
        String mage;
        String mythicalCreature;
        String knight;

        String archerArmour;
        String archerArtefact;
        String healerArmour;
        String healerArtefact;
        String mageArmour;
        String mageArtefact;
        String mythicalCreatureArmour;
        String mythicalCreatureArtefact;
        String knightArmour;
        String knightArtefact;


        if (user.getGuild().getArcher() == null) {
            archer = null;
            archerArmour = null;
            archerArtefact = null;
        }
        else {
            archer = user.getGuild().getHealer().getClass().getSimpleName();
            if (user.getGuild().getHealer().isArmour()) {
                archerArmour = user.getGuild().getHealer().getArmour().getClass().getSimpleName();
            } else {
                archerArmour = null;
            }
            if (user.getGuild().getHealer().isArtefact()) {
                archerArtefact = user.getGuild().getHealer().getArtefact().getClass().getSimpleName();
            } else {
                archerArtefact= null;
            }

        }
        if (user.getGuild().getHealer() == null) {
            healer = null;
            healerArmour= null;
            healerArtefact = null;
        } else {
            healer = user.getGuild().getHealer().getClass().getSimpleName();
            if (user.getGuild().getHealer().isArmour()) {
                healerArmour = user.getGuild().getHealer().getArmour().getClass().getSimpleName();
            } else {
                healerArmour = null;
            }
            if (user.getGuild().getHealer().isArtefact()) {
                healerArtefact = user.getGuild().getHealer().getArtefact().getClass().getSimpleName();
            } else {
                healerArtefact= null;
            }
        }
        if (user.getGuild().getMage() == null) {
            mage = null;
            mageArmour= null;
            mageArtefact = null;
        } else {
            mage= user.getGuild().getHealer().getClass().getSimpleName();
            if (user.getGuild().getMage().isArmour()) {
                mageArmour = user.getGuild().getMage().getArmour().getClass().getSimpleName();
            } else {
                mageArmour = null;
            }
            if (user.getGuild().getMage().isArtefact()) {
                mageArtefact = user.getGuild().getMage().getArtefact().getClass().getSimpleName();
            } else {
                mageArtefact= null;
            }
        }
        if (user.getGuild().getMythical_Creature() == null) {
            mythicalCreature = null;
            mythicalCreatureArmour= null;
            mythicalCreatureArtefact = null;
        } else {
            mythicalCreature = user.getGuild().getHealer().getClass().getSimpleName();
            if (user.getGuild().getMythical_Creature().isArmour()) {
                mythicalCreatureArmour = user.getGuild().getMythical_Creature().getArmour().getClass().getSimpleName();
            } else {
                mythicalCreatureArmour = null;
            }
            if (user.getGuild().getMythical_Creature().isArtefact()) {
                mythicalCreatureArtefact= user.getGuild().getMythical_Creature().getArtefact().getClass().getSimpleName();
            } else {
                mythicalCreatureArtefact= null;
            }
        }
        if (user.getGuild().getKnight() == null) {
            knight= null;
            knightArtefact= null;
            knightArmour = null;
        } else {
            knight = user.getGuild().getKnight().getClass().getSimpleName();
            if (user.getGuild().getKnight().isArmour()) {
                knightArmour = user.getGuild().getKnight().getArmour().getClass().getSimpleName();
            } else {
                knightArmour = null;
            }
            if (user.getGuild().getKnight().isArtefact()) {
                knightArtefact = user.getGuild().getKnight().getArtefact().getClass().getSimpleName();
            } else {
                knightArtefact= null;
            }
        }
        String[] characters={archer,healer,knight,mage,mythicalCreature};
        String[] armours={archerArmour,healerArmour,knightArmour,mageArmour,mythicalCreatureArmour};
        String[] artefacts={archerArtefact,healerArtefact,knightArtefact,mageArtefact,mythicalCreatureArtefact};

        System.out.printf("%-15s | %-15s | %-15s\n\n","Character","Armour","Artefact");

        for(int i=0;i<5;i++){
            System.out.printf("%-15s | %-15s | %-15s\n",characters[i],armours[i],artefacts[i]);
        }

    }

}
