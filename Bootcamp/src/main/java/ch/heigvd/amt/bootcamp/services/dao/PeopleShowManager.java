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
public class PeopleShowManager implements PeopleShowManagerLocal {
  
 @Resource(lookup = "jdbc/random_people")
  private DataSource dataSource;

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
      Logger.getLogger(PeopleShowManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return people;
  }
  
}
