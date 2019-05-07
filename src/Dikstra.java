import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Dikstra {
    public static LinkedList<SubStation> findFastestRoute(ArrayList<SubStation> vertexSet,
                                                          String source,
                                                          String target)
    {
        ArrayList<SubStationNode> visited = new ArrayList<SubStationNode>();

        ArrayList<SubStationNode> nodeList = new ArrayList<SubStationNode>(vertexSet.size());
        for (int i = 0; i < vertexSet.size(); i++) {
            nodeList.set(i, new SubStationNode(Double.POSITIVE_INFINITY, null, vertexSet.get(i)));
        }

        int currentNodeIndex = vertexSet.indexOf(new SubStation(source)); //Might use this later
        SubStationNode currentNode = nodeList.get(currentNodeIndex);
        currentNode.setDist(0);

        while (!(nodeList.isEmpty())) {
            currentNode = Collections.min(nodeList);
            visited.add(currentNode);
        }

        LinkedList<SubStation> route = new LinkedList<SubStation>();
        return route;
    }
}
