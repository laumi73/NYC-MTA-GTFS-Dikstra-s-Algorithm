import java.util.ArrayList;

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

    @Override
    public int compareTo(Station s) {
        return this.getName().compareTo(s.getName());
    }

    public boolean equals(Station s) {
        return this.getName().equals(s.getName());
    }
}
