package ch.heigvd.amt.bootcamp.services;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ConfigurationManager implements ConfigurationManagerLocal {
  
  private static final int MAX_DATABASE_DELAY_MS = 0;
  //private static final int MAX_DATABASE_DELAY_MS = 10000;
  @EJB
  PeopleDataStoreLocal peopleDataStore;
  
  /**
   * This method returns the list of all beers in the data store.
   * @return a list of beers
   */
  @Override
  public List<Person> getAllPeople() {
    simulateDatabaseDelay();
    return peopleDataStore.getAllPeople();
  }
  
  private void simulateDatabaseDelay() {
    long simulatedDatabaseLookupTime = (long)(Math.random() * MAX_DATABASE_DELAY_MS);
    try {
      Thread.sleep(simulatedDatabaseLookupTime);
    } catch (InterruptedException ex) {
      Logger.getLogger(ConfigurationManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
  
}
