package domain;


import java.io.Serializable;
import java.util.ArrayList;

public class Specialisation extends Entity implements Serializable {
    private String name;
    private ArrayList <Group> groups = new ArrayList<>();
    private int[] activitiesId;


    public Specialisation(int id, String name, ArrayList<Group> groups, int[] activities) {
        super(id);
        this.groups = groups;
        this.name = name;
        this.activitiesId = activities;
    }

    public Specialisation(int id, String name, ArrayList<Group> groups) {
        super(id);
        this.groups = groups;
        this.name = name;
    }

    public int[] getActivities() {
        return activitiesId;
    }

    public void setActivities(int[] activities) {
        this.activitiesId = activities;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
