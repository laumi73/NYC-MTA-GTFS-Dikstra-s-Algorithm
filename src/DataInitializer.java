import java.io.IOException;

public class DataInitializer {
    public static void main (String[] args) throws IOException {
        //String prefix = System.getProperty("user.dir");
        String prefix = "C:\\Users\\laumi\\IdeaProjects\\NYC MTA GTFS Dikstra\\src";
        StopsReader.writeSubstationList(prefix + "\\stops.txt");
        RouteListWriter.write(prefix);
    }
}
