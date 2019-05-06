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
        subStations = new ArrayList<String>();
    }

    public ParentStation(String name) {
        super(name);
        subStations = new ArrayList<String>();
    }


    //Methods
        //Getters
    public ArrayList<String> getSubStations() {
        return subStations;
    }

    public void addSubStation(String subStation) {
        //System.out.println(subStation); //Debug use
        subStations.add(subStation);
        size++;
    }
}
