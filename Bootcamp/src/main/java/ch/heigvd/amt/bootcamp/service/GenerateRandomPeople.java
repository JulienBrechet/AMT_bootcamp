/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp.service;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;

import com.github.javafaker.Faker;



@Singleton
public class GenerateRandomPeople implements GenerateRandomPeopleLocal{
    private final List<Person> catalog = new LinkedList<>();

  /**
   *generate random people
   */
public GenerateRandomPeople() {

}




  @Override
  public void buildPeople(long nbPeople) {
       
   for(int i = 0; i < nbPeople; ++i){

      Faker faker = new Faker();
      long id = i;
      String name = faker.name().fullName();
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String streetAddress = faker.address().streetAddress();     
      catalog.add(new Person(id, firstName, lastName, streetAddress));
   }
  }

  
  @Override
  public List<Person> getPeople() {
    return new LinkedList<>(catalog);
  }
}
