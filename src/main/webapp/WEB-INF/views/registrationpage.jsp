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
    
    <div class="bodypart">
    
     <div class="bleft">
       <img  src="<c:url value="resources/images/book.png"/>" height="350px" width="350px" alt="image">
     </div>  
     
     <div class="bright">
     <h1>REGISTRATION FORM</h1><br/><br/>
      <form action="./saveuser" method="post">
      <label>Username</label> <input type="text" name="username" class="formcontrol" placeHolder="Enter username" /><br/><br/>
      <label>Password</label> <input type="text" name="password" class="formcontrol" placeHolder="Enter password" /><br/><br/>
      <button type="submit">REGISTER</button><br/>
    </form>
    <br/><br/>
   
       Existing User ? <a href="./home" >Login</a> here
     </div>
     
    </div>
   
  </div>

</body>
</html>