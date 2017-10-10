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
public class PeopleDeleteManager implements PeopleDeleteManagerLocal {
  
 @Resource(lookup = "jdbc/random_people")
  private DataSource dataSource;

  @Override
  public void deletePeople() {   
     
      try {
         try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people");) {
              pstmt.executeUpdate();
              pstmt.close();
             }
         } catch (SQLException ex) {
             Logger.getLogger(PeopleDeleteManager.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(PeopleDeleteManager.class.getName()).log(Level.SEVERE, null, ex);
           }
  }
  
}
