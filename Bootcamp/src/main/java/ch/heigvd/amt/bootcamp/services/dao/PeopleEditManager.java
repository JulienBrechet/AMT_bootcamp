package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;



@Stateless
public class PeopleEditManager implements PeopleEditManagerLocal {
  
 @Resource(lookup = "jdbc/random_people")
  private DataSource dataSource;

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
         Logger.getLogger(PeopleEditManager.class.getName()).log(Level.SEVERE, null, ex);
       }
      
  }
  
}
