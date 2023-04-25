package com.company;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinesController linesController = new LinesController();
        linesController.loadStationLinesFromFiles("Lines", StandardCharsets.UTF_16LE);

        linesController.showAllStations();

        Station start;
        Station target;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Start: ");
        start = linesController.findStationByNameInAllLines(scanner.nextLine());
        System.out.println("Ziel: ");
        target = linesController.findStationByNameInAllLines(scanner.nextLine());

        scanner.close();

        PathFinder pathFinder = new PathFinder();
        ArrayList<Station> path = pathFinder.findShortestPath(start, target);
        PathFinder.printPath(path);
    }
}
