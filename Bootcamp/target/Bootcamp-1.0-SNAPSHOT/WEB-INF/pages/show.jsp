<%@include file="includes/header.jsp" %>

<h2>Show Database</h2>


<ul>
<c:forEach items="${people}" var="people">
  <li> 
   <table style="width:100%">
      <tr>
         <td style="width:80%"> ${people.firstName}, ${people.lastName}, ${people.street}</td>
         <td style="width:10%">
            <form >
               <input type="submit" value = "edit">
            </form>
         </td>
         <td style="width:10%">
            <form method="POST" action="pages/delete">
               <input type="submit" name="delete" value = "delete">
               <input type="number" name="id" value = "${people.id}" style="display:none;">
            </form>
         </td>
      </tr>
   </table>        
  </li>
</c:forEach>
</ul>

<%@include file="includes/footer.jsp" %>
