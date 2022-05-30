import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTest {
    private Customer customerUnderTest1;
    private Customer customerUnderTest2;

    @BeforeEach
    void setUp(){
        customerUnderTest1 = new Customer("Yang", "1001002022002");
        customerUnderTest2 = new Customer("100004");
    }

    @Test
    void testSearch() {
        String[] cosinfo1 = new String[14];
        String[] cosinfo2 = new String[14];
        cosinfo1[0] = "Huisi";
        cosinfo1[1] = "Yang";
        cosinfo1[2] = "1001002022002";
        cosinfo1[3] = "BU1334";
        cosinfo1[4] = "f";
        cosinfo1[5] = "100002";
        cosinfo1[6] = "1A";
        cosinfo1[7] = "e";
        cosinfo1[8] = "1";
        cosinfo1[9] = "1";
        cosinfo1[10] = "Beijing";
        cosinfo1[11] = "Tianjin";
        cosinfo1[12] = "Feb.1st";
        cosinfo1[13] = "A22";
        cosinfo2[0] = "Yuqi";
        cosinfo2[1] = "Liu";
        cosinfo2[2] = "1001002022004";
        cosinfo2[3] = "PT2098";
        cosinfo2[4] = "m";
        cosinfo2[5] = "100004";
        cosinfo2[6] = "2C";
        cosinfo2[7] = "e";
        cosinfo2[8] = "1";
        cosinfo2[9] = "0";
        cosinfo2[10] = "Shenzhen";
        cosinfo2[11] = "Sichuan";
        cosinfo2[12] = "Apr.1st";
        cosinfo2[13] = "A24";
        assertArrayEquals(cosinfo1, customerUnderTest1.search());
        assertArrayEquals(cosinfo2, customerUnderTest2.search());
    }

    @Test
    void testModifyMeal() {
        customerUnderTest1.ModifyMeal("e",customerUnderTest1.search());
        assertEquals("e",customerUnderTest1.getTypeOfMeal());
        //test modify
        assertEquals(50, customerUnderTest1.getExtrafeeMeal());
        //test extra fee
    }


    @Test
    void testModifySeat() {
        customerUnderTest1.ModifySeatNum("1A",customerUnderTest1.search());
        assertEquals("1A", customerUnderTest1.getSeatNum());
        assertEquals(323, customerUnderTest1.getExtrafeeSeat());
    }


}
