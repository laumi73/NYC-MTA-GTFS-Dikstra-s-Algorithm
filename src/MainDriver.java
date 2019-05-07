import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainDriver {
    private static final String prefix = "C:\\Users\\laumi\\IdeaProjects\\NYC MTA GTFS Dikstra";

    private static ArrayList<SubStation> createVertexSet() throws IOException{
        ArrayList<SubStation> vertexSet = initializeVertexSet();
        Scanner s = new Scanner(new FileReader(new File(prefix + "\\routeList.txt")));
        String[] next;
        SubStation tempStation;
        while (s.hasNextLine()) {
            next = s.nextLine().split(",");
            tempStation = vertexSet.get(Collections.binarySearch(vertexSet, new SubStation(next[0])));
            tempStation.addRoute(next[1] + "," + next[2]);
        }
        return vertexSet;
    }

    //Helper Methods
    private static ArrayList<SubStation> initializeVertexSet() throws IOException {
        ArrayList<SubStation> vertexSet = new ArrayList<SubStation>();
        Scanner s = new Scanner(new FileReader(new File(prefix + "\\stopList.txt")));
        while (s.hasNextLine()) {
            vertexSet.add(new SubStation(s.nextLine()));
        }
        return vertexSet;
    }


}
