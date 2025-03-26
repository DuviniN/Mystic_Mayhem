# Mystic Mayhem

## Description
Mystic Mayhem is a turn-based console game where two players battle using a strategic selection of characters. Each player commands an army consisting of an Archer, a Knight, a Mage, a Healer, and a Mythical Creature. Players can earn gold, customize their armies, and engage in strategic combat.

## Features
- Player profile creation with unique usernames.
- Gold coin economy for purchasing characters and equipment.
- A variety of characters with different stats.
- Equipable items like armor and artifacts to enhance abilities.
- Turn-based battle system with attack prioritization.
- Dynamic battlefield mechanics influenced by home grounds.

## Installation
1. Clone this repository:
   ```sh
   git clone https://github.com/DuviniN/Mystic_Mayhem.git
   ```
2. Navigate to the project folder:
   ```sh
   cd mystic-mayhem
   ```
3. Compile the Java source code:
   ```sh
   javac -d bin src/*.java
   ```
4. Run the game:
   ```sh
   java -cp bin Main
   ```

## Gameplay
### Player Setup
- Each player starts with 500 gold coins.
- Players must purchase characters to form their army.
- Characters can be sold for 90% of their value.
- Equipment can be used to enhance character stats.

### Battle System
- Players take turns attacking based on character speed.
- The attacker is determined based on a priority order.
- Different battlefield types affect character abilities.
- The game ends when all characters of one player are defeated or after 10 turns.

## File Structure
```
src/
├── Character/
│   ├── Archers/
│   ├── Healers/
│   ├── Knights/
│   ├── Mages/
│   ├── Mythical_Creatures/
│   ├── Character.java
│   ├── CharacterState.java
├── Equipment/
├── DisplayController.java
├── GameController.java
├── Guild.java
├── Main.java
├── User.java
.gitignore
```

## Contribution
Feel free to fork the repository and submit pull requests for improvements.

## License
This project is licensed under the MIT License.
