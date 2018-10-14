package HW2;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BeaterStrategyTest {

    BeaterStrategy testObject = new BeaterStrategy();
    
    @Test
    void testGetExtendedDescription() {
        assertEquals(testObject.getExtendedDescription(),
            "It's \"survived\" many winters, and has been on far too many "
            + "cross-country trips. Won't last another couple years without "
            + "extensive work.");
    }

    @Test
    void testGetPriceAdjustment() {
        assertEquals(testObject.getPriceAdjustment(), new BigDecimal("-20000.00"));
    }

    @Test
    void testGetReviewAdjustment() {
        assertEquals(testObject.getReviewAdjustment(), -5.0);
    }

}
