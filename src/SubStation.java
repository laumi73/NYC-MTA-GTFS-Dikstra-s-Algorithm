import java.util.ArrayList;

public class SubStation extends Station {
    //Fields
    //private ParentStation parentStation;

    private ArrayList<String> routeList;

    //Constructors
    public SubStation() {
        super();
        routeList = new ArrayList<String>();
    }

    public SubStation(String name) {
        super(name);
        routeList = new ArrayList<String>();
}

    //Methods
        //Getters
    /*
    public Station getParentStation() {
        return parentStation;
    }
    */

    public ArrayList<String> getRouteList() {
        return routeList;
    }

    public void addRoute(String route) {
        routeList.add(route);
    }
}
