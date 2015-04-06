package vendingmachine;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class ExecuteOperationTest {
    
    private int itemPrice;
    private int moneyInserted;
    private boolean expResult;

    public ExecuteOperationTest(int itemPrice, int moneyInserted, boolean expResult) {
        this.itemPrice = itemPrice;
        this.moneyInserted = moneyInserted;
        this.expResult = expResult;
    }    
    
    @Parameters
    public static Collection data() {
        return Arrays.asList( new Object[ ][ ] { { 33, 2, false }, { 10, 1, false }, { 250, 2, false }, { 45, 5, false }, { 40, 0, false }, 
                                                 { 45, 1, true }, { 30, 2, true }, { 100, 2, true }, { 55, 1, true }, { 70, 2, true } });
    }
    
    /**
     * Test of executeOperation method, of class Calculation.
     */
    @Test
    public void testExecuteOperation() {
        System.out.println("\nTesting executeOperation() method for inputs --> Item Price: " + itemPrice + " Money Inserted: " + moneyInserted);
        assertEquals(new Calculation().executeOperation(itemPrice, moneyInserted), expResult);
    }
    
}
