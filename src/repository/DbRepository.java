package repository;

import domain.Discipline;
import domain.Entity;
import domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class DbRepository <T extends Entity> extends Repository {
    private String type;
    private static final String JDBC_URL = "jdbc:sqlite:data/repository.db";
    private Connection conn = null;

    public DbRepository(String type) {
        if( type.equals("teacher"))
        {
            this.openConnection();
            this.initTeachers();
        }
        if(type.equals("discipline"))
        {
            this.openConnection();
            this.initDisciplines();
        }
    }



    /**
     * Gets a connection to the database.
     * If the underlying connection is closed, it creates a new connection. Otherwise, the current instance is returned.
     */
    private void openConnection()
    {
        try
        {
            // with DriverManager
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(JDBC_URL);

            // with DataSource
//            SQLiteDataSource ds = new SQLiteDataSource();
//            ds.setUrl(JDBC_URL);
//            if (conn == null || conn.isClosed())
//                conn = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the underlying connection to the in-memory SQLite instance.
     */
    private void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Creates the sample schema for the database.
     */
    private void createSchema()
    {
        try
        {
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers(id int, name varchar(50), rank varchar(50));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplines(id int,name varchar(50));");
            stmt.close();
        }
        catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }
    public int find(int id)
    {
        int ok = super.find(id);
        return ok;
    }
    /**
     * Adds some entries in the table books;
     */
    private void initTeachers() {
        final String[] teachers = new String[]{
                "1|Apatean Anca|Associate professor",
                "2|Bocicor Iuliana|Lecturer",
                "3|Vancea Alexandru|Lecturer",
                "4|Pop Emilia|Doctorand",
                "5|Septimiu Crivei|Professor",
                "6|Salagean Grigore|Professor",
                "7|Surdu Sabina|Lecturer",
                "8|Grad Anca|Lecturer",
                "9|Andrica Dorin|Professor"
        };

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?)");
            for (String s : teachers) {
                String[] tokens = s.split("[|]");
                statement.setInt(1, Integer.parseInt(tokens[0]));
                statement.setString(2, tokens[1]);
                statement.setString(3, tokens[2]);
                Teacher t = new Teacher(Integer.parseInt(tokens[0]),tokens[1],tokens[2]);
                this.entities.add(t);
                statement.executeUpdate();
            }
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void initDisciplines()
    {

        final String[] disciplines = new String[]{
                "1|ASC",
                "2|MAP",
                "3|Databases",
                "4|Criptography",
                "5|Geometry"
        };

        try {
            PreparedStatement statement1 = conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?)");
            for (String s : disciplines) {
                String[] tokens = s.split("[|]");
                statement1.setInt(1, Integer.parseInt(tokens[0]));
                statement1.setString(2, tokens[1]);
                statement1.executeUpdate();
                Discipline d = new Discipline(Integer.parseInt(tokens[0]),tokens[1]);
                this.entities.add(d);
            }
            statement1.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    boolean addTeacher(Teacher t)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?)");
            statement.setInt(1, t.getId());
            statement.setString(2, t.getName());
            statement.setString(3, t.getRank());
            this.entities.add(t);
            statement.executeUpdate();
            statement.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove the book with the given title from table books.
     * @param id
     */
    boolean removeTeacher(int id)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM teachers WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            this.entities.remove(id);
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all book from table books in the database.
     * @return: an ArrayList with Book objects.
     */
    ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from teachers");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Teacher t = new Teacher(rs.getInt("id"),rs.getString("name"), rs.getString("rank"));
                teachers.add(t);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return teachers;
    }

    boolean updateTeachers(int id,Teacher t)
    {
        try
        {
            conn.setAutoCommit(false);
            PreparedStatement updateTeacher = conn.prepareStatement("UPDATE teachers SET id = ?, name = ?,rank = ? WHERE id = ?");
            updateTeacher.setInt(1, t.getId() );
            updateTeacher.setString(2,t.getName()  );
            updateTeacher.setString(3,t.getRank()  );
            updateTeacher.setInt(4, id );
            updateTeacher.executeUpdate();
            updateTeacher.close();
            int i = find(id);
            this.entities.set(i,t);
            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    boolean addDiscipline(Discipline t)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?)");
            statement.setInt(1, t.getId());
            statement.setString(2, t.getName());

            statement.executeUpdate();
            statement.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove the book with the given title from table books.
     * @param id
     */
    boolean removeDiscipline(int id)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM disciplines WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all book from table books in the database.
     * @return: an ArrayList with Book objects.
     */
    ArrayList<Discipline> getDisciplines()
    {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from disciplines");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Discipline t = new Discipline(rs.getInt("id"),rs.getString("name"));
                disciplines.add(t);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return disciplines;
    }

    boolean updateDiscipline(int id,Discipline t)
    {
        try
        {
            conn.setAutoCommit(false);
            PreparedStatement updateDiscipline = conn.prepareStatement("UPDATE disciplines SET id = ?, name = ? WHERE id = ?");
            updateDiscipline.setInt(1, t.getId() );
            updateDiscipline.setString(2,t.getName() );
            updateDiscipline.setInt(3, id );
            updateDiscipline.executeUpdate();
            updateDiscipline.close();
            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

//
//    public static void main(String[] args) {
//        DbRepository db_example = new DbRepository();
//        db_example.openConnection();
//        db_example.createSchema();
//        db_example.initTables();
//
//        Teacher t = new Teacher(10,"A","A");
//        Teacher t2 = new Teacher(11,"b","b");
//
//        db_example.addTeacher(t);
//        db_example.removeTeacher(4);
//        db_example.updateTeachers(1,t2);
//        ArrayList<Teacher> teachers = db_example.getTeachers();
//        for (Teacher t1: teachers)
//            System.out.println(t1);
//
//
//        Discipline d = new Discipline(10,"A");
//        Discipline d2 = new Discipline(11,"bbbb");
//        db_example.addDiscipline(d);
//        db_example.removeDiscipline(4);
//        db_example.updateDiscipline(1,d2);
//
//        ArrayList<Discipline> disciplines = db_example.getDisciplines();
//        for (Discipline d1: disciplines)
//            System.out.println(d1);
//
//        db_example.closeConnection();
//    }
}
