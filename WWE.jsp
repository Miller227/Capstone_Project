<%-- 
    Document   : WWE
    Created on : Nov 24, 2019, 6:01:48 PM
    Author     : Parker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WWE Page</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
         <div>
              <h1>WWE News</h1>
            <span>
         <form action="NavigationServlet" method="get"> 
            <ul>
                <li> <input type="submit" value="Home" name="action" /></li>
                   <li><input type="submit" value="wwe" name="action" /></li>
                   <li><input type="submit" value="aew" name="action" /></li>
                   <li><input type="submit" value="wt" name="action" /></li>
            </ul>
        </form>
       <!-- 
        <form action="NavigationServlet" method="post"> 
        <input type="text" name="Search" value="" size="5" />
        </form>
        -->
       
            </span>
        </div>
        
        <div class="centric">
            <c:forEach var="WWE" items="${sessionScope.wweList}">
               
                <img class="cohesive" src= " ${WWE.img} "/> 
                <br>
                <a href="${WWE.url}">${WWE.title}</a>     
                <br>    
     
            </c:forEach>
        </div>
    </body>
</html>
