import java.util.ArrayList;

public class SubStation extends Station {
    //Fields
    //private ParentStation parentStation;

    private ArrayList<String> routeList;

    private SubStation prev;

    private int dist;

    //Constructors
    public SubStation() {
        routeList = new ArrayList<String>();
        prev = null;
        dist = -1;
    }

    public SubStation(SubStation prev, int dist) {
        routeList = new ArrayList<String>();
        this.prev = prev;
        this.dist = dist;
    }

    //Methods
        //Getters
    /*
    public Station getParentStation() {
        return parentStation;
    }
    */
    public SubStation getPrev() {
        return prev;
    }

    public int getDist() {
        return dist;
    }
        //Setters
    public void setPrev(SubStation prev) {
        this.prev = prev;
    }

    public void setDist(int d) {
        this.dist = d;
    }

    public ArrayList<String> getRouteList() {
        return routeList;
    }

    public void addRoute(String route) {
        routeList.add(route);
    }
}
