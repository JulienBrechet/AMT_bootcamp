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
public class PeopleWriteManager implements PeopleWriteManagerLocal {
  
 @Resource(lookup = "java:/jdbc/random_people")
  private DataSource dataSource;

  @Override
  public void writePeople(List<Person> peopleToWrite) {
     
     for(int i=0; i < peopleToWrite.size(); i++) { 
        
        long id = peopleToWrite.get(i).getId();
        String firstName = peopleToWrite.get(i).getfirstName();
        String lastName = peopleToWrite.get(i).getlastName();
        String street = peopleToWrite.get(i).getStreet();
        
         try {
           try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("INSERT INTO people (id, first_name, last_name, street) VALUES (id, firstName, lastName, street)");) {
             pstmt.executeQuery();
             pstmt.close();
           }
         } catch (SQLException ex) {
           Logger.getLogger(PeopleWriteManager.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
  }
  
}
