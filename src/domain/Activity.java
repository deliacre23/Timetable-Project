package domain;

import java.io.Serializable;

public class Activity extends Entity implements Serializable {
    private String type;
    private int disciplineId;
    private int teacherId;

    public Activity(int id, String type, int disciplineId, int teacherId) {
        super(id);
        this.type = type;
        this.disciplineId = disciplineId;
        this.teacherId = teacherId;
    }

    public Activity(int id, String type, int disciplineId) {
        super(id);
        this.type = type;
        this.disciplineId = disciplineId;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "type='" + type + '\'' +
                ", disciplineId=" + disciplineId +
                ", teacherId=" + teacherId +
                ", id=" + id +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
