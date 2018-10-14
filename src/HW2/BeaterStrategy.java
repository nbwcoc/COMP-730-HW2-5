package HW2;

import java.math.BigDecimal;

public class BeaterStrategy implements CarStrategy {
    public String getExtendedDescription() {
        return "It's \"survived\" many winters, and has been on far too many "
            + "cross-country trips. Won't last another couple years without "
            + "extensive work.";
    }

    public BigDecimal getPriceAdjustment() {
        return new BigDecimal("-20000.00");
    }

    public double getReviewAdjustment() {
        return -5.0;
    }
}
