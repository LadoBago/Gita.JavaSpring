package bg.newhorizons.map;

public class PointOfInterest {

    private Point point;
    private String facts;

    public PointOfInterest(String facts, Point point) {
        this.facts = facts;
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }
}
