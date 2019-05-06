import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RouteListWriter{
    public static String[] createList(String prefix) throws IOException {
        ArrayList<String> routes;
        routes = StopTimesReader.read(prefix + "\\stop_times.txt");
        routes.addAll(TransfersReader.read(prefix + "\\transfers.txt", StopsReader.read(prefix + "\\stops.txt")));
        return routes.toArray(new String[routes.size()]);
    }

    public static void write(String prefix) throws IOException{
        FileWriter f = new FileWriter("routeList.txt");
        String[] routeList = createList(prefix);
        Arrays.sort(routeList);
        for (int i = 0; i < routeList.length; i++) {
            f.write(routeList[i] + "\n");
        }
        f.close();
    }
}
