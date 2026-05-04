package sit707_week6;

public class DiscountCalculator {

    public double calculateFinalPrice(double originalPrice, double discountPercent) {

        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative.");
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
        }

        return originalPrice - (originalPrice * discountPercent / 100);
    }
}