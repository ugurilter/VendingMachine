package vendingmachine;

import java.util.Scanner;

public class VendingMachine {
    
    private static int itemPrice;
    private static int moneyInserted;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the price of the item: ");
        itemPrice = input.nextInt();
        System.out.println("Enter the number of 1 lira coins you have inserted into the machine: ");
        moneyInserted = input.nextInt();
        
        
        
    }
    
}
