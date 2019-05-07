import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Dikstra {
    public static String findFastestRoute(ArrayList<SubStation> vertexSet,
                                                          String source,
                                                          String target)
    {
        ArrayList<SubStation> visitedStations = new ArrayList<SubStation>(vertexSet.size());
        ArrayList<SubStationNode> visitedNodes = new ArrayList<SubStationNode>(vertexSet.size());
        ArrayList<SubStation> refSet = new ArrayList<SubStation>(vertexSet.size());
        ArrayList<SubStationNode> nodeList = new ArrayList<SubStationNode>(vertexSet.size());

        for (int i = 0; i < vertexSet.size(); i++) {
            refSet.add(vertexSet.get(i));
            nodeList.add(new SubStationNode(Double.POSITIVE_INFINITY, null, vertexSet.get(i)));
        }

        int currentNodeIndex = refSet.indexOf(new SubStation(source)); //Might use this later
        nodeList.get(currentNodeIndex).setDist(0);
        SubStationNode currentNode;
        //Loop until the nodeList is empty (all nodes visited)
        while (!nodeList.isEmpty()) {
            //Set the "cursor" as the node with the least dist
            currentNode = Collections.min(nodeList);
            //Go through the list of routes
            ArrayList<String> routeList = currentNode.getSubStation().getRouteList();
            for (int i = 0; i < routeList.size(); i++) {
                //Separate the String line into {String destination , String (int) cost}
                String[] data = routeList.get(i).split(",");

                //Check if it has been visited yet
                if (!visitedStations.contains(new SubStation((data[0])))) {
                    //Find which index is the destination SubStation
                    int destIndex = refSet.indexOf(new SubStation(data[0]));
                    //Calculate cost
                    //Parsed cost + current station cost
                    double cost = Double.parseDouble(data[1]) + currentNode.getDist();
                    if (cost < nodeList.get(destIndex).getDist()) {
                        nodeList.get(destIndex).setDist(cost);
                        nodeList.get(destIndex).setPrev(currentNode);
                    }
                }
            }
            visitedNodes.add(currentNode);
            visitedStations.add(currentNode.getSubStation());
            currentNodeIndex = nodeList.indexOf(currentNode);
            nodeList.remove(currentNodeIndex);
            refSet.remove(currentNodeIndex);
        }
        return trace(visitedNodes, visitedStations, visitedStations.indexOf(new SubStation(target)));
    }

    public static String findShortestRoute(ArrayList<SubStation> vertexSet,
                                          String source,
                                          String target)
    {
        ArrayList<SubStation> visitedStations = new ArrayList<SubStation>(vertexSet.size());
        ArrayList<SubStationNode> visitedNodes = new ArrayList<SubStationNode>(vertexSet.size());
        ArrayList<SubStation> refSet = new ArrayList<SubStation>(vertexSet.size());
        ArrayList<SubStationNode> nodeList = new ArrayList<SubStationNode>(vertexSet.size());

        for (int i = 0; i < vertexSet.size(); i++) {
            refSet.add(vertexSet.get(i));
            nodeList.add(new SubStationNode(Double.POSITIVE_INFINITY, null, vertexSet.get(i)));
        }

        int currentNodeIndex = refSet.indexOf(new SubStation(source)); //Might use this later
        nodeList.get(currentNodeIndex).setDist(0);
        SubStationNode currentNode;
        //Loop until the nodeList is empty (all nodes visited)
        while (!nodeList.isEmpty()) {
            //Set the "cursor" as the node with the least dist
            currentNode = Collections.min(nodeList);
            //Go through the list of routes
            ArrayList<String> routeList = currentNode.getSubStation().getRouteList();
            for (int i = 0; i < routeList.size(); i++) {
                //Separate the String line into {String destination , String (int) cost}
                String[] data = routeList.get(i).split(",");

                //Check if it has been visited yet
                if (!visitedStations.contains(new SubStation((data[0])))) {
                    //Find which index is the destination SubStation
                    int destIndex = refSet.indexOf(new SubStation(data[0]));
                    //Calculate cost
                    //Parsed cost + current station cost
                    double cost = 1 + currentNode.getDist();
                    if (cost < nodeList.get(destIndex).getDist()) {
                        nodeList.get(destIndex).setDist(cost);
                        nodeList.get(destIndex).setPrev(currentNode);
                    }
                }
            }
            visitedNodes.add(currentNode);
            visitedStations.add(currentNode.getSubStation());
            currentNodeIndex = nodeList.indexOf(currentNode);
            nodeList.remove(currentNodeIndex);
            refSet.remove(currentNodeIndex);
        }
        return traceLeastStop(visitedNodes, visitedStations, visitedStations.indexOf(new SubStation(target)));
    }

    private static String trace(ArrayList<SubStationNode> nodeList, ArrayList<SubStation> subStations, int targetIndex) {
        //int index = vertexSet.indexOf(new SubStation(target));
        if (nodeList.get(targetIndex).getPrev() == null) {
            return nodeList.get(targetIndex).getSubStation().getName() +
                    "," + TimeConverter.revert((int) (double) nodeList.get(targetIndex).getDist());
        }
        else {
            String route = "";
            while(nodeList.get(targetIndex).getPrev() != null) {
                route = route +
                        nodeList.get(targetIndex).getSubStation().getName() +
                        "," +
                        TimeConverter.revert((int) (double) nodeList.get(targetIndex).getDist()) +
                        "\n"
                ;
                targetIndex = subStations.indexOf(nodeList.get(targetIndex).getPrev().getSubStation());
            }
            return route;
        }
    }

    private static String traceLeastStop(ArrayList<SubStationNode> nodeList, ArrayList<SubStation> subStations, int targetIndex) {
        //int index = vertexSet.indexOf(new SubStation(target));
        if (nodeList.get(targetIndex).getPrev() == null) {
            return nodeList.get(targetIndex).getSubStation().getName() +
                    "," + (int) (double) nodeList.get(targetIndex).getDist();
        }
        else {
            String route = "";
            while(nodeList.get(targetIndex).getPrev() != null) {
                route = route +
                        nodeList.get(targetIndex).getSubStation().getName() +
                        "," +
                        (int) (double) nodeList.get(targetIndex).getDist() +
                        "\n"
                ;
                targetIndex = subStations.indexOf(nodeList.get(targetIndex).getPrev().getSubStation());
            }
            return route;
        }
    }
}
