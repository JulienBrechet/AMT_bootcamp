<%@include file="includes/header.jsp" %>

<h2>Configuration</h2>



<form method="POST" action="pages/configuration">
  Quantity (between 1 and 100):
  <input type="number" name="quantity" min="1" max="100" required>
  <input type="submit" value = "build database">
</form>

<%@include file="includes/footer.jsp" %>
