package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Stateless
public class PeopleDAO implements PeopleDAOLocal {

   @Resource(lookup = "jdbc/random_people")
   private DataSource dataSource;

   @Override
   public void writePeople(List<Person> peopleToWrite) {

      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("INSERT INTO people (first_name, last_name, street) VALUES (?,?,?)");
         
         //then we write new random people inside
         for (Person person: peopleToWrite) {
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2, person.getLastName());
            pstmt.setString(3, person.getStreet());
            pstmt.executeUpdate();
         }    
         pstmt.close();
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   @Override
   public List<Person> getPeople() {
      List<Person> people = new ArrayList<>();
      try {
         try (Connection connection = dataSource.getConnection(); PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM people");) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               long id = rs.getLong("id");
               String firstName = rs.getString("first_name");
               String lastName = rs.getString("last_name");
               String street = rs.getString("street");
               people.add(new Person(id, firstName, lastName, street));
            }
            pstmt.close();
         }
      } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return people;
   }

   @Override
   public void editPerson(Person personToEdit) {
      
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("UPDATE people SET first_name=?, last_name=?, street=? WHERE id=?");

         pstmt.setString(1, personToEdit.getFirstName());
         pstmt.setString(2, personToEdit.getLastName());
         pstmt.setString(3, personToEdit.getStreet());
         pstmt.setLong(4, personToEdit.getId());
         pstmt.executeUpdate();
         pstmt.close();       
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   @Override
   public void deletePeople() {

      try {
         try (Connection connection = dataSource.getConnection(); PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people");) {
            pstmt.executeUpdate();
            pstmt.close();
         }
      } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   @Override
   public void deletePerson(long id) {
      
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people WHERE id=?");

         pstmt.setLong(1, id);
         pstmt.executeUpdate();
         pstmt.close();         
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
