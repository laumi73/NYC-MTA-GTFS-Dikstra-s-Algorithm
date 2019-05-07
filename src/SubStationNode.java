public class SubStationNode implements Comparable<SubStationNode>{
    //Fields
    private Double dist;

    private SubStationNode prev;

    private SubStation subStation;

    //Constructors
    public SubStationNode(double dist, SubStationNode prev, SubStation subStation) {
        this.dist = dist;
        this.prev = prev;
        this.subStation = subStation;
    }

    //Methods
    public Double getDist() {
        return this.dist;
    }

    public SubStationNode getPrev() {
        return this.prev;
    }

    public SubStation getSubStation() {
        return this.subStation;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public void setPrev(SubStationNode prev) {
        this.prev = prev;
    }

    @Override
    public int compareTo(SubStationNode s) {
        return this.getDist().compareTo(s.getDist());
    }
}
