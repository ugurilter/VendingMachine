package vendingmachine;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class CalculateChangeTest {
    
    private int itemPrice;
    private int moneyInserted;
    private String expResult;

    public CalculateChangeTest(int itemPrice, int moneyInserted, String expResult) {
        this.itemPrice = itemPrice;
        this.moneyInserted = moneyInserted;
        this.expResult = expResult;
    }    
    
    @Parameters
    public static Collection data() {
        return Arrays.asList( new Object[ ][ ] { { 45, 1, "1*50 Kuruş\n1*5 Kuruş." }, 
                                                 { 35, 2, "3*50 Kuruş\n1*10 Kuruş\n1*5 Kuruş." },
                                                 { 50, 1, "1*50 Kuruş\n"},
                                                 { 75, 2, "2*50 Kuruş\n1*25 Kuruş\n"},
                                                 { 55, 2, "2*50 Kuruş\n1*25 Kuruş\n2*10 Kuruş\n"}});
    }
    
    /**
     * Test of executeOperation method, of class Calculation.
     */
    @Test
    public void testCalculateChange() {
        assertEquals(new Calculation().calculateChange(itemPrice, moneyInserted), expResult);
    }
    
}
