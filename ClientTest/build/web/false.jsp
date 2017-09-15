<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>false</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
            <h3><%=(String)request.getSession().getAttribute("ex")%></h3>
            <form action="<%=(String)request.getSession().getAttribute("page")%>" method="POST">
             <a href="" onClick="this.parentNode.submit(); return false;" class="previous round">&#8249;</a>
            </form>
        </center>
    </body>
</html>
