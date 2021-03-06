package ch.heigvd.amt.bootcamp.web.controllers;

import ch.heigvd.amt.bootcamp.model.Person;
import ch.heigvd.amt.bootcamp.service.pageSplitterLocal;
import ch.heigvd.amt.bootcamp.services.dao.PeopleDAOLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 */
public class ManageServlet extends HttpServlet {

  @EJB
  PeopleDAOLocal peopleDAO;
  
  @EJB
  pageSplitterLocal pageSplitter;

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

    int pageSize = 0;
    try {
      pageSize = Integer.parseInt(request.getParameter("peoplePageSize"));
    } catch (NumberFormatException e) {
      pageSize = 10;
    }
    int pageIndex = 0;
    try {
      pageIndex = Integer.parseInt(request.getParameter("peoplePageIndex"));
    } catch (NumberFormatException e) {
      pageIndex = 0;
    }

    List<Person> allPeople = peopleDAO.getPeople();
    List<Person> people = pageSplitter.getPagePeople(allPeople, pageSize, pageIndex);
        
    long numberOfPages = (allPeople.size() + pageSize - 1) / pageSize;
    
    request.setAttribute(("people"), people);   
    request.setAttribute("peopleFirstPageLink", "/pages/manage?peoplePageSize=" + pageSize + "&peoplePageIndex=0");
    request.setAttribute("peoplePreviousPageLink", "/pages/manage?peoplePageSize=" + pageSize + "&peoplePageIndex=" + Math.max(0, pageIndex - 1));
    request.setAttribute("peopleNextPageLink", "/pages/manage?peoplePageSize=" + pageSize + "&peoplePageIndex=" + Math.min(pageIndex + 1, numberOfPages - 1));
    request.setAttribute("peopleLastPageLink", "/pages/manage?&peoplePageSize=" + pageSize + "&peoplePageIndex=" + (numberOfPages-1));
    request.setAttribute("peoplePageCount", numberOfPages);
    request.setAttribute("personDeleteLink", "pages/delete");
    request.setAttribute("personEditLink", "pages/edit");
    request.setAttribute("personCreateLink", "pages/create");
    request.setAttribute("pageSize", pageSize);
    request.setAttribute("pageIndex", pageIndex);
    
    
    
    
    
    
    
    request.getRequestDispatcher("/WEB-INF/pages/show.jsp").forward(request, response);
  }

}
