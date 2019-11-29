<%-- 
    Document   : WrestleTalk
    Created on : Nov 24, 2019, 6:12:39 PM
    Author     : Parker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WrestleTalk Hub</title>
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
        
        <h1>WRESTLE TALK News</h1>
        
        
        
            <c:forEach var="WT" items="${sessionScope.wtList}">
               
                <img src= " ${WT.img} "/> 
                <br>
                <a href="${WT.url}">${WT.title}</a>     
                <br>    
     
            </c:forEach>
        
    </body>
</html>

