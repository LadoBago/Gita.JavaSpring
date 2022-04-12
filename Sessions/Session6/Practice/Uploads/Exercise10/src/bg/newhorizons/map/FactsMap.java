package bg.newhorizons.map;

import java.util.ArrayList;
import java.util.List;

/**
 *  here the minus of this program is that we need always to keep up to date the index
 *  in facts array is the facts about the point at index of interestedPoints
 *
 *
 *  Let's change it so that
 *  1. Create a new class called PointOfInterest
 *  2. That class has 2 elements - String fact, and Point point - crate setters/getters and constructors
 *  3. Change the parameters of class FactsMap so that to have only a List of PointOfInterest
 *  4. Change the Route class so that to have a List of Point  - because a route does not have only start and end point
 */
public class FactsMap {

    private final List<PointOfInterest> interestedPoints;

    public FactsMap(List<PointOfInterest> points) {
        this.interestedPoints = points;

        //this.interestedPoints.add(null);
    }

    public String getFactsAboutPoint(double x, double y) {
        for (int index = 0; index < interestedPoints.size(); index++) {
            PointOfInterest poi = interestedPoints.get(index);
            if (poi != null) {
                if (poi.getPoint() != null &&
                        poi.getPoint().getX() == x && poi.getPoint().getY() == y) {
                    return poi.getFacts();
                }
            }
        }

        return null;
    }

    public List<String> getFactsAboutRoute(Route route) {
        if (route == null) {
            throw new IllegalArgumentException("Route should be passed!");
        }

        List<String> facts = new ArrayList<>();
        String factForStartPoint = getFactsAboutPoint(route.getStart().getX(), route.getStart().getY());
        String factsForEndPoint = getFactsAboutPoint(route.getEnd().getX(), route.getEnd().getY());

        if (factForStartPoint != null && !factForStartPoint.isEmpty()) {
            facts.add(factForStartPoint);
        }
        if (factsForEndPoint != null && !factsForEndPoint.isEmpty()) {
            facts.add(factsForEndPoint);
        }

        return facts;
    }

}
