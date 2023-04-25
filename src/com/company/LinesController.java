package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class LinesController {

    private final ArrayList<Line> lines = new ArrayList<>();

    public Station findStationByNameInAllLines(String string_line) {
        for (Line line:
                lines) {
            for (Station station:
                    line.getStations()) {
                if (station.getName().equals(string_line)){
                    return station;
                }
            }
        }
        return null;
    }


    public void loadStationLinesFromFiles(String folderName, Charset charset){
        File folder = new File(folderName);
        File[] files = folder.listFiles();

        assert files != null;

        for (File file : files) {
            try {
                FileReader fileReader = new FileReader(file, charset);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String string_line;

                Line line = new Line(file.getName().replace(".txt", ""));
                lines.add(line);
                Station prevStation = null;

                while ((string_line = bufferedReader.readLine()) != null){
                    Station station = findStationByNameInAllLines(string_line);
                    if (station == null) {
                        station = new Station(line, string_line);
                    } else {
                        line.addStation(station);
                    }

                    station.addNeighbor(prevStation);
                    prevStation = station;
                }

                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showAllStations(){
        for (Line line:
                lines) {
            System.out.println(line.getName() + ":");
            for (Station station:
                    line.getStations()) {
                System.out.print(station.getName());

                if (station.getNeighbors().size() > 2){
                    System.out.print(" : ");
                    for (Station n:
                            station.getNeighbors()) {
                        if (!n.getLines().contains(line))
                            System.out.print(n.getName() + " | ");
                    }
                }

                System.out.println();
            }
            System.out.println();
        }
    }

    public ArrayList<Line> getLines(){
        return lines;
    }

}
