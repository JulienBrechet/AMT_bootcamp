<%@include file="includes/header.jsp" %>

<h2>Configuration</h2>



<form action="">
  Quantity (between 1 and 100):
  <input type="number" name="quantity" min="1" max="100">
  <input type="submit" value = "build database">
</form>

<ul>
<c:forEach items="${people}" var="people">
  <li> 
   <table style="width:100%">
      <tr>
         <td style="width:80%">${people.firstName}, ${people.lastName}, ${people.street}</td>
         <td style="width:10%">
            <form action="">
               <input type="submit" value = "edit">
            </form>
         </td>
         <td style="width:10%">
            <form action="">
               <input type="submit" value = "delete">
            </form>
         </td>
      </tr>
   </table>        
  </li>
</c:forEach>
</ul>

<%@include file="includes/footer.jsp" %>
