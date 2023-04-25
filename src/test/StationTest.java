package test;

import static org.junit.jupiter.api.Assertions.*;

import com.company.Line;
import com.company.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class StationTest {

    private Line line1;
    private Line line2;
    private Station station1;
    private Station station2;
    private Station station3;

    @BeforeEach
    void setUp() {
        line1 = new Line("Red Line");
        line2 = new Line("Green Line");
        station1 = new Station(line1, "Station 1");
        station2 = new Station(line1, "Station 2");
        station3 = new Station(line2, "Station 3");
    }

    @Test
    void testAddLine() {
        station1.addLine(line2);
        assertEquals(2, station1.getLines().size());
        assertTrue(station1.getLines().contains(line1));
        assertTrue(station1.getLines().contains(line2));
    }

    @Test
    void testGetAllLines() {
        HashSet<Line> allLines = station1.getLinesAsSet();
        assertEquals(1, allLines.size());
        assertTrue(allLines.contains(line1));
        assertFalse(allLines.contains(line2));

        station1.addLine(line2);
        allLines = station1.getLinesAsSet();
        assertEquals(2, allLines.size());
        assertTrue(allLines.contains(line1));
        assertTrue(allLines.contains(line2));
    }

    @Test
    void testAddNeighbor() {
        station1.addNeighbor(station2);
        assertEquals(1, station1.getNeighbors().size());
        assertTrue(station1.getNeighbors().contains(station2));
        assertEquals(1, station2.getNeighbors().size());
        assertTrue(station2.getNeighbors().contains(station1));
    }

    @Test
    void testGetLine() {
        assertEquals(line1, station1.getLine());
        assertEquals(line1, station2.getLine());
        assertEquals(line2, station3.getLine());
    }

    @Test
    void testSetName() {
        station1.setName("New Station");
        assertEquals("New Station", station1.getName());
    }
}

