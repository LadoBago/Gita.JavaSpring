package bg.newhorizons.inheritance;

public class Vehicle {
    protected String brand;

    public void move(double startX, double startY,
                     double endX, double endY) {

        System.out.println("The vehicle is moving from point " +
                "(" + startX + ", " + startY + ")" +
                " to point (" + endX + ", " + endY + ")");
    }
}
