<%@include file="includes/header.jsp" %>

<h2>Edit</h2>



<form method="POST" action="pages/edit">
   <input type="number" name="code" value = "0" style="display:none;">
  First Name:<br>
  <input type="text" name="firstName" value="${person.firstName}" required>
  <br>
  Last Name:<br>
  <input type="text" name="lastName" value="${person.lastName}" required>
  <br>
  Street:<br>
  <input type="text" name="street" value="${person.street}" required>
  <br><br>
  <input type="number" name="id" value = "${person.id}" style="display:none;">
  <input type="submit" value = "apply changes">
</form>


<%@include file="includes/footer.jsp" %>
