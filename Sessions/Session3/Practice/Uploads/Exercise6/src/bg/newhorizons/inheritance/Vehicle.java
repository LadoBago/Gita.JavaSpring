package bg.newhorizons.inheritance;

public class Vehicle implements Movement {
    protected String brand;

    public void move(double startX, double startY,
                     double endX, double endY) {

        System.out.println("The vehicle is moving from point " +
                "(" + startX + ", " + startY + ")" +
                " to point (" + endX + ", " + endY + ")");
    }
}
