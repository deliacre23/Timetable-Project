package repository;

import domain.*;

import java.io.*;

public class TxtRepository<T extends Entity> extends Repository implements Serializable{
    private String fileName;

    public TxtRepository(String fileName) {

        this.fileName = fileName;
        if(this.fileName.contains("discipline")) createDisciplines();
        else if(this.fileName.contains("teacher")) createTeachers();
       // else if(this.fileName.contains("activit")) createActivities();
        //else if(this.fileName.contains("room")) createRooms();

    }


    @Override
    public int find(int id)
    {
        int ok = super.find(id);
//        if(ok!=-1)
//            if(e instanceof Discipline) writeDisciplines();
//            else if(e instanceof Teacher) writeTeachers();
           // else if(e instanceof Activity) writeActivities();
           // else if(e instanceof Room) writeRooms();

        return ok;
    }

    @Override
    public boolean add (Entity e)
    {
        boolean ok = super.add(e);
        if(ok)
            if(e instanceof Discipline) writeDisciplines();
            else if(e instanceof Teacher) writeTeachers();
          //  else if(e instanceof Activity) writeActivities();
            //else if(e instanceof Room) writeRooms();
        return ok;

    }

    @Override
    public boolean remove (int id)
    {
        boolean ok = super.remove(id);
//        if(ok)
//            if(e instanceof Discipline) writeDisciplines();
//            else if(e instanceof Teacher) writeTeachers();
            //else if(e instanceof Activity) writeActivities();
         //   else if(e instanceof Room) writeRooms();
        return ok;
    }

    @Override
    public boolean update(int id, Entity newE)
    {
        boolean ok = super.update(id, newE);
//        if(ok)
//            if(oldE instanceof Discipline) writeDisciplines();
//            else if(oldE instanceof Teacher) writeTeachers();
//            //else if(oldE instanceof Activity) writeActivities();
            //else if(oldE instanceof Room) writeRooms();
        return ok;
    }



    void createDisciplines()
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length < 2)
                    continue;
                Discipline b = new Discipline(Integer.parseInt(elems[0].strip()),elems[1].strip());
                this.entities.add(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeDisciplines() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object b : entities) {
                if(b instanceof Discipline)
                bw.write(((Discipline) b).getName());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    void createTeachers()
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length < 2)
                    continue;
                Teacher b = new Teacher(Integer.parseInt(elems[0].strip()),elems[1].strip(),elems[2].strip());
                this.entities.add(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeTeachers() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object b : entities) {
                if(b instanceof Teacher)
                    bw.write(((Teacher) b).getName());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    void createActivities()
//    {
//        BufferedReader br = null;
//        try
//        {
//            br = new BufferedReader(new FileReader(this.fileName));
//            String line = null;
//            while ((line = br.readLine()) != null)
//            {
//                String[] elems = line.split("[|]");
//                if (elems.length < 3)
//                    continue;
//                String type = elems[0].strip();
//                String discipline = elems[1].strip();
//                String teacher = elems[2].strip();
//                Discipline d = new Discipline(discipline);
//                Teacher t = new Teacher(teacher);
//                Activity a = new Activity(type,d,t);
//                this.entities.add(a);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (br != null)
//                try {
//                    br.close();
//                }
//                catch (IOException e)
//                {
//                    System.out.println("Error while closing the file " + e);
//                }
//        }
//    }
//
//    void writeActivities() {
//        BufferedWriter bw = null;
//        try {
//            bw = new BufferedWriter(new FileWriter(this.fileName));
//            for (Object b : entities) {
//                if(b instanceof Activity)
//                    bw.write(((Activity) b).getType()+"|"+((Activity)b).getDiscipline().getName()
//                            +"|"+((Activity)b).getTeacher().getName());
//
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


   /* void createRooms()
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length < 3)
                    continue;

                String name=elems[0].strip();
                String building = elems[1].strip();

                ArrayList<Activity> activities = new ArrayList <>();
                String[] a = elems[2].strip().split("[,]");
                for (int i=0; i< a.length;i++)
                {
                    Activity ac= new Activity(a[i]);
                }
                    activities.add(new Activity);

                String teacher = elems[2].strip();
                Discipline d = new Discipline(discipline);
                Teacher t = new Teacher(teacher);
                Activity a = new Activity(type,d,t);
                this.entities.add(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeRooms() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object b : entities) {
                if(b instanceof Activity)
                    bw.write(((Activity) b).getType()+"|"+((Activity)b).getDiscipline().getName()
                            +"|"+((Activity)b).getTeacher().getName());

                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
}
