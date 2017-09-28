package ch.heigvd.amt.bootcamp.services;

import ch.heigvd.amt.bootcamp.model.Beer;
import java.util.List;
import javax.ejb.Local;

/**
 * @see BeersDataStore
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface BeersDataStoreLocal {

  /**
   *
   * @return
   */
  List<Beer> getAllBeers();

}
