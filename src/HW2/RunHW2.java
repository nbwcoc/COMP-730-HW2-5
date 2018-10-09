import java.math.BigDecimal;

public class RunHW2 {
    public static void main(String[] args) {
        Car cars[] = {
            new Car(2014, "Subaru", "Forester", "solid", new BigDecimal("30000.00"), new BigDecimal("45000.00"), 8.9),
            new Car(2001, "Chevrolet", "Cavalier", "cheap", new BigDecimal("13000.00"), new BigDecimal("20000.00"), 7.4),
            new Car(1980, "Ford", "Mustang", "fast", new BigDecimal("100000.00"), new BigDecimal("250000.00"), 8.5)
        };

        for (var car : cars)
            System.out.println(car.getDescription());

        cars[1].assignStrategy(new BeaterStrategy());

        for (var car : cars)
            System.out.println(car.getDescription());
    }
}
