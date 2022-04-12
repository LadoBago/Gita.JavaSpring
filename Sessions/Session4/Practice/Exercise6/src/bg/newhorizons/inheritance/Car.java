package bg.newhorizons.inheritance;

public class Car extends Vehicle {
    private String model;
    private int productionYear;

    // As brand is with protected access modifier,
    // then it can be accessed from the instances of Car class
    public void info() {
        System.out.println("This car model is " + model
                + " brand " + this.brand
                + "  and year of production " + this.productionYear);
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.move(2, 3, 5, 5);
        car.info();
    }
}
