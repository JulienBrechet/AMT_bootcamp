<%@include file="includes/header.jsp" %>

<h2>Create</h2>



<form method="POST" action="<c:url value="${createLink}"/>?code=0&peoplePageCount=${peoplePageCount}&pageIndex=${pageIndex}&pageSize=${pageSize}">
  First Name:<br>
  <input type="text" name="firstName" required>
  <br>
  Last Name:<br>
  <input type="text" name="lastName" required>
  <br>
  Street:<br>
  <input type="text" name="street" required>
  <br><br>
  <input type="submit" value = "apply changes">
</form>


<%@include file="includes/footer.jsp" %>
