package domain;

import java.io.Serializable;

public class Teacher extends Entity implements Serializable {
    private String name;
    private String rank;

    public Teacher(int id, String name, String rank) {
        super(id);
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", id=" + id +
                '}';
    }

}

