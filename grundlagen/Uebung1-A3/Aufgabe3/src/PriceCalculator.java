public class PriceCalculator {

    double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double extra_discount;
        double result;

        if (extras >= 5)
            extra_discount = 15;
        else if (extras >= 3)
            extra_discount = 10;
        else
            extra_discount = 0;


        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-extra_discount);

        return Math.ceil(result * 100.0) / 100.0;
    }
}
