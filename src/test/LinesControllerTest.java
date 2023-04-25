package test;

import com.company.Line;
import com.company.LinesController;
import com.company.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class LinesControllerTest {

    private static final String FOLDER_PATH = "TestLines";

    private LinesController controller;

    @BeforeEach
    public void setUp() {
        controller = new LinesController();
        controller.loadStationLinesFromFiles(FOLDER_PATH, StandardCharsets.UTF_8);
    }

    @Test
    public void testFindStationByNameInAllLines() {
        Assertions.assertNotEquals(null, controller.findStationByNameInAllLines("Station 1"));
        Assertions.assertNotEquals(null, controller.findStationByNameInAllLines("Station 2"));
        Assertions.assertNull(controller.findStationByNameInAllLines("Non-existent Station"));
    }

    @Test
    public void testLoadStationLinesFromFiles() {
        Assertions.assertEquals(3, controller.getLines().size());

        Assertions.assertEquals(3, controller.getLines().get(0).getStations().size());
        Assertions.assertEquals(3, controller.getLines().get(1).getStations().size());
        Assertions.assertEquals(3, controller.getLines().get(2).getStations().size());
    }
}