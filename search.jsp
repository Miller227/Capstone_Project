<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%-- 
    Document   : search
    Created on : Dec 4, 2019, 12:55:21 AM
    Author     : Parker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div>
            <h1>Search Results</h1>
            <span>
         <form action="NavigationServlet" method="get"> 
            <ul>
                <li> <input type="submit" value="Home" name="action" /></li>
                   <li><input type="submit" value="wwe" name="action" /></li>
                   <li><input type="submit" value="aew" name="action" /></li>
                   <li><input type="submit" value="wt" name="action" /></li>
            </ul>
        </form>
        
        <form action="NavigationServlet" method="post"> 
        <input type="text" name="SearchValue" value="" size="5" />
        <input type="submit" value="Search" name="Search" />
        </form>
        
        
            </span>
        </div>
        
        
         <div class="centric">
            <c:forEach var="AEW" items="${sessionScope.aewList}">
                <c:if test="if(${fn:contains(AEW.title, Search)})" var="i" scope="session">
                <img class="cohesive" src= " ${AEW.img} "/> 
                <br>
                <a href="${AEW.url}">${AEW.title}</a>     
                <br>    
                </c:if>
            </c:forEach>
        </div>
        
        
        
        
        
    <c:if test="if(${aewList.title} = ${Search})" var="i" scope="session">
            
    </c:if>
        
    </body>
</html>
