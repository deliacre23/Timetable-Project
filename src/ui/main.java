package ui;

import domain.*;
import service.*;
import repository.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {


        Properties properties;
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/config.properties"));

        } catch (IOException e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        Repository <Teacher> teacherRepository = new Repository<>();
        Teacher t1 = new Teacher(1, "Salagean Grigore", "Professor");
        Teacher t2 = new Teacher(2, "Apatean Anca", "Associate professor");
        Teacher t3 = new Teacher(3, "Pop Emilia", "Assistant professor");
        Teacher t4 = new Teacher(4, "Bocicor Iuliana", "Lecturer");
        Teacher t5 = new Teacher(5, "Lorincz Beata", "Doctorand");
        Teacher t6 = new Teacher(6, "Surdu Sabina", "Lecturer");
        Teacher t7 = new Teacher(7, "Vancea Alexandru", "Lecturer");
        Teacher t8 = new Teacher(8, "Serban Marcel", "Associate professor");
        Teacher t9 = new Teacher(9, "Crivei Septimiu", "Professor");
        Teacher t10 = new Teacher(10, "Chira Camelia", "Associate professor");
        Teacher t11 = new Teacher(11, "Grad Anca", "Lecturer");
        Teacher t12 = new Teacher(12, "Andrica Dorin", "Professor");
        Teacher t13 = new Teacher(13, "Enescu Alina", "Doctorand");
        teacherRepository.add(t1);
        teacherRepository.add(t2);
        teacherRepository.add(t3);
        teacherRepository.add(t4);
        teacherRepository.add(t5);
        teacherRepository.add(t6);
        teacherRepository.add(t7);
        teacherRepository.add(t8);
        teacherRepository.add(t9);
        teacherRepository.add(t10);
        teacherRepository.add(t11);
        teacherRepository.add(t12);
        teacherRepository.add(t13);

        Repository<Discipline> disciplineRepository = new Repository<>();
        Discipline d1 = new Discipline(1, "FP");
        Discipline d2 = new Discipline(2, "OOP");
        Discipline d3 = new Discipline(3, "Algebra");
        Discipline d4 = new Discipline(4, "Real Analysis");
        Discipline d5 = new Discipline(5, "Geometry");
        Discipline d6 = new Discipline(6, "MAP");
        Discipline d7 = new Discipline(7, "Complex Analysis");
        Discipline d8 = new Discipline(8, "Data Bases");
        Discipline d9 = new Discipline(9, "ASC");
        Discipline d10 = new Discipline(10, "Differential equations");
        disciplineRepository.add(d1);
        disciplineRepository.add(d2);
        disciplineRepository.add(d3);
        disciplineRepository.add(d4);
        disciplineRepository.add(d5);
        disciplineRepository.add(d6);
        disciplineRepository.add(d7);
        disciplineRepository.add(d8);
        disciplineRepository.add(d9);
        disciplineRepository.add(d10);

        Repository<Activity> activityRepository = new Repository<>();
        Activity a1 = new Activity(1, "Seminar", 1,1);
        Activity a2 = new Activity(2, "Seminar", 2,2);
        Activity a3 = new Activity(3, "Seminar", 3,3);
        Activity a4 = new Activity(4, "Seminar", 4,4);
        Activity a5 = new Activity(5, "Seminar", 5,5);
        Activity a6 = new Activity(6, "Lab", 6,6);
        Activity a7 = new Activity(7, "Lab", 7,7);
        Activity a8 = new Activity(8, "Lecture", 8,8);
        Activity a9 = new Activity(9, "Lecture", 9,9);
        Activity a10 = new Activity(10, "Lecture", 10,10);
        Activity a11 = new Activity(11, "Lecture", 1,11);
        Activity a12 = new Activity(12, "Lecture", 2,12);
        Activity a13 = new Activity(13, "Seminar", 3,13);
        Activity a14 = new Activity(14, "Seminar", 4,1);
        Activity a15 = new Activity(15, "Seminar", 5,2);
        Activity a16 = new Activity(16, "Seminar", 6,3);
        Activity a17 = new Activity(17, "Seminar", 7,4);
        Activity a18 = new Activity(18, "Lab", 8,5);
        Activity a19 = new Activity(19, "Lab", 9,6);
        Activity a20 = new Activity(20, "Lab", 10,7);
        Activity a21 = new Activity(21, "Lab", 1,8);
        Activity a22 = new Activity(22, "Lecture", 2,9);
        Activity a23 = new Activity(23, "Lecture", 3,10);
        Activity a24 = new Activity(24, "Lecture", 4,11);
        Activity a25 = new Activity(25, "Lecture", 5,12);
        Activity a26 = new Activity(26, "Lecture", 6,13);
        activityRepository.add(a1);
        activityRepository.add(a2);
        activityRepository.add(a4);
        activityRepository.add(a3);
        activityRepository.add(a5);
        activityRepository.add(a6);
        activityRepository.add(a7);
        activityRepository.add(a8);
        activityRepository.add(a9);
        activityRepository.add(a10);
        activityRepository.add(a11);
        activityRepository.add(a12);
        activityRepository.add(a13);
        activityRepository.add(a14);
        activityRepository.add(a15);
        activityRepository.add(a16);
        activityRepository.add(a17);
        activityRepository.add(a18);
        activityRepository.add(a19);
        activityRepository.add(a20);
        activityRepository.add(a21);
        activityRepository.add(a22);
        activityRepository.add(a23);
        activityRepository.add(a24);
        activityRepository.add(a25);
        activityRepository.add(a26);


        Subgroup sg1 = new Subgroup("811/1");
        Subgroup sg2 = new Subgroup("811/2");
        ArrayList<Subgroup> asg1 = new ArrayList<>();
        asg1.add(sg1);
        asg1.add(sg2);
        Group g1 = new Group("811", asg1);

        Subgroup sg3 = new Subgroup("812/1");
        Subgroup sg4 = new Subgroup("812/2");
        Subgroup sg5 = new Subgroup("812/3");
        ArrayList<Subgroup> asg2 = new ArrayList<>();
        asg2.add(sg3);
        asg2.add(sg4);
        asg2.add(sg5);
        Group g2 = new Group("812", asg2);

        ArrayList<Group> ag1 = new ArrayList<>();
        ag1.add(g1);
        ag1.add(g2);

        int[] activ1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Specialisation s1 = new Specialisation(1, "MIE1", ag1, activ1);

        System.out.println(s1.getName());
        for (int i = 0; i < s1.getGroups().size(); i++) {
            System.out.println("Group " + s1.getGroups().get(i).getName());

            for (int j = 0; j < s1.getGroups().get(i).getSubgroups().size(); j++) {
                System.out.println("Subgroup " + s1.getGroups().get(i).getSubgroups().get(j));
            }
        }
        System.out.println("Activities for MIE1 are ");
        for (int i = 0; i < s1.getActivities().length; i++)
            System.out.println(s1.getActivities()[i]);


        Subgroup sg6 = new Subgroup("821/1");
        Subgroup sg7 = new Subgroup("821/2");
        ArrayList<Subgroup> asg3 = new ArrayList<>();
        asg3.add(sg6);
        asg3.add(sg7);
        Group g3 = new Group("821", asg3);

        ArrayList<Subgroup> asg4 = new ArrayList<>();
        Subgroup sg8 = new Subgroup("822/1");
        Group g4 = new Group("822", asg4);

        ArrayList<Group> ag2 = new ArrayList<>();
        ag2.add(g3);
        ag2.add(g4);

        int[] activ2 = new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        Specialisation s2 = new Specialisation(2, "MIE2", ag2, activ2);

        System.out.println(s2.getName());
        for (int i = 0; i < s2.getGroups().size(); i++) {
            System.out.println("Group " + s2.getGroups().get(i).getName());

            for (int j = 0; j < s2.getGroups().get(i).getSubgroups().size(); j++) {
                System.out.println("Subgroup " + s2.getGroups().get(i).getSubgroups().get(j));
            }
        }

        System.out.println("Activities for MIE2 are ");
        for (int i = 0; i < s2.getActivities().length; i++)
            System.out.println(s2.getActivities()[i]);

        Repository<Specialisation> specialisationRepository = new Repository<>();
        specialisationRepository.add(s1);
        specialisationRepository.add(s2);

        int[] activities1 = new int[]{1, 2, 3, 4};
        int[] activities2 = new int[]{5, 6, 7, 8, 9};
        int[] activities3 = new int[]{10, 11, 12, 13, 14};
        int[] activities4 = new int[]{15, 16, 17};
        int[] activities5 = new int[]{18, 19, 20};
        int[] activities6 = new int[]{21};
        int[] activities7 = new int[]{22, 23};
        int[] activities8 = new int[]{24, 25, 26};

        Room r1 = new Room(1, "A303", "Law", activities1);
        Room r2 = new Room(2, "A312", "Law", activities2);
        Room r3 = new Room(3, "A323", "Law", activities1);
        Room r4 = new Room(4, "A305", "Law", activities2);
        Room r5 = new Room(5, "5/I", "Central", activities3);
        Room r6 = new Room(6, "6/II", "Central", activities4);
        Room r7 = new Room(7, "7/I", "Central", activities3);
        Room r8 = new Room(8, "Theta", "Mathematica", activities4);
        Room r9 = new Room(9, "Pi", "Mathematica", activities1);
        Room r10 = new Room(10, "338", "FSEGA", activities5);
        Room r11 = new Room(11, "339", "FSEGA", activities6);
        Room r12 = new Room(12, "429", "FSEGA", activities5);
        Room r13 = new Room(13, "538", "FSEGA", activities7);
        Room r14 = new Room(14, "2/I", "Central", activities8);


        Repository<Room> roomRepository = new Repository<>();
        roomRepository.add(r1);
        roomRepository.add(r2);
        roomRepository.add(r3);
        roomRepository.add(r4);
        roomRepository.add(r5);
        roomRepository.add(r6);
        roomRepository.add(r7);
        roomRepository.add(r8);
        roomRepository.add(r9);
        roomRepository.add(r10);
        roomRepository.add(r11);
        roomRepository.add(r12);
        roomRepository.add(r13);
        roomRepository.add(r14);

        Repository<Subject> subjectRepository = new Repository<>();
        Timeslot ts1=new Timeslot("Monday",8,10);
        Timeslot ts2=new Timeslot("Monday",10,12);
        Timeslot ts3=new Timeslot("Monday",12,14);
        Timeslot ts4=new Timeslot("Monday",14,16);
        Timeslot ts5=new Timeslot("Monday",16,18);
        Timeslot ts6=new Timeslot("Monday",18,20);
        Timeslot ts7=new Timeslot("Tuesday",8,10);
        Timeslot ts8=new Timeslot("Tuesday",10,12);
        Timeslot ts9=new Timeslot("Tuesday",12,14);
        Timeslot ts10=new Timeslot("Tuesday",14,16);
        Timeslot ts11=new Timeslot("Tuesday",16,18);
        Timeslot ts12=new Timeslot("Tuesday",18,20);
        Timeslot ts13=new Timeslot("Wednesday",8,10);
        Timeslot ts14=new Timeslot("Wednesday",10,12);
        Timeslot ts15=new Timeslot("Wednesday",12,14);
        Timeslot ts16=new Timeslot("Wednesday",14,16);
        Timeslot ts17=new Timeslot("Wednesday",16,18);
        Timeslot ts18=new Timeslot("Wednesday",18,20);
        Timeslot ts19=new Timeslot("Thursday",8,10);
        Timeslot ts20=new Timeslot("Thursday",10,12);
        Timeslot ts21=new Timeslot("Thursday",12,14);
        Timeslot ts22=new Timeslot("Thursday",14,16);
        Timeslot ts23=new Timeslot("Thursday",16,18);
        Timeslot ts24=new Timeslot("Thursday",18,20);
        Timeslot ts25=new Timeslot("Friday",8,10);
        Timeslot ts26=new Timeslot("Friday",10,12);
        Timeslot ts27=new Timeslot("Friday",12,14);
        Timeslot ts28=new Timeslot("Friday",14,16);
        Timeslot ts29=new Timeslot("Friday",16,18);
        Timeslot ts30=new Timeslot("Friday",18,20);

        Subject sb1 = new Subject(1,ts1,sg1,1,1);
        Subject sb2 = new Subject(2,ts14,sg4,2,2);
        Subject sb3 = new Subject(3,ts7,sg1,3,3);
        Subject sb4 = new Subject(4,ts9,sg2,4,4);
        Subject sb5 = new Subject(5,ts2,sg2,5,5);
        Subject sb6 = new Subject(6,ts3,sg3,6,6);
        Subject sb7 = new Subject(7,ts20,sg3,7,7);
        Subject sb8 = new Subject(8,ts13,sg4,8,8);
        Subject sb9 = new Subject(9,ts28,sg2,9,9);
        Subject sb10 = new Subject(10,ts23,sg3,10,10);
        Subject sb11 = new Subject(11,ts1,sg1,11,11);
        Subject sb12 = new Subject(12,ts24,sg4,12,12);
        Subject sb13 = new Subject(13,ts7,sg1,13,13);
        Subject sb14 = new Subject(14,ts29,sg2,14,14);
        Subject sb15 = new Subject(15,ts25,sg2,15,1);
        Subject sb16 = new Subject(16,ts3,sg3,16,2);
        Subject sb17 = new Subject(17,ts10,sg3,17,3);
        Subject sb18 = new Subject(18,ts4,sg4,18,4);
        Subject sb19 = new Subject(19,ts28,sg2,19,5);
        Subject sb20 = new Subject(20,ts22,sg3,20,6);

        subjectRepository.add(sb1);
        subjectRepository.add(sb2);
        subjectRepository.add(sb3);
        subjectRepository.add(sb4);
        subjectRepository.add(sb5);
        subjectRepository.add(sb6);
        subjectRepository.add(sb7);
        subjectRepository.add(sb8);
        subjectRepository.add(sb9);
        subjectRepository.add(sb10);
        subjectRepository.add(sb11);
        subjectRepository.add(sb12);
        subjectRepository.add(sb13);
        subjectRepository.add(sb14);
        subjectRepository.add(sb15);
        subjectRepository.add(sb16);
        subjectRepository.add(sb17);
        subjectRepository.add(sb18);
        subjectRepository.add(sb19);
        subjectRepository.add(sb20);


        String repositoryType = properties.getProperty("Repository");

        if(repositoryType.equals( "txt"))
        {
            activityRepository = new TxtRepository<Activity>(properties.getProperty("ActivitiesTxt"));
            disciplineRepository = new TxtRepository<Discipline>(properties.getProperty("DisciplinesTxt"));
            //rr = new TxtRepository<Discipline>(properties.getProperty("RoomsTxt"));
            teacherRepository = new TxtRepository<Discipline>(properties.getProperty("TeachersTxt"));

        }
        else if(repositoryType.equals("bin"))
        {
            activityRepository = new BinRepository<Activity>(properties.getProperty("ActivitiesBin"));
            disciplineRepository = new BinRepository<Discipline>(properties.getProperty("DisciplinesBin"));
            //rr = new BinRepository<Discipline>(properties.getProperty("RoomsBin"));
            teacherRepository = new BinRepository<Discipline>(properties.getProperty("TeachersBin"));

        }
        else if(repositoryType.equals("db"))
        {
            teacherRepository = new DbRepository<Activity>("teacher");

            disciplineRepository = new DbRepository<Discipline>("discipline");
        }

        Service service = new Service(activityRepository,disciplineRepository,roomRepository,specialisationRepository,teacherRepository,subjectRepository);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui1.fxml"));

        System.out.println(loader.getLocation());
        Controller controller = new Controller(service);
        loader.setController(controller);
        Parent root = loader.load();

        primaryStage.setTitle("GUI");
        primaryStage.setScene(new Scene(root, 620, 350));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}






//--------------------------------------------------------------------------------------------------------------------------------
//
//package main;
//import Classes.*;
//import Controller.*;
//import Repositories.*;
//import UI.UI;
//
//import java.io.*;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//public class main {
//
//
//    public static void main(String[] args) {
//
//        Properties properties;
//        properties = new Properties();
//        try {
//            properties.load(new FileInputStream("resources/config.properties"));
//
//        } catch (IOException e) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, e.getMessage(), e);
//        }
//
//        Repository <Teacher> teacherRepository = new Repository<>();
//        Teacher t1 = new Teacher(1, "Salagean Grigore", "Professor");
//        Teacher t2 = new Teacher(2, "Apatean Anca", "Associate professor");
//        Teacher t3 = new Teacher(3, "Pop Emilia", "Assistant professor");
//        Teacher t4 = new Teacher(4, "Bocicor Iuliana", "Lecturer");
//        Teacher t5 = new Teacher(5, "Lorincz Beata", "Doctorand");
//        Teacher t6 = new Teacher(6, "Surdu Sabina", "Lecturer");
//        Teacher t7 = new Teacher(7, "Vancea Alexandru", "Lecturer");
//        Teacher t8 = new Teacher(8, "Serban Marcel", "Associate professor");
//        Teacher t9 = new Teacher(9, "Crivei Septimiu", "Professor");
//        Teacher t10 = new Teacher(10, "Chira Camelia", "Associate professor");
//        Teacher t11 = new Teacher(11, "Grad Anca", "Lecturer");
//        Teacher t12 = new Teacher(12, "Andrica Dorin", "Professor");
//        Teacher t13 = new Teacher(13, "Enescu Alina", "Doctorand");
//        teacherRepository.add(t1);
//        teacherRepository.add(t2);
//        teacherRepository.add(t3);
//        teacherRepository.add(t4);
//        teacherRepository.add(t5);
//        teacherRepository.add(t6);
//        teacherRepository.add(t7);
//        teacherRepository.add(t8);
//        teacherRepository.add(t9);
//        teacherRepository.add(t10);
//        teacherRepository.add(t11);
//        teacherRepository.add(t12);
//        teacherRepository.add(t13);
//
//        Repository<Discipline> disciplineRepository = new Repository<>();
//        Discipline d1 = new Discipline(1, "FP");
//        Discipline d2 = new Discipline(2, "OOP");
//        Discipline d3 = new Discipline(3, "Algebra");
//        Discipline d4 = new Discipline(4, "Real Analysis");
//        Discipline d5 = new Discipline(5, "Geometry");
//        Discipline d6 = new Discipline(6, "MAP");
//        Discipline d7 = new Discipline(7, "Complex Analysis");
//        Discipline d8 = new Discipline(8, "Data Bases");
//        Discipline d9 = new Discipline(9, "ASC");
//        Discipline d10 = new Discipline(10, "Differential equations");
//        disciplineRepository.add(d1);
//        disciplineRepository.add(d2);
//        disciplineRepository.add(d3);
//        disciplineRepository.add(d4);
//        disciplineRepository.add(d5);
//        disciplineRepository.add(d6);
//        disciplineRepository.add(d7);
//        disciplineRepository.add(d8);
//        disciplineRepository.add(d9);
//        disciplineRepository.add(d10);
//
//        Repository<Activity> activityRepository = new Repository<>();
//        Activity a1 = new Activity(1, "Seminar", 1,1);
//        Activity a2 = new Activity(2, "Seminar", 2,2);
//        Activity a3 = new Activity(3, "Seminar", 3,3);
//        Activity a4 = new Activity(4, "Seminar", 4,5);
//        Activity a5 = new Activity(5, "Seminar", 5,2);
//        Activity a6 = new Activity(6, "Lab", 1,4);
//        Activity a7 = new Activity(7, "Lab", 2,4);
//        Activity a8 = new Activity(8, "Lecture", 2,4);
//        Activity a9 = new Activity(9, "Lecture", 3,3);
//        Activity a10 = new Activity(10, "Lecture", 5,1);
//        Activity a11 = new Activity(11, "Lecture", 1,1);
//        Activity a12 = new Activity(12, "Lecture", 4,5);
//        Activity a13 = new Activity(13, "Seminar", 7,1);
//        Activity a14 = new Activity(14, "Seminar", 6,2);
//        Activity a15 = new Activity(15, "Seminar", 8,3);
//        Activity a16 = new Activity(16, "Seminar", 9,4);
//        Activity a17 = new Activity(17, "Seminar", 10,5);
//        Activity a18 = new Activity(18, "Lab", 6,1);
//        Activity a19 = new Activity(19, "Lab", 8,2);
//        Activity a20 = new Activity(20, "Lab", 9,3);
//        Activity a21 = new Activity(21, "Lab", 10,4);
//        Activity a22 = new Activity(22, "Lecture", 7,5);
//        Activity a23 = new Activity(23, "Lecture", 8,2);
//        Activity a24 = new Activity(24, "Lecture", 10,1);
//        Activity a25 = new Activity(25, "Lecture", 6,4);
//        Activity a26 = new Activity(26, "Lecture", 9,5);
//        activityRepository.add(a1);
//        activityRepository.add(a2);
//        activityRepository.add(a4);
//        activityRepository.add(a3);
//        activityRepository.add(a5);
//        activityRepository.add(a6);
//        activityRepository.add(a7);
//        activityRepository.add(a8);
//        activityRepository.add(a9);
//        activityRepository.add(a10);
//        activityRepository.add(a11);
//        activityRepository.add(a12);
//        activityRepository.add(a13);
//        activityRepository.add(a14);
//        activityRepository.add(a15);
//        activityRepository.add(a16);
//        activityRepository.add(a17);
//        activityRepository.add(a18);
//        activityRepository.add(a19);
//        activityRepository.add(a20);
//        activityRepository.add(a21);
//        activityRepository.add(a22);
//        activityRepository.add(a23);
//        activityRepository.add(a24);
//        activityRepository.add(a25);
//        activityRepository.add(a26);
//
//
//        Subgroup sg1 = new Subgroup("811/1");
//        Subgroup sg2 = new Subgroup("811/2");
//        ArrayList<Subgroup> asg1 = new ArrayList<>();
//        asg1.add(sg1);
//        asg1.add(sg2);
//        Group g1 = new Group("811", asg1);
//
//        Subgroup sg3 = new Subgroup("812/1");
//        Subgroup sg4 = new Subgroup("812/2");
//        Subgroup sg5 = new Subgroup("812/3");
//        ArrayList<Subgroup> asg2 = new ArrayList<>();
//        asg2.add(sg3);
//        asg2.add(sg4);
//        asg2.add(sg5);
//        Group g2 = new Group("812", asg2);
//
//        ArrayList<Group> ag1 = new ArrayList<>();
//        ag1.add(g1);
//        ag1.add(g2);
//
//        int[] activ1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//        Specialisation s1 = new Specialisation(1, "MIE1", ag1, activ1);
//
//        System.out.println(s1.getName());
//        for (int i = 0; i < s1.getGroups().size(); i++) {
//            System.out.println("Group " + s1.getGroups().get(i).getName());
//
//            for (int j = 0; j < s1.getGroups().get(i).getSubgroups().size(); j++) {
//                System.out.println("Subgroup " + s1.getGroups().get(i).getSubgroups().get(j));
//            }
//        }
//        System.out.println("Activities for MIE1 are ");
//        for (int i = 0; i < s1.getActivities().length; i++)
//            System.out.println(s1.getActivities()[i]);
//
//
//        Subgroup sg6 = new Subgroup("821/1");
//        Subgroup sg7 = new Subgroup("821/2");
//        ArrayList<Subgroup> asg3 = new ArrayList<>();
//        asg3.add(sg6);
//        asg3.add(sg7);
//        Group g3 = new Group("821", asg3);
//
//        ArrayList<Subgroup> asg4 = new ArrayList<>();
//        Subgroup sg8 = new Subgroup("822/1");
//        Group g4 = new Group("822", asg4);
//
//        ArrayList<Group> ag2 = new ArrayList<>();
//        ag2.add(g3);
//        ag2.add(g4);
//
//        int[] activ2 = new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
//        Specialisation s2 = new Specialisation(2, "MIE2", ag2, activ2);
//
//        System.out.println(s2.getName());
//        for (int i = 0; i < s2.getGroups().size(); i++) {
//            System.out.println("Group " + s2.getGroups().get(i).getName());
//
//            for (int j = 0; j < s2.getGroups().get(i).getSubgroups().size(); j++) {
//                System.out.println("Subgroup " + s2.getGroups().get(i).getSubgroups().get(j));
//            }
//        }
//
//        System.out.println("Activities for MIE2 are ");
//        for (int i = 0; i < s2.getActivities().length; i++)
//            System.out.println(s2.getActivities()[i]);
//
//        Repository<Specialisation> specialisationRepository = new Repository<>();
//        specialisationRepository.add(s1);
//        specialisationRepository.add(s2);
//
//        int[] activities1 = new int[]{1, 2, 3, 4};
//        int[] activities2 = new int[]{5, 6, 7, 8, 9};
//        int[] activities3 = new int[]{10, 11, 12, 13, 14};
//        int[] activities4 = new int[]{15, 16, 17};
//        int[] activities5 = new int[]{18, 19, 20};
//        int[] activities6 = new int[]{21};
//        int[] activities7 = new int[]{22, 23};
//        int[] activities8 = new int[]{24, 25, 26};
//
//        Room r1 = new Room(1, "A303", "Law", activities1);
//        Room r2 = new Room(2, "A312", "Law", activities2);
//        Room r3 = new Room(3, "A323", "Law", activities1);
//        Room r4 = new Room(4, "A305", "Law", activities2);
//        Room r5 = new Room(5, "5/I", "Central", activities3);
//        Room r6 = new Room(6, "6/II", "Central", activities4);
//        Room r7 = new Room(7, "7/I", "Central", activities3);
//        Room r8 = new Room(8, "Theta", "Mathematica", activities4);
//        Room r9 = new Room(9, "Pi", "Mathematica", activities1);
//        Room r10 = new Room(10, "338", "FSEGA", activities5);
//        Room r11 = new Room(11, "339", "FSEGA", activities6);
//        Room r12 = new Room(12, "429", "FSEGA", activities5);
//        Room r13 = new Room(13, "538", "FSEGA", activities7);
//        Room r14 = new Room(14, "2/I", "Central", activities8);
//
//
//        Repository<Room> roomRepository = new Repository<>();
//        roomRepository.add(r1);
//        roomRepository.add(r2);
//        roomRepository.add(r3);
//        roomRepository.add(r4);
//        roomRepository.add(r5);
//        roomRepository.add(r6);
//        roomRepository.add(r7);
//        roomRepository.add(r8);
//        roomRepository.add(r9);
//        roomRepository.add(r10);
//        roomRepository.add(r11);
//        roomRepository.add(r12);
//        roomRepository.add(r13);
//        roomRepository.add(r14);
//
//        Repository<Subject> subjectRepository = new Repository<>();
//        Timeslot ts1=new Timeslot("Monday",8,10);
//        Timeslot ts2=new Timeslot("Monday",10,12);
//        Timeslot ts3=new Timeslot("Monday",12,14);
//        Timeslot ts4=new Timeslot("Monday",14,16);
//        Timeslot ts5=new Timeslot("Monday",16,18);
//        Timeslot ts6=new Timeslot("Monday",18,20);
//        Timeslot ts7=new Timeslot("Tuesday",8,10);
//        Timeslot ts8=new Timeslot("Tuesday",10,12);
//        Timeslot ts9=new Timeslot("Tuesday",12,14);
//        Timeslot ts10=new Timeslot("Tuesday",14,16);
//        Timeslot ts11=new Timeslot("Tuesday",16,18);
//        Timeslot ts12=new Timeslot("Tuesday",18,20);
//        Timeslot ts13=new Timeslot("Wednesday",8,10);
//        Timeslot ts14=new Timeslot("Wednesday",10,12);
//        Timeslot ts15=new Timeslot("Wednesday",12,14);
//        Timeslot ts16=new Timeslot("Wednesday",14,16);
//        Timeslot ts17=new Timeslot("Wednesday",16,18);
//        Timeslot ts18=new Timeslot("Wednesday",18,20);
//        Timeslot ts19=new Timeslot("Thursday",8,10);
//        Timeslot ts20=new Timeslot("Thursday",10,12);
//        Timeslot ts21=new Timeslot("Thursday",12,14);
//        Timeslot ts22=new Timeslot("Thursday",14,16);
//        Timeslot ts23=new Timeslot("Thursday",16,18);
//        Timeslot ts24=new Timeslot("Thursday",18,20);
//        Timeslot ts25=new Timeslot("Friday",8,10);
//        Timeslot ts26=new Timeslot("Friday",10,12);
//        Timeslot ts27=new Timeslot("Friday",12,14);
//        Timeslot ts28=new Timeslot("Friday",14,16);
//        Timeslot ts29=new Timeslot("Friday",16,18);
//        Timeslot ts30=new Timeslot("Friday",18,20);
//
//        Subject sb1 = new Subject(1,ts1,sg1,1,1);
//        Subject sb2 = new Subject(2,ts14,sg4,4,4);
//        Subject sb3 = new Subject(3,ts7,sg1,1,1);
//        Subject sb4 = new Subject(4,ts9,sg2,2,6);
//        Subject sb5 = new Subject(5,ts2,sg2,2,3);
//        Subject sb6 = new Subject(6,ts3,sg3,3,6);
//        Subject sb7 = new Subject(7,ts20,sg3,3,3);
//        Subject sb8 = new Subject(8,ts13,sg4,4,4);
//        Subject sb9 = new Subject(9,ts28,sg2,2,2);
//        Subject sb10 = new Subject(10,ts23,sg3,3,6);
//        Subject sb11 = new Subject(11,ts1,sg1,1,1);
//        Subject sb12 = new Subject(12,ts24,sg4,4,4);
//        Subject sb13 = new Subject(13,ts7,sg1,1,1);
//        Subject sb14 = new Subject(14,ts29,sg2,2,2);
//        Subject sb15 = new Subject(15,ts25,sg2,2,5);
//        Subject sb16 = new Subject(16,ts3,sg3,3,4);
//        Subject sb17 = new Subject(17,ts10,sg3,3,1);
//        Subject sb18 = new Subject(18,ts4,sg4,4,5);
//        Subject sb19 = new Subject(19,ts28,sg2,2,2);
//        Subject sb20 = new Subject(20,ts22,sg3,3,3);
//        Subject sb21 = new Subject(21,ts11,sg4,4,4);
//        subjectRepository.add(sb21);
//
//        subjectRepository.add(sb1);
//        subjectRepository.add(sb2);
//        subjectRepository.add(sb3);
//        subjectRepository.add(sb4);
//        subjectRepository.add(sb5);
//        subjectRepository.add(sb6);
//        subjectRepository.add(sb7);
//        subjectRepository.add(sb8);
//        subjectRepository.add(sb9);
//        subjectRepository.add(sb10);
//        subjectRepository.add(sb11);
//        subjectRepository.add(sb12);
//        subjectRepository.add(sb13);
//        subjectRepository.add(sb14);
//        subjectRepository.add(sb15);
//        subjectRepository.add(sb16);
//        subjectRepository.add(sb17);
//        subjectRepository.add(sb18);
//        subjectRepository.add(sb19);
//        subjectRepository.add(sb20);
//
//
//        String repositoryType = properties.getProperty("Repository");
//
//        if(repositoryType.equals( "txt"))
//        {
//            activityRepository = new TxtRepository<Activity>(properties.getProperty("ActivitiesTxt"));
//            disciplineRepository = new TxtRepository<Discipline>(properties.getProperty("DisciplinesTxt"));
//            //rr = new TxtRepository<Discipline>(properties.getProperty("RoomsTxt"));
//            teacherRepository = new TxtRepository<Discipline>(properties.getProperty("TeachersTxt"));
//
//        }
//        else if(repositoryType.equals("bin"))
//        {
//            activityRepository = new BinRepository<Activity>(properties.getProperty("ActivitiesBin"));
//            disciplineRepository = new BinRepository<Discipline>(properties.getProperty("DisciplinesBin"));
//            //rr = new BinRepository<Discipline>(properties.getProperty("RoomsBin"));
//            teacherRepository = new BinRepository<Discipline>(properties.getProperty("TeachersBin"));
//
//        }
//        else if(repositoryType.equals("db"))
//        {
//            teacherRepository = new DbRepository<Activity>("teacher");
//
//            disciplineRepository = new DbRepository<Discipline>("discipline");
//        }
//        Service ctrl = new Service(activityRepository,disciplineRepository,roomRepository,specialisationRepository,teacherRepository,subjectRepository);
//        UI ui= new UI(ctrl);
//
//        UI.menu();
//
//
//
//
//
//        Scanner sc = new Scanner(System.in);
//        while (true)
//        {
//            System.out.println("Enter command ");
//            int command = sc.nextInt();
//            switch (command)
//            {
//                case 1:
//                    System.out.println("Give teacher's id ");
//                    int id = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give teacher's name ");
//                    String name = sc.nextLine();
//                    System.out.println("Give teacher's rank ");
//                    String rank = sc.nextLine();
//                    boolean ok = ui.addTeacher(id,name,rank);
//                    if(ok) System.out.println("Added successfully" );
//                    else System.out.println("Could not add");
//                    break;
//                case 2:
//                    for(int i=0; i<ui.getCtrl().getTeacherRepo().getEntities().size(); i++ )
//                    {
//                        System.out.println(ui.getCtrl().getTeacherRepo().getEntities().get(i).toString());
//                    }
//                    break;
//                case 3:
//                    System.out.println("Give old teacher's id ");
//                    int oldId = sc.nextInt();
//                    System.out.println("Give new teacher's id ");
//                    int newId = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give new teacher's name ");
//                    name = sc.nextLine();
//                    System.out.println("Give new teacher's rank ");
//                    rank = sc.nextLine();
//                    ok = ui.updateTeacher(oldId,newId,name,rank);
//                    if(ok) System.out.println("Updated successfully" );
//                    else System.out.println("Not updated");
//                    break;
//                case 4:
//                    System.out.println("Give teacher's id");
//                    id=sc.nextInt();
//                    ok = ui.deleteTeacher(id);
//                    if(ok) System.out.println("Deleted successfully" );
//                    else System.out.println("The teacher does not exist");
//                    break;
//                case 5:
//                    System.out.println("Give discipline id ");
//                    id = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give discipline name ");
//                    String discipline = sc.nextLine();
//                    ok = ui.addDiscipline(id,discipline);
//                    if(ok) System.out.println("Added successfully" );
//                    else System.out.println("Already exists");
//                    break;
//                case 6:
//                    for(int i=0;i<ui.getCtrl().getDisciplineRepo().getEntities().size();i++)
//                    {
//                        System.out.println(ui.getCtrl().getDisciplineRepo().getEntities().get(i).toString());
//                    }
//                    break;
//                case 7:
//                    System.out.println("Give old discipline's id ");
//                    oldId = sc.nextInt();
//                    System.out.println("Give new discipline's id ");
//                    newId = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give new discipline's name ");
//                    name = sc.nextLine();
//                    ok = ui.updateDiscipline(oldId,newId,name);
//                    if(ok) System.out.println("Updated successfully" );
//                    else System.out.println("Not updated");
//                    break;
//                case 8:
//                    System.out.println("Give old discipline's id ");
//                    oldId = sc.nextInt();
//                    ok = ui.deleteDiscipline(oldId);
//                    if(ok) System.out.println("Deleted successfully" );
//                    else System.out.println("Did not exist");
//                    break;
//                case 9:
//                    System.out.println("Give activity id");
//                    id=sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give activity type");
//                    String t = sc.nextLine();
//                    System.out.println("Give activity discipline id");
//                    int did = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give activity teacher id");
//                    int tid = sc.nextInt();
//                    sc.nextLine();
//                    ok=ui.addActivity(id,t,did,tid);
//                    if(ok) System.out.println("Added successfully" );
//                    else System.out.println("Please give a valid activity ");
//                    break;
//                case 10:
//                    for(int i=0; i< ui.getCtrl().getActivityRepo().getEntities().size();i++)
//                    {
//                        System.out.println(ui.getCtrl().getActivityRepo().getEntities().get(i).toString());
//                    }
//                    break;
//                case 11:
//                    System.out.println("Give old activity id");
//                    oldId = sc.nextInt();
//                    System.out.println("Give new activity id");
//                    newId = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give activity type");
//                    t = sc.nextLine();
//                    System.out.println("Give activity discipline id");
//                    did = sc.nextInt();
//                    System.out.println("Give activity teacher id");
//                    tid = sc.nextInt();
//                    ok=ui.updateActivity(oldId,newId,t,did,tid);
//                    if(ok) System.out.println("Updated successfully" );
//                    else System.out.println("There has been an error. Either the activity does not exist or the new one does not correspond");
//                    break;
//                case 12:
//                    System.out.println("Give old activity id");
//                    id=sc.nextInt();
//                    ok=ui.deleteActivity(id);
//                    if(ok) System.out.println("Deleted successfully" );
//                    else System.out.println("Activity does not exist");
//                    break;
//
//                case 13:
//                    String building;
//                    String type;
//                    System.out.println("Give room id");
//                    id=sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give room name ");
//                    name = sc.nextLine();
//                    System.out.println("Give building name ");
//                    building = sc.nextLine();
//                    int[] activities = new int[ui.getCtrl().getActivityRepo().getEntities().size()];
//                    ok=true;
//                    int i=0;
//                    while(ok) {
//                        System.out.println("Give activity id ");
//                        int aid = sc.nextInt();
//                        sc.nextLine();
//                        activities[i++]=aid;
//
//                        System.out.println("Add another one? ");
//                        String response = sc.nextLine();
//                        if(response.equals("no"))
//                            ok=false;
//                    }
//                    ui.addRoom(id,name,building,activities);
//                    break;
//                case 14:
//                    for(i=0; i< ui.getCtrl().getRoomRepo().getEntities().size();i++)
//                    {
//                        System.out.println(ui.getCtrl().getRoomRepo().getEntities().get(i).toString());
//                    }
//                    break;
//                case 15:
//                    System.out.println("Give old room id");
//                    oldId=sc.nextInt();
//                    System.out.println("Give room id");
//                    id=sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Give room name ");
//                    name = sc.nextLine();
//                    System.out.println("Give building name ");
//                    building = sc.nextLine();
//                    activities = new int[ui.getCtrl().getActivityRepo().getEntities().size()];
//                    ok=true;
//                    i=0;
//                    while(ok) {
//                        System.out.println("Give activity id ");
//                        int aid = sc.nextInt();
//                        sc.nextLine();
//                        activities[i++]=aid;
//
//                        System.out.println("Add another one? ");
//                        String response = sc.nextLine();
//                        if(response.equals("no"))
//                            ok=false;
//                    }
//                    ok = ui.updateRoom(oldId,id,name,building,activities);
//                    if(ok) System.out.println("Updated ");
//                    else System.out.println("Error. Not updated");
//                    break;
//
//                case 16:
//                    System.out.println("Give id ");
//                    id=sc.nextInt();
//                    ok=ui.deleteRoom(id);
//                    break;
//
//                case 17:
//                    sc.nextLine();
//                    System.out.println("Give rank ");
//                    rank=sc.nextLine();
//                    ArrayList<Teacher> teachers = ui.getCtrl().getTeacherRepo().getEntities();
//
//                      teachers.stream()
//                            .filter(st->st.getRank().equals(rank))
//                            .sorted((st1,st2)->st1.getName().compareTo(st2.getName()))
//                            .forEach(System.out::println);
//
////                    Stream<ArrayList<Teacher>> stream = Stream.of(teachers);
////                    stream.forEach(tc->tc.stream()
////                            .filter(teacher -> teacher.getRank().equals(rank))
////                            .sorted((tc1,tc2)->tc1.getName().compareTo(tc2.getName()))
////                            .forEach(tr-> System.out.println(tr.toString())));
//                    break;
//
//                case 18:
////                    for(i=0; i< ui.getCtrl().getSubjectRepo().getEntities().size();i++)
////                    {
////                        System.out.println(ui.getCtrl().getSubjectRepo().getEntities().get(i).toString());
////                    }
//                    System.out.println("Give room ");
//                    int roomId=sc.nextInt();
//                    ArrayList<Subject> subjects = ui.getCtrl().getSubjectRepo().getEntities();
//                    Stream<ArrayList<Subject>> stream1 = Stream.of(subjects);
//                    stream1.forEach(sj->sj.stream()
//                            .filter(subject -> subject.getRoomId()==roomId)
//                            .sorted((sj1,sj2)->sj1.getTimeslot().compareTo(sj2.getTimeslot()))
//                            .forEach(sbj-> System.out.println(sbj.toString()))
//                    );
//                    break;
//                case 19:
//                    System.out.println("Give subgroup");
//                    sc.nextLine();
//                    name = sc.nextLine();
//                    Stream<ArrayList<Subject>> stream2 = Stream.of(ui.getCtrl().getSubjectRepo().getEntities());
//                    stream2.forEach(subj->subj.stream()
//                            .filter(subject -> subject.getSubgroup().getName().equals(name))
//                            .sorted((sj1,sj2)->sj1.getTimeslot().compareTo(sj2.getTimeslot()))
//                            .forEach(sbj-> System.out.println(sbj.toString()))
//                    );
//                    break;
//
//                case 0:
//                    return;
//            }
//        }
//    }
//}
//
//