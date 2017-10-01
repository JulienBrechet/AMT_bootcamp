package ch.heigvd.amt.bootcamp.services;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;

import com.github.javafaker.Faker;


@Singleton
public class PeopleDataStore implements PeopleDataStoreLocal {

  private final List<Person> catalog = new LinkedList<>();

  /**
   *generate random people
   */
public PeopleDataStore() {
   
   for(int i = 0; i < 10; ++i){

      Faker faker = new Faker();
      String name = faker.name().fullName();
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String streetAddress = faker.address().streetAddress();     
      catalog.add(new Person(firstName, lastName, streetAddress));
   }
}

  /**
   *
   * @return
   */
  @Override
  public List<Person> getAllPeople() {
    return new LinkedList<>(catalog);
  }
}
