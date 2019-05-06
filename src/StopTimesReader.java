import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StopTimesReader {
    /*{Uses BufferedReader to read and pick out
        1) arrival_time
        2) departure_time
        3) stop_id (name of stop)
        of each routes in the file "stop_time.txt"

        This program uses TimeConverter to convert hh:mm:ss string time format into int as seconds

        This program also checks for duplicate routes and ignore them
    */


    //Methods
    public static ArrayList<String> read(String path) throws IOException {
        Scanner s = new Scanner(new FileReader(new File(path)));
        ArrayList<String> routeList = new ArrayList<String>();
        String[] line1;
        String[] line2;

        s.nextLine(); //Skip the first line

        if (s.hasNextLine()) { //If there's at least 1 entry
            line1 = s.nextLine().split(","); //Set line1 as the first line of data
            while (s. hasNextLine()) {
                line2 = s.nextLine().split(",");
                if (line1[0].equals(line2[0])) {//If the route ID is the same, I.E. stops in line1 and line 2 are on the same route
                    addRoute(routeList, formatRoute(line1, line2));
                }
                line1 = line2;
            }
        }

        return routeList;
    }

    //Helper Methods
    private static String formatRoute(String[] line1, String[] line2) {
        int time = TimeConverter.subtract(line2[1] , line1[2]);
        return (line1[4] + "," + line2[4] + "," + time);
    }

    private static void addRoute(ArrayList<String> routeList, String route) {
        if (!routeList.contains(route)) { //Check for duplicates
            routeList.add(route);
        }
    }
}
