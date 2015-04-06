package vendingmachine;

import static java.lang.System.exit;
import java.util.Scanner;

public class VendingMachine {
    
    public static void main(String[] args) {
        int itemPrice=0;
        int moneyInserted=0;
        Scanner input = new Scanner(System.in);      
        
        
        try {
            System.out.println("Enter the price of the item: ");
            itemPrice = input.nextInt();
            System.out.println("Enter the number of 1 lira coins you have inserted into the machine: ");
            moneyInserted = input.nextInt();
        }
        catch (Exception ex){
            System.out.println("WARNING: Bad input, Terminating !");
            exit(0);
        }
        
        Calculation calc = new Calculation();
        
        if(calc.executeOperation(itemPrice, moneyInserted)){
            System.out.println("You bought an item for " + itemPrice + " kuruş and gave me " + moneyInserted + " lira, so your change is:");
            System.out.println(calc.getChangeList());
        }       
    }
    
}
