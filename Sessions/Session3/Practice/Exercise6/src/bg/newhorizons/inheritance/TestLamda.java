package bg.newhorizons.inheritance;

import java.util.function.Predicate;

public class TestLamda {


    public static void main(String[] args) {
        // 1. Create a Predicate<Car> via  lambda expression telling if a car is from brand 'Mercedes' or not
        // 2. Create 3 instances of Car class one with brand "Tesla", "NIO" and "Mercedes"
        // 3. Using the predicate identify if car is Mercedes or not

        Predicate<Car> isMercedes = car -> car.brand.equals("Mercedes") ;
        Car v1 = new Car("Tesla", "xtype", 2021);
        Car v2 = new Car("NIO", "model1", 2021);
        Car v3 = new Car("Mercedes", "GLE 350", 2021);

        if (isMercedes.test(v1)){
            System.out.println("v1 is Mercedes");
        }
        if (isMercedes.test(v2)){
            System.out.println("v2 is Mercedes");
        }
        if (isMercedes.test(v3)){
            System.out.println("v3 is Mercedes");
        }
    }
}
