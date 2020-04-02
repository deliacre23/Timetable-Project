package repository;

import domain.Entity;
import domain.Subject;

import java.util.ArrayList;

interface EntityRepository <T extends Entity>{
    int find(int id);
    boolean add(T e);
    boolean remove(int id);
    boolean update(int id, T newE);
    boolean validate(T e);
    ArrayList<T> getEntities();
    void setEntities(ArrayList<T> entities);
}

public class Repository <T extends Entity> implements EntityRepository<T> {
    protected ArrayList<T> entities = new ArrayList<>();

    public Repository(){
    }

    @Override
    public ArrayList<T> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(ArrayList<T> entities) {
        this.entities = entities;
    }

    @Override
   public int find(int id)
    {
        for(int i=0; i < this.entities.size(); i++)
        {
            if(this.entities.get(i).getId()==id)
            {
                return i;
            }

        }
        return -1;
    }

    @Override
    public boolean add (T e)
    {
        if(find(e.getId())==-1 && validate(e))
        {
            this.entities.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove (int id)
    {
        int index = find(id);
        if(index!=-1)
        {
            this.entities.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(int id, T newE)
    {
        int index = find(id);
        int ok=find(newE.getId());
        if(index!=-1 && ok==-1)
        {
            this.entities.set(index, newE);
            return true;
        }
        return false;
    }

    @Override
    public boolean validate(T e) {
        if(e instanceof Subject)
        {
            for(T entity: entities)
            {
                if(entity instanceof Subject)
                {
                    if(((Subject) e).getTimeslot().equals(((Subject) entity).getTimeslot())
                    && ((Subject) e).getRoomId()==((Subject) entity).getRoomId())
                        return false;
                    if(((Subject) e).getTimeslot().equals(((Subject) entity).getTimeslot())
                            && ((Subject) e).getSubgroup().equals(((Subject) entity).getSubgroup()))
                        return false;
                    if(((Subject) e).getTimeslot().equals(((Subject) entity).getTimeslot())
                            &&  ((Subject) e).getActivityId()==((Subject) entity).getActivityId())
                        return false;
                    if(((Subject) e).getActivityId()==((Subject) entity).getActivityId()
                            && ((Subject) e).getSubgroup().equals(((Subject) entity).getSubgroup()))
                        return false;


                }
            }
        }


        return true;
    }
}
