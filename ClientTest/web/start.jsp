
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>startPage</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
    <center>
        <h3>Enter card number!</h3>
        <form action="Pin" method="POST">
            Number:<input type="number" name="card" minlength="16" maxlength="16"/><br><br>
                 <a href="" onClick="this.parentNode.submit(); return false;" class="next round">&#8250;</a>
        </form>
    </center>
    </body>
</html>
