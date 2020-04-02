package ui;

import domain.*;
import service.Service;

public class UI {

    private Service ctrl;

    public UI(Service ctrl) {
        this.ctrl = ctrl;
    }

    public Service getCtrl() {
        return ctrl;
    }

    public void setCtrl(Service ctrl) {
        this.ctrl = ctrl;
    }

    public static void menu()
    {
        System.out.println("Menu");
        System.out.println("1. Add teacher");
        System.out.println("2. See all teachers");
        System.out.println("3. Update teacher");
        System.out.println("4. Delete teacher");
        System.out.println("5. Add discipline");
        System.out.println("6. See all disciplines");
        System.out.println("7. Update discipline");
        System.out.println("8. Delete discipline");
        System.out.println("9. Add activity");
        System.out.println("10. See all activities");
        System.out.println("11. Update activity");
        System.out.println("12. Delete activity");
        System.out.println("13. Add room");
        System.out.println("14. See all rooms");
        System.out.println("15. Update rooms");
        System.out.println("16. Delete rooms");
        System.out.println("17. Teachers that have a given rank, sorted alphabetically");
        System.out.println("18. All activities that take place in a given room, sorted by time slot");
        System.out.println("19. The timetable for a given formation");
    }


    public boolean addTeacher(int id,String t,String rank)
    {
        Teacher teacher = new Teacher(id,t,rank);
        return this.ctrl.addTeacher(teacher);

    }

    public boolean updateTeacher(int id, int newId,String newName,String newRank)
    {
        Teacher newT = new Teacher(newId,newName,newRank);
        return this.ctrl.updateTeacher(id,newT);
    }

    public boolean deleteTeacher(int id)
    {
        return this.ctrl.deleteTeacher(id);

    }

    public boolean addDiscipline(int id,String d)
    {
        Discipline dis = new Discipline(id,d);
        return this.ctrl.addDiscipline(dis);
    }

    public boolean updateDiscipline(int id, int newId,String newName)
    {
        Discipline newD = new Discipline(newId,newName);
        return this.ctrl.updateDiscipline(id,newD);
    }

    public boolean deleteDiscipline(int id)
    {
        return this.ctrl.deleteDiscipline(id);
    }

    public boolean addActivity(int id,String type, int disciplineId, int teacherId)
    {
        Activity a = new Activity(id,type,disciplineId,teacherId);
        System.out.println(a.toString());
        return this.ctrl.addActivity(a);
    }

    public boolean deleteActivity(int id)
    {
        return this.ctrl.deleteActivity(id);
    }

    public boolean updateActivity(int id, int nid ,String nt, int nd, int ntc)
    {
        Activity newA = new Activity(nid,nt,nd,ntc);

        return this.ctrl.updateActivity(id,newA);

    }

    public boolean addRoom(int id, String name,String building,int[] activities)
    {
        Room r = new Room(id,name,building,activities);
        return this.ctrl.addRoom(r);
    }

    public boolean deleteRoom(int id)
    {
        return this.ctrl.deleteRoom(id);
    }

    public boolean updateRoom(int oid,int id, String name,String building,int[] activities)
    {
        Room r = new Room(id,name,building,activities);
        return this.ctrl.updateRoom(oid,r);
    }

    public boolean addSubject(int id, String day, int start, int end, String subgroup, int activityId, int roomId)
    {
        Timeslot timeslot = new Timeslot(day, start, end);
        Subgroup s = new Subgroup(subgroup);
        Subject subject = new Subject(id,timeslot,s,activityId,roomId);
        return this.ctrl.addSubject(subject);
    }
    public boolean deleteSubject(int id)
    {
        return this.ctrl.deleteSubject(id);
    }
    public boolean updateSubject(int oldId,int id, String day, int start, int end, String subgroup, int activityId, int roomId)
    {
        Timeslot timeslot = new Timeslot(day, start, end);
        Subgroup s = new Subgroup(subgroup);
        Subject subject = new Subject(id,timeslot,s,activityId,roomId);
        return this.ctrl.updateSubject(oldId,subject);
    }
}