import java.math.BigDecimal;

public class Car {
    private String make;
    private String model;
    private int year;
    private String description;
    private BigDecimal priceHigh;
    private BigDecimal priceLow;
    private double review;
    private CarStrategy strategy;

    public Car(int year, String make, String model, String description, BigDecimal priceLow, BigDecimal priceHigh, double review) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.description = description;
        this.priceHigh = priceHigh;
        this.priceLow = priceLow;
        this.review = review;
    }

    public void assignStrategy(CarStrategy strategy) {
        this.strategy = strategy;
    }

    String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }

    int getYear() {
        return year;
    }

    String getDescription() {
        return description + ((strategy != null) ? "\n" + strategy.getExtendedDescription() : "");
    }

    BigDecimal getPriceHigh() {
        return priceHigh.add((strategy != null) ? strategy.getPriceAdjustment() : BigDecimal.ZERO);
    }

    BigDecimal getPriceLow() {
        return priceLow.add((strategy != null) ? strategy.getPriceAdjustment() : BigDecimal.ZERO);
    }

    double getReview() {
        return review + ((strategy != null) ? strategy.getReviewAdjustment() : 0.0);
    }
}
