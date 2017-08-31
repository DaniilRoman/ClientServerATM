<%-- 
    Document   : startPage
    Created on : 17.08.2017, 16:36:07
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>startPage</title>
    </head>
    <body>
        <h3>Введите номер карты!</h3>
        <form action="Pin" method="POST">
            Card:<input type="number" name="card"/><br><br>
                 <input type="submit" name="enter" value="next"/>
</form>
    </body>
</html>
