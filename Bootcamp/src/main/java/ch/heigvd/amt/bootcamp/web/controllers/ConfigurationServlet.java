package ch.heigvd.amt.bootcamp.web.controllers;

import ch.heigvd.amt.bootcamp.model.Person;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.bootcamp.services.dao.PeopleWriteManagerLocal;
import ch.heigvd.amt.bootcamp.service.GenerateRandomPeopleLocal;
import java.util.List;

/**

 */
public class ConfigurationServlet extends HttpServlet {

  @EJB
  PeopleWriteManagerLocal peopleWriteManager;
  @EJB
  GenerateRandomPeopleLocal generateRandomPeople;

  
  
   /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {    
     
      try{
            /*
            Get the parameter values, which have been transmitted either in the query string
            (for GET requests) or in the body (for POST requests).
            */
            long quantity = Integer.parseInt(request.getParameter("quantity"));

            //we first clear the list of random people
            generateRandomPeople.destroyPeople();
            //we generate random people
            generateRandomPeople.buildPeople(quantity);
            //we get the list of random people
            List<Person> peopleToWrite = generateRandomPeople.getPeople();
            //we write the people in DB
            peopleWriteManager.writePeople(peopleToWrite);
            
            //redirect to ManageServelet
            String targetUrl = "/pages/manage";
            targetUrl = request.getContextPath() + targetUrl;
            response.sendRedirect(targetUrl);


      }catch(NumberFormatException ex){

          request.getRequestDispatcher("/WEB-INF/pages/configuration.jsp").forward(request, response);
      }

  }
  
  
  
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     processRequest(request, response);
  }

  
  
  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}






  