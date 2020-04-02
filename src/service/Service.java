package service;

import domain.*;
import repository.*;

public class Service {
    private Repository<Activity> activityRepo;
    private Repository<Discipline> disciplineRepo;
    private Repository<Room> roomRepo;
    private Repository<Specialisation> specialisationRepo;
    private Repository<Teacher> teacherRepo;
    private Repository<Subject> subjectRepo;

    public Service(Repository<Activity> activityRepo, Repository<Discipline> disciplineRepo, Repository<Room> roomRepo,
                   Repository<Specialisation> specialisationRepo, Repository<Teacher> teacherRepo,
                   Repository<Subject> subjectRepo) {
        this.activityRepo = activityRepo;
        this.disciplineRepo = disciplineRepo;
        this.roomRepo = roomRepo;
        this.specialisationRepo = specialisationRepo;
        this.teacherRepo = teacherRepo;
        this.subjectRepo = subjectRepo;
    }

    public Repository<Activity> getActivityRepo() {
        return activityRepo;
    }

    public void setActivityRepo(Repository<Activity> activityRepo) {
        this.activityRepo = activityRepo;
    }

    public Repository<Discipline> getDisciplineRepo() {
        return disciplineRepo;
    }

    public void setDisciplineRepo(Repository<Discipline> disciplineRepo) {
        this.disciplineRepo = disciplineRepo;
    }

    public Repository<Room> getRoomRepo() {
        return roomRepo;
    }

    public void setRoomRepo(Repository<Room> roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Repository<Specialisation> getSpecialisationRepo() {
        return specialisationRepo;
    }

    public void setSpecialisationRepo(Repository<Specialisation> specialisationRepo) {
        this.specialisationRepo = specialisationRepo;
    }

    public Repository<Teacher> getTeacherRepo() {
        return teacherRepo;
    }

    public void setTeacherRepo(Repository<Teacher> teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Repository<Subject> getSubjectRepo() {
        return subjectRepo;
    }

    public void setSubjectRepo(Repository<Subject> subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    /*
    public void addSpecialisation(Specialisation s)
    {
        this.specialisationRepo.getSpecialisations().add(s);
    }
    */

    public boolean addTeacher (Teacher t)
    {
        return this.teacherRepo.add(t);
    }

    public boolean updateTeacher(int id, Teacher newT)
    {
        return this.teacherRepo.update(id,newT);

    }

    public boolean deleteTeacher(int id )
    {
        return this.teacherRepo.remove(id);
    }

    public boolean addDiscipline(Discipline d)
    {
        return this.disciplineRepo.add(d);
    }

    public boolean deleteDiscipline(int id)
    {
        return this.disciplineRepo.remove(id);
    }

    public boolean updateDiscipline(int id,Discipline newD)
    {
        return this.disciplineRepo.update(id,newD);
    }

    public boolean addActivity(Activity a)
    {
        if(isActivityValid(a)) return this.activityRepo.add(a);
        return false;
    }

    public boolean deleteActivity(int id)
    {
        return this.activityRepo.remove(id);
    }

    public boolean updateActivity(int id,Activity newA)
    {
        if(isActivityValid(newA))
            return this.activityRepo.update(id, newA);
        return false;
    }


    public boolean isActivityValid(Activity a) {
       /*
        boolean ok1=false;
        boolean ok2=false;
        for(int i = 0; i<this.teacherRepo.getEntities().size();i++ ) {
            if (this.teacherRepo.getEntities().get(i).getName().equals(a.getTeacher().getName())) {
                ok1=true;
            }
        }
        for(int i=0; i< this.disciplineRepo.getEntities().size();i++)
        {
            if(this.disciplineRepo.getEntities().get(i).getName().equals(a.getDiscipline().getName()))
            {
                ok2=true;
            }
        }
        if(ok1==true && ok2==true) return true;
        return false;
 */

        return true;
    }

    public boolean addRoom(Room r)
    {
        return this.roomRepo.add(r);
    }

    public boolean deleteRoom(int id)
    {
        return this.roomRepo.remove(id);
    }

    public boolean updateRoom(int id,Room r)
    {
        return this.roomRepo.update(id, r);

    }

    public boolean addSubject(Subject s){return this.subjectRepo.add(s);}
    public boolean deleteSubject(int id){return this.subjectRepo.remove(id);}
    public boolean updateSubject(int id,Subject s){return this.subjectRepo.update(id,s);}

    public int[] activitiesPossibleForSubgroup(String name)
    {
        int arr[] ={0};
        for(int i=0;i<this.specialisationRepo.getEntities().size();i++)
            for(int j=0;j<this.specialisationRepo.getEntities().get(i).getGroups().size();j++)
                for(int k=0;k<this.specialisationRepo.getEntities().get(i).getGroups().get(j).getSubgroups().size();k++)
                {
                    if(this.specialisationRepo.getEntities().get(i).getGroups().get(j).getSubgroups().get(k).getName().equals(name))
                        return this.specialisationRepo.getEntities().get(i).getActivities();
                }
        return arr;
    }

//    boolean findSubjectAssociation(Subject s)
//    {
//
//    }
//
}


