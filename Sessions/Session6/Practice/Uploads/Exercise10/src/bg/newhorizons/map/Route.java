package bg.newhorizons.map;

import java.util.List;

public class Route {

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public Route(List<Point> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("A rout should consists at least 2 points.");
        }

        this.points = points;
    }

    public Point getStart() {
        return points.get(0);
    }

    public Point getEnd() {
        return points.get(points.size() - 1);
    }
}
