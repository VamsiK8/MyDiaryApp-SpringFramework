<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- Format -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="resources/css/style.css"/>">
</head>
<body>

 <div>
  
    <div class="header">
    
    <div class="hleft">
      <img src="<c:url value="resources/images/book.png"/>" height="70px" width="70px" alt="image">
    </div>
    <div class="hright">MyDiary App</div>
    
    </div>
    
       <br/><br/>
    <hr/>
    <br/>
    
     <div class="userhome">
     
     <h2 style="text-align: left">Welcome <span style="color:SteelBlue">${user.username}</span></h2>  
     <h4><a href="./signout" style="color:red; float:right">SignOut</a></h4>
     
     <br/><br/><br/><br/>
     
     <span class="heading">List of Entries</span>&nbsp;
     <a href="./addentry"><button class="addbtn">Add Entry</button></a>
     
      <br/><br/>
     <table border="1">
     <tr>
     <th>Date</th>
     <th colspan="4">Actions</th>
     </tr>
     
     <c:if test="${entrieslist.size()==0}">
     <tr><td style="font-size:20px;color:green;text-align:center" colspan="4">User not added any details</td></tr>
     </c:if>
     
     <c:forEach items="${entrieslist}" var="e">
     <tr>
     <td>
     <fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/>
     
     
     </td>
     <td><a href="./viewentry?id=${e.id}" >View</a></td>
     <td><a href="./updateentrypage?id=${e.id}" >Update</a></td>
     <td><a href="./deleteentry?id=${e.id}" >Delete</a></td>
     </tr>
     </c:forEach>
     
     </table>

    </div>
   
  </div>
</body>
</html>