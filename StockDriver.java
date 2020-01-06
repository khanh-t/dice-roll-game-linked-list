/**
 * Solution incomplete. Did not have time to code the part where
 * I have to print out the shares held after each transaction.
 * @author Khanh Tran
 */
import java.util.Scanner;

public class StockDriver {
    public static void main(String args[]) {
        
        boolean stockLoop = true;
        Scanner keyboard = new Scanner(System.in);
        //the following variables simply holds different user input
        int selectionInput;
        int sharesInput;
        int valueInput; 
        //keep track of totals
        int totalShares = 0;
        int totalValue = 0;
        //this variable is used to calculate capital gain later
        int calcCapitalGain = 0;
        //two linked queues, one for shares and one for price
        LinkedQueue<Integer> shares = new LinkedQueue<>();
        LinkedQueue<Integer> price = new LinkedQueue<>();
        
        //loop selections until user quits
        while (stockLoop) {
            System.out.println("Make a selection:");
            System.out.println("1. Buy shares");
            System.out.println("2. Sell shares");
            System.out.println("3. Quit");
            
            selectionInput = keyboard.nextInt();
            
            if (selectionInput == 1) {
                System.out.println("Enter the number of shares to buy: ");
                sharesInput = keyboard.nextInt();
                shares.enqueue(sharesInput);
                totalShares += sharesInput;
                
                System.out.println("Enter the purchase price per share: ");
                valueInput = keyboard.nextInt();
                price.enqueue(valueInput);
                totalValue += (sharesInput * valueInput);
                
                System.out.println("Total shares: " + totalShares);
                System.out.println("Total share value: " + totalValue);
            }
            else if (selectionInput == 2) {
                System.out.println("Enter the number of shares to sell: ");
                sharesInput = keyboard.nextInt();
                //this variable is used to calculate capital gain
                int sharesNumber = sharesInput;
                //keep looping until you remove all shares from the linked queue
                //equal to the number of shares sold
                while (sharesInput >= shares.first()) {
                    totalShares -= shares.first();
                    totalValue -= (shares.first() * price.first());
                    sharesInput -= shares.first();
                    calcCapitalGain += (shares.first() * price.first());
                    shares.dequeue();
                    price.dequeue();
                    //if there are no more shares in linked queue, break loop
                    if (shares.first() == null) {
                        break;
                    }
                }
                System.out.println("Enter the selling price per share: ");
                valueInput = keyboard.nextInt();
                calcCapitalGain = ((sharesNumber * valueInput) - calcCapitalGain);
                
                System.out.println("Capital gain: = $" + calcCapitalGain);                
            }
            //quit program
            else {
                break;
            }
        }
    }
}
