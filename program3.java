import java.util.*;

class Dice{
        private String diceType;
        private int numSides;
        private int sideUp;
        private Random random = new Random();
        private int NumberOfRolls = 0;

        // Constructors
        // zero value constructor
        Dice(){
                diceType = "d6";
                numSides = 6;
                sideUp = 1 + random.nextInt(6);
        }

        // Constructor for Number of sides as parameter
        Dice(int numSides){
                this.numSides = numSides;
                this.diceType = "d"+numSides;
                this.sideUp =  1 + random.nextInt(numSides);
        }

        // Constructor for Dice Type and Number of Sides as parameters
        Dice(String diceType, int numSides){
                this.diceType = diceType;
                this.numSides = numSides;
                this.sideUp = 1 + random.nextInt(numSides);
        }

        // Accessors
        public int getNumberOfSides(){
                return numSides;
        }

        public int getNumberOfRolls(){
                return NumberOfRolls;
        }

        public String getDiceType(){
                return diceType;
        }

        public int getSideUp(){
                return sideUp;
        }

        // Mutators

        public void setDiceType(String diceType){
                this.diceType = diceType;
        }

        public void setNumberOfSides(int numSides){
                this.numSides = numSides;
        }

        public void setSideUp(int value){
                if(value < numSides && value > 0){
                        this.sideUp = value;
                }else{
                        this.sideUp = 1 + random.nextInt(numSides);
                }
        }
        // This method returns a random number between 1 and Number of Sides (numSides)
        public int roll(){
     ++NumberOfRolls;
     return 1 + random.nextInt(numSides);
   }
}

// Main Class to test each Dice Constructor
public class DiceTest
{
    public static void main(String[] args)
    {

        Dice dice1 = new Dice();
        Dice dice2 = new Dice(8);
        Dice dice3 = new Dice("d7",7);
        System.out.println("Rolling the first Dice Which has "+ dice1.getNumberOfSides() + " Sides");
        System.out.println("Before setting the sidesUp of the Dice, The SideUp is "+ dice2.getSideUp());
        dice2.setSideUp(2);
        System.out.println("After setting the SideUp of the Dice, The Side up is "+dice2.getSideUp());

    }
}
As I told you already that the above code does not validate the BONUS condition:

The below Code will Validate the BONUS Condition(Cold-Yahtzee):

import java.util.*;

class Dice{
        private String diceType;
        private int numSides;
        private int sideUp;
        private Random random = new Random();
        private int NumberOfRolls = 0;

        // Constructors
        // zero value constructor
        Dice(){
                diceType = "d6";
                numSides = 6;
                sideUp = 1 + random.nextInt(6);
        }

        // Constructor for Number of sides as parameter
        Dice(int numSides){
                this.numSides = numSides;
                this.diceType = "d"+numSides;
                this.sideUp =  1 + random.nextInt(numSides);
        }

        // Constructor for Dice Type and Number of Sides as parameters
        Dice(String diceType, int numSides){
                this.diceType = diceType;
                this.numSides = numSides;
                this.sideUp = 1 + random.nextInt(numSides);
        }

        // Accessors
        public int getNumberOfSides(){
                return numSides;
        }

        public int getNumberOfRolls(){
                return NumberOfRolls;
        }

        public String getDiceType(){
                return diceType;
        }

        public int getSideUp(){
                return sideUp;
        }

        // Mutators

        public void setDiceType(String diceType){
                this.diceType = diceType;
        }

        public void setNumberOfSides(int numSides){
                this.numSides = numSides;
        }

        public void setSideUp(int value){
                if(value < numSides && value > 0){
                        this.sideUp = value;
                }else{
                        this.sideUp = 1 + random.nextInt(numSides);
                }
        }
        // This method returns a random number between 1 and Number of Sides (numSides)
        public int roll(){
     ++NumberOfRolls;
     return 1 + random.nextInt(numSides);
   }
}



// Testing Class to validate the Cold-Yahtzee
public class DiceTest
{
    public static void main(String[] args)
    {

        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Dice dice3 = new Dice(6);
        Dice dice4 = new Dice(6);
        Dice dice5 = new Dice(6);

        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        int roll3 = dice3.roll();
        int roll4 = dice4.roll();
        int roll5 = dice5.roll();
        while(true){
                if(roll1 == roll2 && roll1 == roll3 && roll1 == roll4 && roll1 == roll5){
                        System.out.println("Bingo Cold-Yahtzee happens on the " + dice1.getNumberOfRolls()+" rolls");
                        break;
                }else{
                        System.out.printf("%d %d %d %d %d \n", roll1, roll2, roll3, roll4, roll4);
                        roll1 = dice1.roll();
                        roll2 = dice2.roll();
                        roll3 = dice3.roll();
                        roll4 = dice4.roll();
                        roll5 = dice5.roll();
                }
        }
    }
}
