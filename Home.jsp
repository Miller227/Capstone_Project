<%-- 
    Document   : Home
    Created on : Nov 24, 2019, 6:12:54 PM
    Author     : Parker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div>
        <h1>Sportz Maestro</h1>
        <span>
        <form action="NavigationServlet" method="get"> 
            <ul>
                <li> <input type="submit" value="Home" name="action" /></li>
                   <li><input type="submit" value="wwe" name="action" /></li>
                   <li><input type="submit" value="aew" name="action" /></li>
                   <li><input type="submit" value="wt" name="action" /></li>
                  <!-- <li><input type="text" name="Search" value="" size="5" /></li> -->
            </ul>
        </form>
            
            
        <h1>Biggest Stories Around the Wrestling World</h1>
          </span>
            </div>
        
        <div class="centric">
          <img class="cohesive" src= " ${wweList[0].img} "/> 
                <br>
                <a href="${wweList[0].url}">${wweList[0].title}</a>     
                <br>    
          <img class="cohesive" src= " ${aewList[0].img} "/> 
                <br>
                <a href="${aewList[0].url}">${aewList[0].title}</a>     
                <br>    
          <img class="cohesive" src= " ${wtList[0].img} "/> 
                <br>
                <a href="${wtList[0].url}">${wtList[0].title}</a>     
                <br>    
        </div>
    </body>
</html>
