package fr.m2i.spring.Service;

import fr.m2i.spring.model.Lines;
import java.util.List;


public interface ILinesService {

    public List<Lines> findAll();
    
    public Lines findById(long id);
    
    public void create(Lines todo);

    public void delete(long id);
    
    //public List<Lines> findByClient(long id);
    
   // public void update(long id, Todo todo);
    
}
