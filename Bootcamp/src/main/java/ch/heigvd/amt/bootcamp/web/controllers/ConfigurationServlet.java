package ch.heigvd.amt.bootcamp.web.controllers;

import ch.heigvd.amt.bootcamp.services.ConfigurationManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 */
public class ConfigurationServlet extends HttpServlet {

  @EJB
  ConfigurationManagerLocal configurationManager;

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
    
    //Object model = configurationManager.getAllPeople();
    
    //request.setAttribute("people", model);
    
    request.getRequestDispatcher("/WEB-INF/pages/configuration.jsp").forward(request, response);
  }

}
