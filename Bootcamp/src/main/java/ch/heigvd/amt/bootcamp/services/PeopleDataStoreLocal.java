package ch.heigvd.amt.bootcamp.services;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PeopleDataStoreLocal {

  /**
   *
   * @return
   */
  List<Person> getAllPeople();

}
