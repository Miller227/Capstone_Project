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
        <title>JSP Page</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        
        <form action="NavigationServlet" method="get"> 
                   <input type="submit" value="Home" name="action" />
                   <input type="submit" value="wwe" name="action" />
                   <input type="submit" value="aew" name="action" />
                   <input type="submit" value="wt" name="action" />
        </form>
        
        
        <form action="NavigationServlet" method="post"> 
        <input type="text" name="Search" value="" size="5" />
        </form>
        
        <h1>WWE News</h1>
        
        
        
            <c:forEach var="WWE" items="${sessionScope.wweList}">
               
                <img src= " ${WWE.img} "/> 
                <br>
                <a href="${WWE.url}">${WWE.title}</a>     
                <br>    
     
            </c:forEach>
        
    </body>
</html>
