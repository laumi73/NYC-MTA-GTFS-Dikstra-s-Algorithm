import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StopsReader
{
    //Methods
    //**IMPORTANT*
    //This method only works on NYC MTA GTFS data. this is because other GTFS data starts to add in their own fields to data
    //which makes the length of each line of CSV data unpredictable
    public static ArrayList<ParentStation> read(String path) throws IOException {
        ArrayList<ParentStation> parentStationList= new ArrayList<ParentStation>();
        Scanner s = new Scanner(new FileReader(new File(path)));
        s.nextLine(); //Skips the first line
        while (s.hasNextLine()) {
            addStop(parentStationList, s.nextLine().split(","));
        }
        return parentStationList;
    }

    public static void writeSubstationList(String path) throws IOException {
        FileWriter f = new FileWriter("stopList.txt");
        Scanner s = new Scanner(new FileReader(new File(path)));
        String[] next;
        ArrayList<String> subStationList = new ArrayList<String>();
        s.nextLine();
        while (s.hasNextLine()) {
            next = s.nextLine().split(",");
            if (next.length > 9) {
                subStationList.add(next[0]);
            }
        }
        String[] stopList = subStationList.toArray(new String[subStationList.size()]);
        Arrays.sort(stopList); //in case the list of stop isn't sorted

        for (int i = 0; i < stopList.length; i++) {
            f.write(stopList[i] + "\n");
        }
        f.close();
    }

    //Helper methods
    //** If the else bit doesn't work because of ArrayList.indexOf(), just brute force the main code

    private static void addStop(ArrayList<ParentStation> parentStationList, String[] stop) {
        if (stop.length == 9) { //Check if it's a parent station (length of 9; substation has length of 10)
            parentStationList.add(new ParentStation(stop[0]));
            //System.out.println(parentStationList.get(parentStationList.indexOf(new ParentStation(stop[0]))).getName()); //Debug use
        }
        else { //has length of 10 (subStations)
            parentStationList.get(parentStationList.indexOf(new ParentStation(stop[9]))).addSubStation(stop[0]);
        }
    }
}
