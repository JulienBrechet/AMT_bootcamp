package ch.heigvd.amt.bootcamp.model;

/**
 *
 * @author Julien Brêchet
 * @author Adrien Marco
 */
public class Person {
   private long  id;
   private String firstName;
   private String lastName;
   private String street;

   public Person(long id, String firstName, String lastName, String street) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.street = street;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getStreet() {
      return street;
   }
   
   public long getId() {
      return id;
   }
}
