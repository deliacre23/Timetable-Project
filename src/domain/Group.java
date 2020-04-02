package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private ArrayList <Subgroup> subgroups = new ArrayList<>();
    private String name;

    public Group( String name, ArrayList<Subgroup> subgroups) {
        this.name = name;
        this.subgroups = subgroups;

    }

    public ArrayList<Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(ArrayList<Subgroup> subgroups) {
        this.subgroups = subgroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
