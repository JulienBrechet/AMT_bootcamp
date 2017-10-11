package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PeopleDAOLocal {
  
 
  public List<Person> getPeople();
  public void writePeople(List<Person> peopleToWrite);
  public void editPerson(Person personToEdit);
  public void deletePeople(); 
  public void deletePerson(long id);
  
  
  public List<Person> findPeoplePageForCompanyId(long companyId, int pageSize, int pageIndex);
  public long countPeople(int companyId);
}
