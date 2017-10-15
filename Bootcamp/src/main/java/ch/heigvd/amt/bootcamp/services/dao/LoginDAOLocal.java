package ch.heigvd.amt.bootcamp.services.dao;


import javax.ejb.Local;


@Local
public interface LoginDAOLocal {
  
 
  public boolean authenticate(String login, String pwd);
}
