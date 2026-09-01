public class Testtreiber {

    boolean test_calculate_price(){

        double price = 1234.56;
        PriceCalculator calculator = new PriceCalculator();

        if(calculator.calculatePrice(price,0, 0, 0, 20)!=987.65) return false;
        if(calculator.calculatePrice(price,78, 0, 0, 20)!=1065.65) return false;
        if(calculator.calculatePrice(price,78, 90, 1, 20)!=1155.65) return false;
        if(calculator.calculatePrice(price,78, 90, 4, 20)!=1146.65) return false;
        if(calculator.calculatePrice(price,78, 90, 5, 20)!=1142.15) return false;
        return true;
    }
}
