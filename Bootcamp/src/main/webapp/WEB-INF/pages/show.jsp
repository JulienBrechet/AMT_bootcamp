<%@include file="includes/header.jsp" %>

<h2>Show Database</h2>


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
