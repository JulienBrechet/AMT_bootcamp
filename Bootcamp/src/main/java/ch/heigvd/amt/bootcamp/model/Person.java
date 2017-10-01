package ch.heigvd.amt.bootcamp.model;

/**
 *
 * @author Julien Brêchet
 * @author Adrien Marco
 */
public class Person {
   private String firstName;
   private String lastName;
   private String street;

   public Person(String firstName, String lastName, String street) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.street = street;
   }

   public String getfirstName() {
      return firstName;
   }

   public String getlastName() {
      return lastName;
   }

   public String getStreet() {
      return street;
   }
}
