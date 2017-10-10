package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PeopleDeleteManagerLocal {
  
 
  
   
  public void deletePeople();
  
  public void deletePerson(long id);
  
}
