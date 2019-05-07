import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainDriver {
    private static final String prefix = "C:\\Users\\laumi\\IdeaProjects\\NYC MTA GTFS Dikstra";
    //Helper Methods
    //Create an ArrayList of SubStations with routes attached
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

    //Initialize an  ArrayList of SubStation without routes attached
    private static ArrayList<SubStation> initializeVertexSet() throws IOException {
        ArrayList<SubStation> vertexSet = new ArrayList<SubStation>();
        Scanner s = new Scanner(new FileReader(new File(prefix + "\\stopList.txt")));
        while (s.hasNextLine()) {
            vertexSet.add(new SubStation(s.nextLine()));
        }
        return vertexSet;
    }

    public static void main(String[] Args) throws IOException, ArrayIndexOutOfBoundsException {
        Scanner r = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter starting substation: ");
        String Station1 = r.next();
        System.out.println("Enter destination substation: ");
        String Station2 = r.next();
        if (Station1.equals(Station2))
            System.out.println("Error: starting station and destination cannot be the same.");
        else {
            System.out.println("Enter evaluation criteria:\n0 - fastest in terms of time\n1 - least stops\n");
            int leastRoute = r.nextInt();
            String route = "";
            try {
                if (leastRoute == 1)
                    route = Dikstra.findShortestRoute(createVertexSet(), Station1, Station2);
                else if (leastRoute == 0)
                    route = Dikstra.findFastestRoute(createVertexSet(), Station1, Station2);
                r.close();
                System.out.println(route);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: invalid station name");
            }
        }
    }
}
