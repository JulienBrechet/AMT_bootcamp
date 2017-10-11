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
     
     //then we write new random people inside
     for(int i=0; i < peopleToWrite.size(); i++) { 
        
        long id = peopleToWrite.get(i).getId();
        String firstName = peopleToWrite.get(i).getfirstName();
        String lastName = peopleToWrite.get(i).getlastName();
        String street = peopleToWrite.get(i).getStreet();
        
         try {
           try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("INSERT INTO people (first_name, last_name, street) VALUES ('"+firstName+"', '"+lastName+"', '"+street+"')");) {
             pstmt.executeUpdate();
             pstmt.close();
           }
         } catch (SQLException ex) {
           Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
  }
  
  
  
  
  @Override
  public List<Person> getPeople() {
    List<Person> people = new ArrayList<>();
    try {
      try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM people");) {
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
     
        
      long id = personToEdit.getId();
      String firstName = personToEdit.getfirstName();
      String lastName = personToEdit.getlastName();
      String street = personToEdit.getStreet();

       try {
         try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("UPDATE people SET first_name='"+firstName+"', last_name='"+lastName+"', street='"+street+"' WHERE id='"+id+"'");) {
           pstmt.executeUpdate();
           pstmt.close();
         }
       } catch (SQLException ex) {
         Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
      
  }
  
  
  
  @Override
  public void deletePeople() {   
     
      try {
         try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people");) {
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
         try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people WHERE id='"+id+"'");) {
              pstmt.executeUpdate();
              pstmt.close();
             }
         } catch (SQLException ex) {
             Logger.getLogger(PeopleDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
  }
  
  
  
}
