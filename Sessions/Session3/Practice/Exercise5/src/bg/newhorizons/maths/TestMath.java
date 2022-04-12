package bg.newhorizons.maths;

import java.util.Random;

/**
 * Call all new crated function of Math class and take rand print esults
 */
public class TestMath {

    public static void main(String[] args) {

        Random r = new Random();
        for (int i = 0; i < 10; i++){

            double a = 20 * r.nextDouble();
            double b = 20 * r.nextDouble();

            System.out.println(Math.sum(a, b));
            System.out.println(Math.subtract(a, b));
            System.out.println(Math.divide(a, b));
            System.out.println(Math.nth(a, b));
        }
    }

}
