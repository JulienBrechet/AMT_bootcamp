package ch.heigvd.amt.bootcamp.web.controllers;

import ch.heigvd.amt.bootcamp.model.Person;
import ch.heigvd.amt.bootcamp.services.dao.PeopleDAOLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**

 */
public class EditPersonServlet extends HttpServlet {
   
   @EJB
   PeopleDAOLocal peopleDAO;
  
  
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
         //we get the code (exception possible: in this case, we redirect to /home)
         int code = Integer.parseInt(request.getParameter("code"));
         
          /*
         Get the parameter values, which have been transmitted either in the query string
         (for GET requests) or in the body (for POST requests).
         */
         long id = Integer.parseInt(request.getParameter("id"));
         String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
         String street = request.getParameter("street");
         //we build a new Person
         Person editPerson = new Person(id, firstName, lastName, street);
         
         
         int pageSize = 0;
         try {
               pageSize = Integer.parseInt(request.getParameter("pageSize"));
         } catch (NumberFormatException e) {
               pageSize = 10;
         }
         int pageIndex = 0;
         try {
               pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
         } catch (NumberFormatException e) {
               pageIndex = 0;
         } 
         
         //if we have to redirect the user to the edit form
         if(code == 1){
            request.setAttribute("applyLink", "pages/edit");
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("person", editPerson);
            request.getRequestDispatcher("/WEB-INF/pages/edit.jsp").forward(request, response);
         }
         //we have to edit in DB
         else{
            
            //we update the DB
            peopleDAO.editPerson(editPerson);
         
            //redirect to ManageServelet
            String targetUrl = "/pages/manage?peoplePageSize=" + pageSize + "&peoplePageIndex="+pageIndex;
            targetUrl = request.getContextPath() + targetUrl;
            response.sendRedirect(targetUrl);
            
            
            /*
            //redirect to ManageServelet
            String targetUrl = "/pages/manage";
            targetUrl = request.getContextPath() + targetUrl;
            response.sendRedirect(targetUrl);*/
         }

      }catch(NumberFormatException ex){

          //redirect to HomeServelet
         String targetUrl = "/pages/home";
         targetUrl = request.getContextPath() + targetUrl;
         response.sendRedirect(targetUrl);
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






  