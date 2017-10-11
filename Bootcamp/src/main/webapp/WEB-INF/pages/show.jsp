<%@include file="includes/header.jsp" %>

<h2>Show Database</h2>
<br><br>
<form method="POST" action="pages/create">
   <input type="submit" name="create" value = "create person">
</form>
<br><br>
<ul>
<c:forEach items="${people}" var="person">
  <li> 
   <table style="width:100%">
      <tr>
         <td style="width:80%"> ${person.firstName}, ${person.lastName}, ${person.street}</td>
         <td style="width:10%">
            <a href="<c:url value="${personEditLink}"/>?code=1&id=${person.id}&firstName=${person.firstName}&lastName=${person.lastName}&street=${person.street}&pageIndex=${pageIndex}&pageSize=${pageSize}">edit</a>
         </td>
         <td style="width:10%">
            <a href="<c:url value="${personDeleteLink}"/>?id=${person.id}&pageIndex=${pageIndex}&pageSize=${pageSize}">delete</a>
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
