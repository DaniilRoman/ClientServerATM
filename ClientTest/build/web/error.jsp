<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        <center>
        <h3><%=request.getSession().getAttribute("ex")%></h3>
        <a href="Clear">Eject a card</a>
    </center>
        </body>
</html>
