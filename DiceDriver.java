/**
 * This is the driver for part A
 * @author Khanh Tran
 */
import java.util.Random;

public class DiceDriver {
    public static void main(String args[]){
        //creating four players
        Player person1 = new Player("Khanh");
        Player person2 = new Player("Joe");
        Player person3 = new Player("Jen");
        Player person4 = new Player("Josh");
        
        //creating the linked list and adding the players into the list
        CircularlyLinkedList<Player> diceGame = new CircularlyLinkedList<>();
        diceGame.addFirst(person1);
        diceGame.addLast(person2);
        diceGame.addLast(person3);
        diceGame.addLast(person4);
        
        //creating random generator
        Random die = new Random();
        
        //simulate the dice game with do-while loop
        do {
            int dice1 = die.nextInt(6) + 1;
            int dice2 = die.nextInt(6) + 1;
            int total = dice1 + dice2;
            //hold current player
            Player currentPlayer = diceGame.first();
            //hold current player name
            String currentPlayerName = currentPlayer.getName();
            //current player results
            System.out.println("Player " + currentPlayerName + " rolled "
                    + dice1 + " and " + dice2);
            //eliminate if they rolled snake eyes
            if (dice1 == 1 && dice2 == 1) {
                System.out.println("Player " + currentPlayerName +
                        " rolled snake eyes and will be eliminated!");
                diceGame.removeFirst();
            }
            //add their results to their total and rotate to next player, or
            //break out of loop if they reached 100, ending the game
            else {
                currentPlayer.addScore(total);
                if (currentPlayer.getScore() >= 100) {
                    System.out.println("Player " + currentPlayerName + 
                            " has reached 100 and won!");
                    break;
                }
                diceGame.rotate();
            }
        }
        //end game when there is only 1 player left
        while (diceGame.size() > 1);

        //show the results of the remaining players
        System.out.println("Here are the final results!");
        while (diceGame.size() > 0) {
            Player results = diceGame.first();
            System.out.println("Player " + results.getName() + " scored " +
                    results.getScore());
            diceGame.removeFirst();
        }
        System.out.println("Good game!");
    }
}
