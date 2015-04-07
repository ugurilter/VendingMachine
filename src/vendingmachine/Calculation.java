package vendingmachine;

/**
 * 
 * @author A. Uğur İLTER - 13070006026
 * @version 1.0
 * @since April, 2015
 */
public class Calculation {
    
    private String changeList = "";
    
    /**
     * Getter method for 'changeList' String variable.
     * @return 'changeList' String variable.
     */
    public String getChangeList() {
        return changeList;
    }
    
    
    /**
     * Change calculation method.
     * There are 4 different variables for each coin change type.
     * <ol><li>Fifty</li>
     * <li>TwentyFive</li>
     * <li>Ten</li>
     * <li>Five</li></ol>
     * 
     * Algorithm increases relevant variable's value according to how many times there is that coin in change, then reduces 'change' value.
     * @param itemPrice value of the item being bought from the Vending Machine.
     * @param moneyInserted amount of liras inserted to the Vending Machine.
     * @return a string consisting of how many there are from each coin, if there is any.
     */
    public String calculateChange(int itemPrice, int moneyInserted){        
        int change;                                                             //Change to be returned to the customer.
        String result = "";                                                     //Result string.
        int Fifty = 0;                                                          //Variable to store the amount of '50 Kr' coin change to be given back.
        int TwentyFive = 0;                                                     //Variable to store the amount of '25 Kr' coin change to be given back.
        int Ten = 0;                                                            //Variable to store the amount of '10 Kr' coin change to be given back.
        int Five = 0;                                                           //Variable to store the amount of '5 Kr' coin change to be given back.
        
        change = (moneyInserted * 100) - itemPrice;                             //Calculation of change.
        
        while(change >= 50) { change -= 50; Fifty++; }                          //Calculation of '50 Kr' coins amount.
        while(change >= 25) { change -= 25; TwentyFive++; }                     //Calculation of '25 Kr' coins amount.
        while(change >= 10) { change -= 10; Ten++; }                            //Calculation of '10 Kr' coins amount.
        while(change >= 5) { change -= 5; Five++; }                             //Calculation of '5 Kr' coins amount.
        
        if(Fifty != 0) result += Fifty + "*50 Kuruş\n";                         //Amount of '50 Kr' being added to the result string.
        if(TwentyFive != 0) result += TwentyFive + "*25 Kuruş\n";               //Amount of '10 Kr' being added to the result string.
        if(Ten != 0) result += Ten + "*10 Kuruş\n";                             //Amount of '25 Kr' being added to the result string.
        if(Five != 0) result += Five +"*5 Kuruş.";                              //Amount of '5 Kr' being added to the result string.
        
        return result;
    }
    
    /**
     * Input validation method.
     * This method checks user inputs against the project requirements.
     * There are 6 possible states to be returned;
     * <ol><li>0 - itemPrice is less than 25</li>
     * <li>1 - itemPrice is more than 200</li>
     * <li>2 - itemPrice is not multiple of 5</li>
     * <li>3 - moneyInserted is less than 1</li>
     * <li>4 - moneyInserted is more than 2</li>
     * <li>5 - all inputs are valid</li></ol>
     * @param itemPrice value of the item being bought from the Vending Machine.
     * @param moneyInserted amount of liras inserted to the Vending Machine.
     * @return related integer value of validation state.
     */
    public int validateInputs(int itemPrice, int moneyInserted){        
        if(itemPrice < 25) return 0;
        if(itemPrice > 200) return 1;
        if(itemPrice % 5 != 0) return 2;
        if(moneyInserted < 1) return 3;
        if(moneyInserted > 2) return 4;
        return 5;
    }
    
    /**
     * Main operation called by Vending Machine to start validating inputs and calculating the change.
     * Gives relevant error message if one of the inputs is invalid then returns false.
     * Otherwise calculates the change and returns true.
     * @param itemPrice value of the item being bought from the Vending Machine.
     * @param moneyInserted amount of liras inserted to the Vending Machine.
     * @return <li>true - if inputs are valid.</li>
     * <li>false - if inputs are invalid.</li>
     */
    public boolean executeOperation(int itemPrice, int moneyInserted){
        int status = validateInputs(itemPrice, moneyInserted);
        
        switch(status){
            case 0:
                System.out.println("Item price can not be less than 25 kuruş.");
                break;
            case 1:
                System.out.println("Item price can not be more than 200 kuruş.");
                break;
            case 2:
                System.out.println("Item price has to be a multiple of 5 kuruş.");
                break;
            case 3:
                System.out.println("You can not insert less than 1 lira in to the Vending Machine.");
                break;
            case 4:
                System.out.println("You can not insert more than 2 liras in to the Vending Machine.");
                break;
            case 5:
                changeList = calculateChange(itemPrice, moneyInserted);
                return true;                
        }
        
        return false;        
    }
}
