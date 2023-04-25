package com.company;

import java.util.*;

public class PathFinder {

    private final HashMap<Station, ArrayList<Station>> discoveredPaths = new HashMap<>();
    private final Queue<Station> queue = new ArrayDeque<>();

    public ArrayList<Station> findShortestPath(Station start, Station target){
        discoveredPaths.put(start, new ArrayList<>(Collections.singletonList(start)));
        return BFS(start, target);
    }

    public ArrayList<Station> BFS(Station currentStation, Station targetStation) {
        if (!discoveredPaths.containsKey(currentStation)){
            Station closestToStartNeighbor = null;
            for (Station neighbor:
                    currentStation.getNeighbors()) {
                if (discoveredPaths.containsKey(neighbor) && (closestToStartNeighbor == null ||
                        discoveredPaths.get(neighbor).size() < discoveredPaths.get(closestToStartNeighbor).size()))
                    closestToStartNeighbor = neighbor;
            }
            ArrayList<Station> currentPath = new ArrayList<>(discoveredPaths.get(closestToStartNeighbor));
            currentPath.add(currentStation);

            discoveredPaths.put(currentStation, currentPath);
        }

        if (currentStation == targetStation){
            return discoveredPaths.get(currentStation);
        }

        queue.addAll(currentStation.getNeighbors());

        while (!queue.isEmpty()){
            Station stationToCheck = queue.poll();
            if (!discoveredPaths.containsKey(stationToCheck))
                return BFS(stationToCheck, targetStation);
        }

        return null;
    }

    public static void printPath(ArrayList<Station> path){

        if (path == null){
            System.out.println("Path not found");
            return;
        }

        Line currentLine = path.get(0).getLine();
        for (int i = 0; i < path.size(); i++) {
            Station pStation = path.get(i);

            Station nextStation = i+1 < path.size() ? path.get(i+1) : null;

            System.out.print(pStation.getName() + " (");
            if (nextStation != null && pStation.getNeighbors().size() > 2) {

                HashSet<Line> intersect = nextStation.getLinesAsSet();
                intersect.retainAll(pStation.getLinesAsSet());

                if (!currentLine.getName().equals(((Line)intersect.toArray()[0]).getName())){
                    System.out.print("Change to ");
                }
                currentLine = (Line)intersect.toArray()[0];
            }
            System.out.println(currentLine.getName() + ")");
        }
    }
}
