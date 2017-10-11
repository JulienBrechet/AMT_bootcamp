<%@include file="includes/header.jsp" %>

<h2>Create</h2>



<form method="POST" action="pages/create">
  <input type="number" name="code" value = "1" style="display:none;">
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
