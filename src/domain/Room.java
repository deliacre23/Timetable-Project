package domain;

import java.io.Serializable;
import java.util.Arrays;

public class Room extends Entity implements Serializable {
    private String name;
    private String building;
    private int[] activitiesId;

    public Room(int id, String name, String building, int[] activities) {
        super(id);
        this.name = name;
        this.building = building;
        this.activitiesId = activities;
    }

    public Room(int id, String name, String building) {
        super(id);
        this.name = name;
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int[] getActivities() {
        return activitiesId;
    }

    public void setActivities(int[] activities) {
        this.activitiesId = activities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", building='" + building + '\'' +
                ", activitiesId=" + Arrays.toString(activitiesId) +
                ", id=" + id +
                '}';
    }
}
