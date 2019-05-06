import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    //Helper methods
    //** If the else bit doesn't work because of ArrayList.indexOf(), just brute force the main code


    private static void addStop(ArrayList<ParentStation> parentStationList, String[] stop) {
        if (stop.length == 9) { //Check if it's a parent station (length of 9; substation has length of 10)
            parentStationList.add(new ParentStation(stop[0]));
        }
        else { //has length of 10
            parentStationList.get(parentStationList.indexOf(new ParentStation(stop[9]))).addSubStation(stop[0]);
        }
    }
}
