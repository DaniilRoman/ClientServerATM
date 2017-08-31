<%-- 
    Document   : currentBalance
    Created on : 17.08.2017, 19:08:17
    Author     : Admin
--%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Текущий баланс:<%=(Float)session.getAttribute("currentBalance")%><br><br>
        <form action="change.jsp" method="POST">
            <input type="submit" value="back">
        </form>
    </body>
</html>
