package test;

import com.company.Line;
import com.company.LinesController;
import com.company.PathFinder;
import com.company.Station;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class PathFinderTest {
    @Test
    public void testSimpleCase() {
        Line redLine = new Line("Red");
        Station alewife = new Station(redLine, "Alewife");
        Station davis = new Station(redLine, "Davis");
        Station porter = new Station(redLine, "Porter");
        Station harvard = new Station(redLine, "Harvard");
        Station central = new Station(redLine, "Central");
        Station kendall = new Station(redLine, "Kendall");
        Station mit = new Station(redLine, "MIT");

        alewife.addNeighbor(davis);
        davis.addNeighbor(porter);
        porter.addNeighbor(harvard);
        harvard.addNeighbor(central);
        central.addNeighbor(kendall);
        kendall.addNeighbor(harvard);
        kendall.addNeighbor(mit);

        ArrayList<Station> expectedPath = new ArrayList<>(Arrays.asList(alewife, davis, porter, harvard, kendall, mit));

        PathFinder pathFinder = new PathFinder();
        ArrayList<Station> actualPath = pathFinder.findShortestPath(alewife, mit);

        Assertions.assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testCaseWithManyLines(){
        LinesController controller = new LinesController();
        controller.loadStationLinesFromFiles("TestLines", StandardCharsets.UTF_8);

        PathFinder pathFinder = new PathFinder();

        Station station1 = controller.findStationByNameInAllLines("Station 1");
        Station station6 = controller.findStationByNameInAllLines("Station 6");
        Station station5 = controller.findStationByNameInAllLines("Station 5");

        ArrayList<Station> path = pathFinder.findShortestPath(station1, station5);
        ArrayList<Station> expectedPath = new ArrayList<>(Arrays.asList(station1, station6, station5));

        Assertions.assertEquals(path, expectedPath);
    }

    @Test
    public void testCaseWhenStartIsEnd(){
        Line line = new Line("Line");
        Station station = new Station(line, "Station");

        PathFinder pathFinder = new PathFinder();
        ArrayList<Station> path = pathFinder.findShortestPath(station, station);

        Assertions.assertEquals(path.size(), 1);
        Assertions.assertEquals(path.get(0), station);
    }

    @Test
    public void testCaseWhenThereIsNoPath(){
        Line line = new Line("Line");
        Station station = new Station(line, "Station");
        Station station1 = new Station(line, "Station");

        PathFinder pathFinder = new PathFinder();
        ArrayList<Station> path = pathFinder.findShortestPath(station, station1);

        Assertions.assertNull(path);
    }
}
