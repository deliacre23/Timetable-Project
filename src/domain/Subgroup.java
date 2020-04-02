package domain;

public class Subgroup {
    private String name;
    //private ArrayList<Subject> schedule = new ArrayList<>();

    public Subgroup(String name) {
        this.name = name;
    }

//    public Subgroup(String name, ArrayList<Subject> schedule) {
//        this.name = name;
//        this.schedule = schedule;
//    }
//
//    public boolean addSubject(Subject t)
//    {
//        for(int i=0;i<schedule.size();i++)
//        {
//            if(schedule.get(i).getTimeslot().equals(t.getTimeslot()) ||
//                schedule.get(i).getActivityId()==t.getActivityId())
//                return false;
//        }
//        schedule.add(t);
//        return true;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<Subject> getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(ArrayList<Subject> schedule) {
//        this.schedule = schedule;
//    }

    @Override
    public String toString() {
        return name;
    }
}
