
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>payForService</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        <h3><%=request.getParameter("enter")%>
        </h3><br><br>
        <form action="PayForService" method="POST">
            <input type="text" name="cash" min="0"><br><br>
            <input type="submit" value="pay"><br><br>
        </form>
        <a href="services.jsp" class="previous round">&#8249;</a>
        </center>
    </body>
</html>
