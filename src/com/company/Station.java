package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Station {
    private String name;

    private final ArrayList<Station> neighbors;
    private final ArrayList<Line> lines;

    public Station(Line line, String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.lines = new ArrayList<>();
        line.addStation(this);
    }

    public void addLine(Line line){
        if (!lines.contains(line)) {
            lines.add(line);
            line.addStation(this);
        }
    }

    public HashSet<Line> getLinesAsSet(){
        return new HashSet<>(lines);
    }


    public void addNeighbor(Station station){
        if (station == null)
            return;
        if (!neighbors.contains(station))
            neighbors.add(station);
        if (!station.getNeighbors().contains(this))
            station.addNeighbor(this);
    }

    public ArrayList<Station> getNeighbors() {
        return neighbors;
    }

    public Line getLine() {
        return (Line) getLinesAsSet().toArray()[0];
    }

    public ArrayList<Line> getLines(){
        return lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
