<%-- 
    Document   : withdraw
    Created on : 17.08.2017, 19:08:40
    Author     : Admin
--%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw</title>
    </head>
    <body>
        Введите сумму для снятия:<br>
        <form action="Withdraw" method="POST">
            <input type="number" name="cash"><br><br>
            <input type="submit" value="withdraw">
        </form>
    </body>
</html>
