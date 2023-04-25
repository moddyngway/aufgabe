package com.company;

import java.util.ArrayList;

public class Line {
    private String name;
    private final ArrayList<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void addStation(Station station){
        if (!stations.contains(station)){
            stations.add(station);
            station.addLine(this);
        }
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
