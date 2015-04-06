package vendingmachine;

public class Calculation {

    private int itemPrice;
    private int moneyInserted;
    private int change;

    public Calculation(int itemPrice, int moneyInserted) {
        this.itemPrice = itemPrice;
        this.moneyInserted = moneyInserted;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }
    
    public void calculateChange(){
        
    }
    
    public int validateInputs(){        
        if(itemPrice < 25) return 0;
        if(itemPrice > 200) return 1;
        if(itemPrice % 5 != 0) return 2;
        if(moneyInserted < 1) return 3;
        if(moneyInserted > 2) return 4;
        return 5;
    }
    
    public void executeOperation(){
        int status = validateInputs();
        
        
    }
}
