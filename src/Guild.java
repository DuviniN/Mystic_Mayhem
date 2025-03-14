import java.util.ArrayList;
import java.util.List;
import Character.Character;
import Character.Archers.Archer;
import Character.Knights.Knight;
import Character.Mages.Mage;
import Character.Mythical_Creatures.Mythical_Creature;
import Character.Healers.Healer;

    public class Guild {
        private static final int MAX_SIZE = 5;
        private List<Character> guild = new ArrayList<>();

        private boolean hasArcher = false;
        private boolean hasKnight = false;
        private boolean hasMage = false;
        private boolean hasMythicalCreature = false;
        private boolean hasHealer = false;

        public void addCharacter(Character character) {
            if (guild.size() < MAX_SIZE) {
                switch (character) {
                    case Archer archer when !hasArcher -> {
                        guild.add(character);
                        hasArcher = true;
                        System.out.println("Archer added");
                    }
                    case Knight knight when !hasKnight -> {
                        guild.add(character);
                        hasKnight = true;
                        System.out.println("Knight added");
                    }
                    case Mage mage when !hasMage -> {
                        guild.add(character);
                        hasMage = true;
                        System.out.println("Mage added");
                    }
                    case Mythical_Creature mythicalCreature when !hasMythicalCreature -> {
                        guild.add(character);
                        hasMythicalCreature = true;
                        System.out.println("Mythical Creature added");
                    }
                    case Healer healer when !hasHealer -> {
                        guild.add(character);
                        hasHealer = true;
                        System.out.println("Healer added");
                    }
                    case null, default -> System.out.println("Invalid character");
                }
            } else {
                System.out.println("Guild is full");
            }
        }

        public Character getArcher() {
            if(hasArcher) {
                return guild.stream().filter(character -> character instanceof Archer).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getHealer() {
            if(hasArcher) {
                return guild.stream().filter(character -> character instanceof Healer).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getKnight() {
            if(hasArcher) {
                return guild.stream().filter(character -> character instanceof Knight).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getMage() {
            if(hasArcher) {
                return guild.stream().filter(character -> character instanceof Mage).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getMythical_Creature() {
            if(hasArcher) {
                return guild.stream().filter(character -> character instanceof Mythical_Creature).findFirst().orElse(null);
            } else {
                return null;
            }
        }


        public void removeArcher() {
            if (hasArcher) {
                guild.removeIf(character -> character instanceof Archer);
                hasArcher = false;
                System.out.println("Archer removed");
            } else {
                System.out.println("No archer in the guild");
            }
        }
        public void removeHealer() {
            if (hasArcher) {
                guild.removeIf(character -> character instanceof Healer);
                hasArcher = false;
                System.out.println("Healer removed");
            } else {
                System.out.println("No healer in the guild");
            }
        }
        public void removeKnight() {
            if (hasArcher) {
                guild.removeIf(character -> character instanceof Knight);
                hasArcher = false;
                System.out.println("Knight removed");
            } else {
                System.out.println("No knight in the guild");
            }
        }
        public void removeMage() {
            if (hasArcher) {
                guild.removeIf(character -> character instanceof Mage);
                hasArcher = false;
                System.out.println("Mage removed");
            } else {
                System.out.println("No mage in the guild");
            }
        }
        public void removeMythical_Creatures() {
            if (hasArcher) {
                guild.removeIf(character -> character instanceof Mythical_Creature);
                hasArcher = false;
                System.out.println("Mythical Creature removed");
            } else {
                System.out.println("No mythical creature in the guild");
            }
        }
       public Character equalDefence(Character character1,Character character2){
            if(character1 instanceof Healer){
                return character1;
            }
            else if (character2 instanceof  Healer) {
                return character2;

            }
           if(character1 instanceof Mythical_Creature){
               return character1;
           }
           else if (character2 instanceof  Mythical_Creature) {
               return character2;

           }
           if(character1 instanceof Archer){
               return character1;
           }
           else if (character2 instanceof  Archer) {
               return character2;

           }
           if(character1 instanceof Knight){
               return character1;
           }
           else if (character2 instanceof  Knight) {
               return character2;

           }
           if(character1 instanceof Mage){
               return character1;
           }
           else {
               return character2;

           }

       }
        public Character equalSpeed(Character character1,Character character2){
            if(character1 instanceof Archer){
                return character1;
            }
            else if (character2 instanceof Archer) {
                return character2;

            }
            if(character1 instanceof Knight){
                return character1;
            }
            else if (character2 instanceof Knight) {
                return character2;

            }
            if(character1 instanceof Mythical_Creature){
                return character1;
            }
            else if (character2 instanceof  Mythical_Creature) {
                return character2;

            }
            if(character1 instanceof Mage){
                return character1;
            }
            else if (character2 instanceof  Mage) {
                return character2;

            }
            if(character1 instanceof Healer){
                return character1;
            }
            else {
                return character2;

            }

        }

        public Character getdefencer(){
            Character minDefencer= guild.get(0);
            for(int i=1;i<5;i++){
                if(guild.get(i).getDefence()<minDefencer.getDefence()){
                    minDefencer= guild.get(i);
                }
                else if(guild.get(i).getDefence()== minDefencer.getDefence()){
                    minDefencer=equalDefence(guild.get(i),minDefencer);
                }
            }
            return minDefencer;
        }

        public Character getFaster(){
            Character maxspeed=guild.get(0);
            for(int i=1;i<5;i++){
                if(guild.get(i).getDefence()>maxspeed.getDefence()){
                    maxspeed= guild.get(i);
                }
                else if(guild.get(i).getDefence()== maxspeed.getDefence()){
                    maxspeed=equalSpeed(guild.get(i),maxspeed);
                }
            }
            return maxspeed;


        }






    }

