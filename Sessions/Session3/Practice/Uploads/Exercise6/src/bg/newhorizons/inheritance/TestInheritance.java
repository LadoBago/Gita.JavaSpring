package bg.newhorizons.inheritance;

/**
 * Create a new class Human wich
 * firstName and lastName from type String
 * uniqueNumber from type String
 * Add getters and setters
 * Add full arg constructor
 *
 * Create a new class Bicycle which extends Vehicle
 * Add new class private members numberOfWeels and numberOfSpeedTransmisions
 * Add new private member from type Human with name owner
 *
 * Create a new interface with name Movement having next method
 * public void move(double startX, double startY,
 *                  double endX, double endY)
 *
 * Make it so that Vehicle implements Movement interface
 * In the test class TestInheritance :
 * Create new instance of Bicycle and Car
 * Assign Bicycle and car to an variable of Movement and call the move() function 
 */
public class TestInheritance {

    public static void main(String[] args) {

        Movement bicycle = new Bicycle();
        Movement car = new Car();
        bicycle.move(2, 3, 4, 5);
        car.move(9, 8, 7, 6);




    }

}
