import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Dikstra {
    public static String findFastestRoute(ArrayList<SubStation> vertexSet,
                                                          String source,
                                                          String target)
    {
        //ArrayList<SubStation> visited = new ArrayList<SubStation>();
        ArrayList<Double> dist = new ArrayList<Double>(vertexSet.size());
        ArrayList<SubStation> prev = new ArrayList<SubStation>(vertexSet.size());
        ArrayList<SubStation> nodeList = new ArrayList<SubStation>(vertexSet.size());

        for (int i = 0; i < vertexSet.size(); i++) {
            dist.add(Double.POSITIVE_INFINITY);
            prev.add(null);
            nodeList.add(vertexSet.get(i));
        }

        int currentNodeIndex = vertexSet.indexOf(new SubStation(source)); //Might use this later
        dist.set(currentNodeIndex , 0.0);
        SubStation currentNode;

        while (!(nodeList.isEmpty())) {
            currentNodeIndex = dist.indexOf(Collections.min(dist));
            currentNode = vertexSet.get(currentNodeIndex);
            nodeList.remove(currentNode);
            //visited.add(currentNode);
            ArrayList<String> routeList = currentNode.getRouteList();

            //Go through the list of routes
            for (int i = 0; i < routeList.size(); i++) {
                //Separate the String line into {String destination , String (int) cost}
                String[] data = routeList.get(i).split(",");

                //Find which index is the destination SubStation
                int destIndex = vertexSet.indexOf(new SubStation(data[0]));

                //Calculate cost
                //Parsed cost + current station cost
                double cost = Double.parseDouble(data[1]) + dist.get(currentNodeIndex);
                if (cost < dist.get(destIndex)) {
                    dist.set(destIndex, cost);
                    prev.set(destIndex, currentNode);
                }
            }
        }

        return trace(vertexSet, dist, prev, target);
    }

    private static String trace(
            ArrayList<SubStation> vertexSet,
            ArrayList<Double> dist,
            ArrayList<SubStation> prev,
            String target) {
        int index = vertexSet.indexOf(new SubStation(target));
        if (prev.get(index) == null) {
            return vertexSet.get(index).getName() + " " + TimeConverter.revert((int) (double) dist.get(index));
        }
        else {
            String route = "";
            while(prev.get(index) != null) {
                route = route +
                        vertexSet.get(index).getName() +
                        " " +
                        TimeConverter.revert((int) (double) dist.get(index)) +
                        "\n"
                ;
                index = vertexSet.indexOf(prev.get(index));
            }
            return route;
        }
    }
}
