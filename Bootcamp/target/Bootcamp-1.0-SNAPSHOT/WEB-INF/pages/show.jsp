<%@include file="includes/header.jsp" %>

<h2>Show Database</h2>
<br><br>
<form method="POST" action="pages/create">
   <input type="submit" name="create" value = "create person">
</form>
<br><br>
<ul>
<c:forEach items="${people}" var="people">
  <li> 
   <table style="width:100%">
      <tr>
         <td style="width:80%"> ${people.firstName}, ${people.lastName}, ${people.street}</td>
         <td style="width:10%">
            <form method="POST" action="pages/edit">
               <input type="submit" name="edit" value = "edit">
               <input type="number" name="code" value = "1" style="display:none;">
               <input type="number" name="id" value = "${people.id}" style="display:none;">
               <input type="text" name="firstName" value = "${people.firstName}" style="display:none;">
               <input type="text" name="lastName" value = "${people.lastName}" style="display:none;">
               <input type="text" name="street" value = "${people.street}" style="display:none;">
            </form>
         </td>
         <td style="width:10%">
            <form method="POST" action="pages/delete">
               <input type="submit" name="delete" value = "delete">
               <input type="number" name="id" value = "${people.id}" style="display:none;">
            </form>
         </td>
      </tr>
   </table>        
  </li>
</c:forEach>
</ul>



<nav>
    <ul class="pager">
      <li><a href="<c:url value="${peopleFirstPageLink}"/>">Page 1</a></li>
      <li><a href="<c:url value="${peoplePreviousPageLink}"/>">Previous page</a></li>
      <li><a href="<c:url value="${peopleNextPageLink}"/>">Next page</a></li>
      <li><a href="<c:url value="${peopleLastPageLink}"/>">Page ${peoplePageCount}</a></li>
    </ul>
  </nav>


<%@include file="includes/footer.jsp" %>
