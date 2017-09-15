<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cardOver</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        <h3>Your card has expired.</h3>
        <form action="Clear" method="POST">
            <p>Eject a card</p><br>
            <a href="" onClick="this.parentNode.submit(); return false;" class="previous round">&#8249;</a>
        </form>
        </center>
    </body>
</html>
