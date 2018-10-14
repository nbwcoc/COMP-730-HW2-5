package HW2;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

class CarTest {

    Car testObject = new Car(2018, "Test", "Object", "This is a test object", new BigDecimal("100.00"), new BigDecimal("1000.00"), 5.0); 
    boolean strategyAssigned = false;
    
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    
    @Test
    void testAssignStrategy() {
        var mockStrategy = mock(CarStrategy.class);
        
        when(mockStrategy.getExtendedDescription()).thenReturn("test test test");
        when(mockStrategy.getPriceAdjustment()).thenReturn(new BigDecimal("50.00"));
        when(mockStrategy.getReviewAdjustment()).thenReturn(1.0);
        testObject.assignStrategy(mockStrategy);
        strategyAssigned = true;
        
        assertEquals(testObject.getDescription(), "This is a test object\ntest test test");
        assertEquals(testObject.getPriceHigh(), new BigDecimal("1050.00"));
        assertEquals(testObject.getPriceLow(), new BigDecimal("150.00"));
        assertEquals(testObject.getReview(), 6.0);
    }

    @Test
    void testGetMake() {
        assertEquals(testObject.getMake(), "Test");
    }

    @Test
    void testGetModel() {
        assertEquals(testObject.getModel(), "Object");
    }

    @Test
    void testGetYear() {
        assertEquals(testObject.getYear(), 2018);
    }

    @Test
    void testGetDescription() {
        String expect = "This is a test object";
        if (strategyAssigned)
            expect += "\ntest test test";
        
        assertEquals(testObject.getDescription(), expect);
    }

    @Test
    void testGetPriceHigh() {
        var expect = new BigDecimal("1000.00");
        if (strategyAssigned)
            expect = expect.add(new BigDecimal("50.00"));
        
        assertEquals(testObject.getPriceHigh(), expect);
    }

    @Test
    void testGetPriceLow() {
        var expect = new BigDecimal("100.00");
        if (strategyAssigned)
            expect = expect.add(new BigDecimal("50"));
        
        assertEquals(testObject.getPriceLow(), expect);
    }

    @Test
    void testGetReview() {
        double expect = 5.0;
        if (strategyAssigned)
            expect += 1.0;
        
        assertEquals(testObject.getReview(), expect);
    }

}
