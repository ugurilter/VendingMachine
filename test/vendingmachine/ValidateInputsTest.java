package vendingmachine;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class ValidateInputsTest {
    
    private int itemPrice;
    private int moneyInserted;
    private int expResult;

    public ValidateInputsTest(int itemPrice, int moneyInserted, int expResult) {
        this.itemPrice = itemPrice;
        this.moneyInserted = moneyInserted;
        this.expResult = expResult;
    }    
    
    @Parameters
    public static Collection data() {
        return Arrays.asList( new Object[ ][ ] { { 33, 2, 2 }, { 10, 1, 0 }, { 250, 2, 1 }, { 45, 5, 4 }, { 40, 0, 3 }, 
                                                 { 45, 1, 5 }, { 30, 2, 5 }, { 100, 2, 5 }, { 55, 1, 5 }, { 70, 2, 5 } });
    }
    
    /**
     * Test of executeOperation method, of class Calculation.
     */
    @Test
    public void testValidateInputs() {
        assertEquals(expResult, new Calculation().validateInputs(itemPrice, moneyInserted));
    }
    
}
