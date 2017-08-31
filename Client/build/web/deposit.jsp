<%-- 
    Document   : deposit
    Created on : 17.08.2017, 19:09:00
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
        Внесите купюру:<br>
        <form action="Deposit" method="POST">
            <input type="number" name="cash"><br><br>
            <input type="submit" value="deposit"><br><br>
        </form>
        <form action="change.jsp" method="POST">
            <input type="submit" value="back"><br><br>
        </form>
    </body>
</html>
