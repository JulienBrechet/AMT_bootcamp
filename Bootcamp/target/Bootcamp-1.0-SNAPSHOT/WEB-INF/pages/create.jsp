<%@include file="includes/header.jsp" %>

<h2>Create</h2>
  
  <form method="POST" action="<c:url value="${createLink}"/>?code=0&peoplePageCount=${peoplePageCount}&pageIndex=${pageIndex}&pageSize=${pageSize}">
  <div class="form-group">
    <label for="firstName">First Name</label>
    <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" required>
  </div>
  <div class="form-group">
    <label for="lastName">Last name</label>
    <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName" required>
  </div>
  <div class="form-group">
    <label for="street">Street</label>
    <input type="text" id="street" class="form-control" id="street" placeholder="Street" name="street" required>
  </div>
  <button type="submit" class="btn btn-default" value="apply changes">apply changes</button>
</form>


<%@include file="includes/footer.jsp" %>
