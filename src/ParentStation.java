import java.util.ArrayList;

public class ParentStation extends Station{
    //Fields
    //List of substations
    private ArrayList<String> subStations;

    //Number of substations
    public int size = 0;

    //Constructors
    public ParentStation() {
        super();
    }

    public ParentStation(String name) {
        super(name);
    }


    //Methods
        //Getters
    public ArrayList<String> getSubStations() {
        return subStations;
    }

    public void addSubStation(String subStation) {
        subStations.add(subStation);
        size++;
    }
}
