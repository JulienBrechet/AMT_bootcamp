<%@include file="includes/header.jsp" %>



<h2>Show Database</h2>
<br><br>
<a href="<c:url value="${personCreateLink}"/>?code=1&pageIndex=${pageIndex}&pageSize=${pageSize}&peoplePageCount=${peoplePageCount}">add</a>
<br><br>
<div class="form-group pull-right">
   <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table class="table table-hover table-bordered results">
   <thead>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Street</th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${people}" var="person">
      <tr>
         <td>${person.firstName}</td>
         <td>${person.lastName}</td>
         <td>${person.street}</td> 
         <td>
            <a href="<c:url value="${personEditLink}"/>?code=1&id=${person.id}&firstName=${person.firstName}&lastName=${person.lastName}&street=${person.street}&pageIndex=${pageIndex}&pageSize=${pageSize}">edit</a>
         </td>
         <td>
            <a href="<c:url value="${personDeleteLink}"/>?id=${person.id}&pageIndex=${pageIndex}&pageSize=${pageSize}">delete</a>
         </td>
      </tr>     
</c:forEach>
   </tbody>
</table> 


<nav>
    <ul class="pager">
      <li><a href="<c:url value="${peopleFirstPageLink}"/>">Page 1</a></li>
      <li><a href="<c:url value="${peoplePreviousPageLink}"/>">Previous page</a></li>
      <li><a href="<c:url value="${peopleNextPageLink}"/>">Next page</a></li>
      <li><a href="<c:url value="${peopleLastPageLink}"/>">Page ${peoplePageCount}</a></li>
    </ul>
  </nav>
      
<%@include file="includes/footer.jsp" %>
