public class Station implements Comparable<Station>{
    //Fields
    private String name;

    //Constructors
    public Station() {
        this.name = null;
    }

    public Station(String name) {
        this.name = name;
    }

    //Methods
        //Getters
    public String getName(){
        return name;
    }

    //Essential for ArrayList.binarySearch(E e) (comparable interface requirement)
    @Override
    public int compareTo(Station s) {
        return this.getName().compareTo(s.getName());
    }

    //Essential for ArrayList.indexOf(Object o)
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    //Essential for ArrayList.indexOf(Object o)
    @Override
    public boolean equals(Object s) {
        if (s == null)
            return false;
        if (!(s instanceof Station))
            return false;
        Station temp = (Station) s;
            return this.getName().equals(temp.getName());
    }
}
