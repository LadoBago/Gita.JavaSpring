package bg.newhorizons.map;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestGuideMap {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(2, 2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        ArrayList<String> facts = new ArrayList<>();
        facts.add("A very historical place built at 1984");
        facts.add("A unique river long 56475 km");
        facts.add("The capital of the world");
        facts.add("The home of paradise");

        List<PointOfInterest> pointOfInterests = IntStream
                .range(0, points.size())
                .mapToObj(
                    i -> new PointOfInterest(facts.size() > i ? facts.get(i) : null, points.size() > i ? points.get(i) : null)
                )
                .collect(Collectors.toList());

        FactsMap factsMap = new FactsMap(pointOfInterests);
        System.out.println(factsMap.getFactsAboutPoint(0, 0));
        System.out.println(factsMap.getFactsAboutPoint(4, 6));


        List<String> names = new ArrayList<>();
        names.add("Pesho");
        names.add("Nick");

        names.forEach( s -> System.out.println(s));
        ListIterator<String> listIterator = names.listIterator(names.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }


    }

}
