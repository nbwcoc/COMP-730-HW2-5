package HW2;

import java.math.BigDecimal;

public interface CarStrategy {
    public String getExtendedDescription();
    public BigDecimal getPriceAdjustment();
    public double getReviewAdjustment();
}
