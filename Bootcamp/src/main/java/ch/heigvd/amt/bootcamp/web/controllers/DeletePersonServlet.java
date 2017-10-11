package ch.heigvd.amt.bootcamp.web.controllers;

import ch.heigvd.amt.bootcamp.services.dao.PeopleDAOLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeletePersonServlet extends HttpServlet {
   
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
         //we get the id of the person to delete: the hidden input value of the form contains the id of the person to delete
         long boutonId = Integer.parseInt(request.getParameter("id"));
         //we delete this person in DB
         peopleDAO.deletePerson(boutonId);
         
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
         //redirect to ManageServelet
         String targetUrl = "/pages/manage?peoplePageSize=" + pageSize + "&peoplePageIndex="+pageIndex;
         targetUrl = request.getContextPath() + targetUrl;
         response.sendRedirect(targetUrl);

         
         
         
    }catch(NumberFormatException ex){
       
       String targetUrl = (String) request.getAttribute("targetUrl");
       targetUrl = "/pages/home";
       targetUrl = request.getContextPath() + targetUrl;
       response.sendRedirect(targetUrl);
    }

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
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
