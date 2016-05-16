<%-- 
    Document   : allCustomers
    Created on : May 14, 2016, 2:33:05 PM
    Author     : smonty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>all customers</h1>
        
        
        <c:forEach iteme="${customers}" var="cus">
            <p>name = <c:out value="${cus.name}" /></p>
        </c:forEach>
        
    </body>
</html>
