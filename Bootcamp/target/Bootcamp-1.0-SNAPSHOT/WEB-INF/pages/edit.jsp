<%@include file="includes/header.jsp" %>

<h2>Edit</h2>
  
  
  <form method="POST" action="<c:url value="${applyLink}"/>?code=0&id=${person.id}&pageIndex=${pageIndex}&pageSize=${pageSize}">
  <div class="form-group">
    <label for="firstName">First Name</label>
    <input type="text" class="form-control" id="firstName"  value="${person.firstName}" name="firstName" required>
  </div>
  <div class="form-group">
    <label for="lastName">Last name</label>
    <input type="text" class="form-control" id="lastName"  name="lastName" value="${person.lastName}" required>
  </div>
  <div class="form-group">
    <label for="street">Street</label>
    <input type="text" id="street" class="form-control" id="street"  name="street" value="${person.street}" required>
  </div>
  <button type="submit" class="btn btn-default" value="apply changes">apply changes</button>
</form>
  
  
  
<%@include file="includes/footer.jsp" %>
