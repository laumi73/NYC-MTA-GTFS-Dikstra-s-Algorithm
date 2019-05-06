import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransfersReader {
    public static ArrayList<String> read(String path, ArrayList<ParentStation> parentStationList) throws IOException {
        ArrayList<String> routeList = new ArrayList<String>();
        ParentStation origin;
        ParentStation target;
        Scanner s = new Scanner(new FileReader(new File(path)));
        s.nextLine();//Skip the first line
        while (s.hasNextLine()) {
            String[] next = s.nextLine().split((","));
            origin = parentStationList.get(parentStationList.indexOf(new ParentStation(next[0])));
            target = parentStationList.get(parentStationList.indexOf(new ParentStation(next[1])));
            for (int i = 0; i < origin.size(); i++) {
                for (int j = 0; j < target.size(); j++) {
                    if (!(origin.getSubStations().get(i).equals(target.getSubStations().get(j)))) {
                        routeList.add(origin.getSubStations().get(i) + "," + target.getSubStations().get(j) + "," + next[3]);
                    }
                }
            }
        }
        return routeList;
    }
}
