package domain;

public class Subject extends Entity {
    private Timeslot timeslot;
    private Subgroup subgroup;
    private int activityId;
    private int roomId;

    public Subject(int id, Timeslot timeslot, Subgroup subgroup, int activityId, int roomId) {
        super(id);
        this.timeslot = timeslot;
        this.subgroup = subgroup;
        this.activityId = activityId;
        this.roomId = roomId;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                 timeslot +
                ", subgroup=" + subgroup +
                ", activityId=" + activityId +
                ", roomId=" + roomId +
                ", id=" + id +
                '}';
    }


}
