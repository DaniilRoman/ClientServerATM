
<%@page import="com.netcracker.atm.Atm"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pin</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        <form action="CheakPin" method="POST">
        <h3>Enter PIN code:</h3>
        Pin:<input type="password" name="pin" minlength="4" maxlength="4"/><br><br>
            <a href="" onClick="this.parentNode.submit(); return false;" class="next round">&#8250;</a>
        </form><br>
        <a href="Clear">Eject a card</a>
        </center>
    </body>
</html>
