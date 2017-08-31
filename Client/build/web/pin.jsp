<%-- 
    Document   : pinPage
    Created on : 17.08.2017, 16:50:57
    Author     : Admin
--%>

<%@page import="com.netcracker.atm.Atm"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pinPage</title>
    </head>
    <body>
       
        <form action="CheakPin" method="POST">
        <h3>Введите PIN код:</h3>
        Pin:<input type="number" name="pin"/><br><br>
            <input type="submit" name="enter" value="next"/>
        </form>
    </body>
</html>
