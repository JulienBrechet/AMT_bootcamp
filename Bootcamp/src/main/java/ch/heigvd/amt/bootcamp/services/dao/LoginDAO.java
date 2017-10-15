package ch.heigvd.amt.bootcamp.services.dao;

import ch.heigvd.amt.bootcamp.model.User;
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
public class LoginDAO implements LoginDAOLocal {

   @Resource(lookup = "jdbc/random_people")
   private DataSource dataSource;
   
   
   @Override
   public boolean authenticate(String login, String pwd){
     
      boolean valid = true;      
      List<User> users = new ArrayList<>();
      
      
      try{
         Connection connection = dataSource.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM login WHERE user_login=? AND user_pwd=?");
         pstmt.setString(1, login);
         pstmt.setString(2, pwd);
         ResultSet rs = pstmt.executeQuery();
         
         while (rs.next()) {
            long id = rs.getLong("id");
            String userName = rs.getString("user_login");
            String userPwd = rs.getString("user_pwd");
            users.add(new User(id, userName, userPwd));
         }
         pstmt.close();
      }
      catch (SQLException ex) {
         Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      if(users.isEmpty()){
         valid = false;
      }
      
      return valid;
   }

}
