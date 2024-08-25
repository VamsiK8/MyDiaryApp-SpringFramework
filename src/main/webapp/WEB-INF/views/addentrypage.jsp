<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary App Homepage</title>
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
       <img src="<c:url value="resources/images/book.png"/>" height="350px" width="350px" alt="image">
     </div>  
     
     <div class="bright">
     <h1 style="display:inline-block; margin-left:80px;">ADD ENTRY</h1>
     <a href="./backuserhome" ><img src="resources/images/back.png" style="display:inline-block; float:right;"/></a>
     
     <br/><br/><br/>
     
      <form action="./saveentry" method="post">
      
      <label>Date</label> 
      <input type="date" name="entrydate" placeHolder="Enter name" class="formcontrol"/><br/><br/>
      <label>Description</label> 
      <textarea name="description" rows="10" cols="45" >Default text here</textarea>
      <input type="hidden" name="userid" value="${user.id}"/>
      
      <br/><br/><br/>
      <button type="submit">SAVE ENTRY</button><br/>
    </form><br/>
   
     </div>
     
    </div>
   
  </div>

</body>
</html>