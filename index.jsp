<%-- 
    Document   : index
    Created on : Nov 23, 2019, 4:45:42 AM
    Author     : Parker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
          <link rel="stylesheet" href="indexStyle.css">
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        
        <h1>Welcome to Sportz Maestro</h1>
        
        <form action="NavigationServlet" method="post">
                   <input type="submit" name="action" value="home" />  
        </form>
    </body>
</html>
