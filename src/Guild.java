import java.util.ArrayList;
import java.util.List;
import Character.Character;
import Character.Archers.Archer;
import Character.Knights.Knight;
import Character.Mages.Mage;
import Character.Mythical_Creatures.Mythical_Creature;
import Character.Healers.Healer;
import Character.CharacterState;

    public class Guild {
        private static final int MAX_SIZE = 5;
        private List<Character> guildList = new ArrayList<>();

        private boolean hasArcher = false;
        private boolean hasKnight = false;
        private boolean hasMage = false;
        private boolean hasMythicalCreature = false;
        private boolean hasHealer = false;

        public void addCharacter(Character character) {
            if (guildList.size() < MAX_SIZE) {
                switch (character) {
                    case Archer archer when !hasArcher -> {
                        guildList.add(character);
                        hasArcher = true;
                        System.out.println("Archer added");
                    }
                    case Knight knight when !hasKnight -> {
                        guildList.add(character);
                        hasKnight = true;
                        System.out.println("Knight added");
                    }
                    case Mage mage when !hasMage -> {
                        guildList.add(character);
                        hasMage = true;
                        System.out.println("Mage added");
                    }
                    case Mythical_Creature mythicalCreature when !hasMythicalCreature -> {
                        guildList.add(character);
                        hasMythicalCreature = true;
                        System.out.println("Mythical Creature added");
                    }
                    case Healer healer when !hasHealer -> {
                        guildList.add(character);
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
                return guildList.stream().filter(character -> character instanceof Archer).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getHealer() {
            if(hasHealer) {
                return guildList.stream().filter(character -> character instanceof Healer).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getKnight() {
            if(hasKnight) {
                return guildList.stream().filter(character -> character instanceof Knight).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getMage() {
            if(hasMage) {
                return guildList.stream().filter(character -> character instanceof Mage).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public Character getMythical_Creature() {
            if(hasMythicalCreature) {
                return guildList.stream().filter(character -> character instanceof Mythical_Creature).findFirst().orElse(null);
            } else {
                return null;
            }
        }
        public String getArcherType(){
            Character archer = getArcher();
            return archer != null ? archer.getClass().getSimpleName() : "null";
        }
        public String getKnightType(){
            Character knight = getKnight();
            return knight != null ? knight.getClass().getSimpleName() : "null";
        }
        public String getHealerType(){
            Character healer = getHealer();
            return healer != null ? healer.getClass().getSimpleName() : "null";
        }
        public String getMageType(){
            Character mage = getMage();
            return mage != null ? mage.getClass().getSimpleName() : "null";
        }
        public String getMythical_CreatureType(){
            Character mythicalCreature = getMythical_Creature();
            return mythicalCreature != null ? mythicalCreature.getClass().getSimpleName() : "null";
        }
        public List<Character> getGuildList() {
            return guildList;
        }

        public void removeArcher() {
            if (hasArcher) {
                guildList.removeIf(character -> character instanceof Archer);
                hasArcher = false;
                System.out.println("Archer removed");
            } else {
                System.out.println("No archer in the guild");
            }
        }
        public void removeHealer() {
            if (hasHealer) {
                guildList.removeIf(character -> character instanceof Healer);
                hasHealer = false;
                System.out.println("Healer removed");
            } else {
                System.out.println("No healer in the guild");
            }
        }
        public void removeKnight() {
            if (hasKnight) {
                guildList.removeIf(character -> character instanceof Knight);
                hasKnight = false;
                System.out.println("Knight removed");
            } else {
                System.out.println("No knight in the guild");
            }
        }
        public void removeMage() {
            if (hasMage) {
                guildList.removeIf(character -> character instanceof Mage);
                hasMage = false;
                System.out.println("Mage removed");
            } else {
                System.out.println("No mage in the guild");
            }
        }
        public void removeMythical_Creatures() {
            if (hasMythicalCreature) {
                guildList.removeIf(character -> character instanceof Mythical_Creature);
                hasMythicalCreature = false;
                System.out.println("Mythical Creature removed");
            } else {
                System.out.println("No mythical creature in the guild");
            }
        }

       public Character getDefencePriority(Character character1,Character character2){
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
        public Character getSpeedPriority(Character character1,Character character2){
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

        public Character getLowestDefenceCharacter(){
            Character minDefence=guildList.stream().filter(c -> c.getState() != CharacterState.DEATH).findFirst().orElse(null);
            if(minDefence==null){
                return null;
            }
            for(Character c:guildList){
                if(c.getState()!=CharacterState.DEATH && c.getDefence()<minDefence.getDefence()){
                    minDefence=c;
                }
                else if(c.getState() != CharacterState.DEATH && c.getDefence()==minDefence.getDefence()){
                    minDefence=getDefencePriority(minDefence,c);
                }
            }
            return minDefence;
        }

        public Character getFastestCharacter(){
            int count=0;
            for(Character ch:guildList){
                if(ch.getState()==CharacterState.DEFENDING) {
                    count++;
                }
            }
            if(count==0){
                for(Character c:guildList){
                    if(c.getState()!=CharacterState.DEATH){
                        c.setState(CharacterState.DEFENDING);
                    }
                }
            }
            Character maxSpeed=guildList.stream().filter(c -> c.getState() == CharacterState.DEFENDING).findFirst().orElse(null);
            if(maxSpeed==null){
                return null;
            }
            for(Character c:guildList){
                if(c.getState()==CharacterState.DEFENDING && c.getSpeed()>maxSpeed.getSpeed()) {
                    maxSpeed = c;
                }
                else if(c.getState()==CharacterState.DEFENDING && c.getSpeed()>maxSpeed.getSpeed()){
                    maxSpeed=getSpeedPriority(maxSpeed,c);
                }
            }
            maxSpeed.setState(CharacterState.ATTACKING);
            return maxSpeed;
        }

        public Character getLowestHealthCharacter(){
            Character minHealth=guildList.stream().filter(c -> c.getState() != CharacterState.DEATH).findFirst().orElse(null);
            if(minHealth == null){
                return null;
            }
            for(Character c:guildList){
                if(c.getState()!=CharacterState.DEATH && c.getHealth()<minHealth.getHealth()){
                    minHealth=c;
                }
            }
            return minHealth;
        }

        /* private int getSpeedPriority(Character character){
             if(character instanceof Healer)return 1;
             if(character instanceof Mage)return 2;
             if(character instanceof Mythical_Creature)return 3;
             if(character instanceof Knight)return 4;
             if(character instanceof Archer)return 5;
             return1;
           }

           private int getDefensePriority(Character character){
             if(character instanceof Healer)return 1;
             if(character instanceof Mythical_Creature)return 2;
             if(character instanceof Archer)return 3;
             if(character instanceof Knight)return 4;
             if(character instanceof Mage)return 5;
             return Integer.MAX_VALUE;
            }


            public Character getFastestCharacter(){
               return guild.stream().max(Comparator.comparingInt(Character::getSpeed).thenComparing(this::getSpeedPriority)).orElse(null);
            }

            public Character getLowestDefenseCharacterr(){
               return guild.stream().min(Comparator.comparingInt(Character::getDefence).thenComparing(this::getDefensePriority)).orElse(null);
            }

         */






    }

