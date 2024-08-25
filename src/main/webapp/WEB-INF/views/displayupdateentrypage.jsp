<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      <img src="<c:url value="resources/images/book.png"/>" height="70px" width="70px" alt="image" >
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
     <h1 style="display:inline-block; margin-left:80px;">UPDATE ENTRY</h1>
     <a href="./backuserhome" ><img src="resources/images/back.png" style="display:inline-block; float:right;"/></a>
     
     <br/><br/><br/>
     
      <form action="./saveupdateentry" method="post">
      
      <label>Date</label> <input type="text" name="entrydate"  class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}" pattern="dd/MM/yyyy"/>" readonly/> <br/><br/>
      <label>Description</label> 
      <textarea name="description" rows="10" cols="45">
      ${entry.description}
      </textarea>
      <input type="hidden" name="userid" value="${user.id}"/>
      <input type="hidden" name="id" value="${entry.id}"/>
      
      <br/><br/><br/>
      <button type="submit" >UPDATE ENTRY</button><br/>
      
      </form>
      <br/>
   
     </div>
     
    </div>
   
  </div>

</body>
</html>