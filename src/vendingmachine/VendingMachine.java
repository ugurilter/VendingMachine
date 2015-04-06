package vendingmachine;

import java.util.Scanner;

public class VendingMachine {
    
    public static void main(String[] args) {
        int itemPrice;
        int moneyInserted;
        Scanner input = new Scanner(System.in);      
        
        System.out.println("Enter the price of the item: ");
        itemPrice = input.nextInt();
        System.out.println("Enter the number of 1 lira coins you have inserted into the machine: ");
        moneyInserted = input.nextInt();
        
        Calculation calc = new Calculation(itemPrice, moneyInserted);
        
        if(calc.executeOperation()){
            System.out.println("You bought an item for " + itemPrice + " kuruş and gave me " + moneyInserted + " lira, so your change is:");
            System.out.println(calc.getChangeList());
        }       
    }
    
}
