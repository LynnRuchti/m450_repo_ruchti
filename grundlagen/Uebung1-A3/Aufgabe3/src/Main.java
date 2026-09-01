public class Main {
    public static void main(String[] args) {
        Testtreiber testtreiber = new Testtreiber();
        if(testtreiber.test_calculate_price()){
            System.out.println("Test ok!");
        }else{
            System.out.println("Test not ok!");
        }
    }



}
