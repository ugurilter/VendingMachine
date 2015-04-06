package vendingmachine;

public class Calculation {
    
    private String changeList = "";
    
    public String getChangeList() {
        return changeList;
    }
    
    public String calculateChange(int itemPrice, int moneyInserted){        
        int change;
        String result = "";
        int Fifty = 0;
        int TwentyFive = 0;
        int Ten = 0;
        int Five = 0;
        
        change = (moneyInserted * 100) - itemPrice;
        
        while(change >= 50) { change -= 50; Fifty++; }
        while(change >= 25) { change -= 25; TwentyFive++; }
        while(change >= 10) { change -= 10; Ten++; }
        while(change >= 5) { change -= 5; Five++; }
        
        if(Fifty != 0) result += Fifty + "*50 Kuruş\n";
        if(TwentyFive != 0) result += TwentyFive + "*25 Kuruş\n";
        if(Ten != 0) result += Ten + "*10 Kuruş\n";
        if(Five != 0) result += Five +"*5 Kuruş.";
        
        return result;
    }
    
    public int validateInputs(int itemPrice, int moneyInserted){        
        if(itemPrice < 25) return 0;
        if(itemPrice > 200) return 1;
        if(itemPrice % 5 != 0) return 2;
        if(moneyInserted < 1) return 3;
        if(moneyInserted > 2) return 4;
        return 5;
    }
    
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
