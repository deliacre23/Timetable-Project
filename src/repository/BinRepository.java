package repository;

import domain.Entity;

import java.io.*;
import java.util.ArrayList;

public class BinRepository<T extends Entity> extends Repository implements Serializable{
    private String fileName;
    public BinRepository(String fileName)
    {
        this.fileName = fileName;

        deserializeEntityList();
    }

    @Override
    public int find(int id)
    {
        int ok = super.find(id);
        if(ok!=-1)
            serializeEntityList();
        return ok;
    }

    @Override
    public boolean add (Entity e)
    {
        boolean ok = super.add(e);
        if(ok)
            serializeEntityList();
        return ok;

    }

    @Override
    public boolean remove (int id)
    {
        boolean ok = super.remove(id);
        if(ok)
            serializeEntityList();
        return ok;
    }

    @Override
    public boolean update(int id, Entity newE)
    {
        boolean ok = super.update(id, newE);
        if(ok)
            serializeEntityList();
        return ok;
    }


    public void serializeEntityList() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(this.entities);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deserializeEntityList() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(this.fileName));
            this.entities = (ArrayList<T>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}