package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PeopleWriteManagerLocal {
  
 
  /**
   * @param peopleToWrite
   * @return
   */
  public void writePeople(List<Person> peopleToWrite);
  
}
