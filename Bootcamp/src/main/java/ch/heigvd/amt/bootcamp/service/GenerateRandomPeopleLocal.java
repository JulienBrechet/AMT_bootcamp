/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp.service;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GenerateRandomPeopleLocal {
   /**
   *
   * @return
   */
  List<Person> getPeople();
  
  void buildPeople(long nbPeople);
  
  void destroyPeople();
}
