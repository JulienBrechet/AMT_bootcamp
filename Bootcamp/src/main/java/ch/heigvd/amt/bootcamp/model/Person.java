package ch.heigvd.amt.bootcamp.model;

/**
 *
 * @author Julien Brêchet
 * @author Adrien Marco
 */
public class Person {
   private String name;
   private String surname;
   private String favouriteAnimal;

   public Person(String name, String surname, String favouriteAnimal) {
      this.name = name;
      this.surname = surname;
      this.favouriteAnimal = favouriteAnimal;
   }

   public String getName() {
      return name;
   }

   public String getSurname() {
      return surname;
   }

   public String getFavouriteAnimal() {
      return favouriteAnimal;
   }
}
