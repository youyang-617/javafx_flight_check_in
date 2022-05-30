import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test_InputCheck {

    @Test
    public void testLengthOrderNumber() {
        Assertions.assertFalse(InputCheck.checkOrderNumber(""));
        Assertions.assertFalse(InputCheck.checkOrderNumber("1"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("615"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("6543"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("54256"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("546461564681984"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("6654518"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("5452121"));
        Assertions.assertTrue(InputCheck.checkOrderNumber("981358"));
        Assertions.assertTrue(InputCheck.checkOrderNumber("000001"));
    }

    @Test
    public void testTypeOrderNumber() {
        Assertions.assertFalse(InputCheck.checkOrderNumber(" "));
        Assertions.assertFalse(InputCheck.checkOrderNumber("iergbu"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("gfrb94"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("98 168"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("@#1651"));
        Assertions.assertFalse(InputCheck.checkOrderNumber("!9mc93"));
        Assertions.assertTrue(InputCheck.checkOrderNumber("618981"));
        Assertions.assertTrue(InputCheck.checkOrderNumber("000054"));
        Assertions.assertTrue(InputCheck.checkOrderNumber("598135"));

    }

    @Test
    public void testName() {
        Assertions.assertFalse(InputCheck.checkCustomerName("liu"));
        Assertions.assertFalse(InputCheck.checkCustomerName("Liu Yuqi"));
        Assertions.assertFalse(InputCheck.checkCustomerName("RivB"));
        Assertions.assertFalse(InputCheck.checkCustomerName("LIU"));
        Assertions.assertFalse(InputCheck.checkCustomerName("lIu"));
        Assertions.assertFalse(InputCheck.checkCustomerName("L8u"));
        Assertions.assertFalse(InputCheck.checkCustomerName(" Loi"));
        Assertions.assertTrue(InputCheck.checkCustomerName("Jin"));
        Assertions.assertTrue(InputCheck.checkCustomerName("Law"));

    }

    @Test
    public void testLengthIdNumber() {
        Assertions.assertFalse(InputCheck.checkIDNumber(""));
        Assertions.assertFalse(InputCheck.checkIDNumber("1"));
        Assertions.assertFalse(InputCheck.checkIDNumber("615"));
        Assertions.assertFalse(InputCheck.checkIDNumber("6543"));
        Assertions.assertFalse(InputCheck.checkIDNumber("54256"));
        Assertions.assertFalse(InputCheck.checkIDNumber("546461564681984"));
        Assertions.assertFalse(InputCheck.checkIDNumber("4593158468"));
        Assertions.assertFalse(InputCheck.checkIDNumber("6841848646846841468468461"));
        Assertions.assertTrue(InputCheck.checkIDNumber("1001002022004"));
        Assertions.assertTrue(InputCheck.checkIDNumber("1001009022004"));
    }


    @Test
    public void testTypeIdNumber() {
        Assertions.assertFalse(InputCheck.checkIDNumber("             "));
        Assertions.assertFalse(InputCheck.checkIDNumber("100+002022004"));
        Assertions.assertFalse(InputCheck.checkIDNumber("10010evwd2004"));
        Assertions.assertFalse(InputCheck.checkIDNumber("1001    22004"));
        Assertions.assertFalse(InputCheck.checkIDNumber("54@@#!4ve6266"));
        Assertions.assertFalse(InputCheck.checkIDNumber("546*564681984"));
        Assertions.assertFalse(InputCheck.checkIDNumber("10010$%scs004"));
        Assertions.assertTrue(InputCheck.checkIDNumber("1001002022004"));
        Assertions.assertTrue(InputCheck.checkIDNumber("1009349022004"));
    }




}
