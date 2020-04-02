//package Tests;
//
//import Classes.Discipline;
//import Repositories.Repository;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RepositoryTest {
//
//
//    @Test
//    void getEntities() {
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        Discipline d3 = new Discipline("Data Bases");
//        Repository<Discipline> dr = new Repository<>();
//        dr.add(d1);
//        dr.add(d2);
//        dr.add(d3);
//        ArrayList<Discipline> list = dr.getEntities();
//        assert (dr.getEntities().size()==list.size());
//
//    }
//
//    @Test
//    void setEntities() {
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        ArrayList<Discipline> list = new ArrayList<>();
//        list.add(d1);
//        list.add(d2);
//        Repository<Discipline> dr = new Repository<>();
//        dr.setEntities(list);
//        assert (dr.getEntities().size()==list.size());
//    }
//
//    @Test
//    void find() {
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        Repository<Discipline> dr = new Repository<>();
//        dr.add(d1);
//        dr.add(d2);
//        assert (dr.find(d1)==0);
//        assert (dr.find(d2)==1);
//
//    }
//
//    @Test
//    void add() {
//
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        Discipline d3 = new Discipline("Data Bases");
//        Discipline d4 = new Discipline("ASC");
//        Discipline d5 = new Discipline("Differential equations");
//
//
//        Repository<Discipline> dr = new Repository<>();
//
//        dr.add(d1);
//        dr.add(d2);
//        dr.add(d3);
//        dr.add(d4);
//        dr.add(d5);
//
//    }
//
//    @Test
//    void remove() {
//
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        Discipline d3 = new Discipline("Data Bases");
//        Discipline d4 = new Discipline("ASC");
//        Discipline d5 = new Discipline("Differential equations");
//        Repository<Discipline> dr = new Repository<>();
//        dr.add(d1);
//        dr.add(d2);
//        dr.add(d3);
//        dr.add(d4);
//        dr.add(d5);
//        assert(dr.getEntities().size()==5);
//
//        dr.remove(d1);
//        assert(dr.getEntities().size()==4);
//        dr.remove(d2);
//        assert(dr.getEntities().size()==3);
//        dr.remove(d3);
//        assert(dr.getEntities().size()==2);
//        dr.remove(d4);
//        assert(dr.getEntities().size()==1);
//        dr.remove(d5);
//        assert(dr.getEntities().size()==0);
//    }
//
//    @Test
//    void update() {
//        Discipline d1 = new Discipline("MAP");
//        Discipline d2 = new Discipline("Complex Analysis");
//        Discipline d3 = new Discipline("Data Bases");
//        Discipline d4 = new Discipline("ASC");
//        Repository<Discipline> dr = new Repository<>();
//        dr.add(d1);
//        dr.add(d2);
//        dr.add(d3);
//        dr.update(d1,d4);
//        assert(dr.getEntities().get(0).getName().equals(d4.getName()));
//
//    }
//}