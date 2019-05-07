import java.io.IOException;

public class DataInitializer {
    public static void main (String[] args) throws IOException {
        String prefix = "C:\\Users\\laumi\\IdeaProjects\\NYC MTA GTFS Dikstra";
        StopsReader.writeSubstationList(prefix + "\\stops.txt");
        RouteListWriter.write(prefix);
    }
}
