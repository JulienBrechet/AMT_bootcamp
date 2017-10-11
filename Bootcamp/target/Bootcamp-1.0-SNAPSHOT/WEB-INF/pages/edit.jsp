<%@include file="includes/header.jsp" %>

<h2>Edit</h2>



<form method="POST" action="<c:url value="${applyLink}"/>?code=0&id=${person.id}&pageIndex=${pageIndex}&pageSize=${pageSize}">
  First Name:<br>
  <input type="text" name="firstName" value="${person.firstName}" required>
  <br>
  Last Name:<br>
  <input type="text" name="lastName" value="${person.lastName}" required>
  <br>
  Street:<br>
  <input type="text" name="street" value="${person.street}" required>
  <br><br>
  <input type="submit" value = "apply changes">
</form>


<%@include file="includes/footer.jsp" %>
