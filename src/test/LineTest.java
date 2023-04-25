package test;

import static org.junit.jupiter.api.Assertions.*;

import com.company.Line;
import com.company.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {

    private Line line;
    private Station station1;
    private Station station2;

    @BeforeEach
    void setUp() {
        line = new Line("Red Line");
        station1 = new Station(line,"Station 1");
        station2 = new Station(line,"Station 2");
    }

    @Test
    void testLineInitialization() {
        assertEquals("Red Line", line.getName());
    }

    @Test
    void testAddStation() {
        assertEquals(2, line.getStations().size());
        assertTrue(line.getStations().contains(station1));
        assertTrue(line.getStations().contains(station2));
        assertTrue(station1.getLines().contains(line));
        assertTrue(station2.getLines().contains(line));
    }

    @Test
    void testSetName() {
        line.setName("Blue Line");
        assertEquals("Blue Line", line.getName());
    }
}