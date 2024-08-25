<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <br/><br/>
    
<h1 style="text-align: left">Welcome <span style="color:SteelBlue">${user.username}</span></h1>  
     <h2><a href="./signout" style="color:red; float:right">SignOut</a></h2>
     
    <div class="bodypart">
    
     <div class="bleft">
       <img height="350px" width="350px" alt="image" src="<c:url value="resources/images/book.png"/>" >
     </div>  
     
     <div class="bright">
     
     <h1>VIEW ENTRY</h1><br/><br/><br/>
     
      <table>
      <tr>
        <td>Date</td>
        <td><fmt:formatDate value="${entry.entrydate}" pattern="dd/MM/yyyy"/></td>
      </tr>
      <tr>
        <td>Description</td>
        <td>${entry.description}</td>
      </tr>
      </table>
      
      <br/><br/><br/>
      <a href="./backuserhome"><button type="submit">BACK TO HOME</button></a><br/>
   
     </div>
     
    </div>
   
  </div>

</body>
</html>