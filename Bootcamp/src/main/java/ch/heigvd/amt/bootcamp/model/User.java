package ch.heigvd.amt.bootcamp.model;

/**
 *
 * @author Julien Brêchet
 * @author Adrien Marco
 */
public class User {
   private long  id;
   private String userName;
   private String userPwd;


   public User(long id, String userName, String userPwd) {
      this.id = id;
      this.userName = userName;
      this.userPwd = userPwd;
   }

   public String getUserPwd() {
      return userPwd;
   }

   public String getUserName() {
      return userName;
   }
   
   public long getId() {
      return id;
   }
}
