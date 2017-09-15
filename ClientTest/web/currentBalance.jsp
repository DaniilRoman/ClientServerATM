<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>currentBalance</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        Current balance:<%=(Float)session.getAttribute("currentBalance")%><br><br>
        <%
            if(((String)request.getSession().getAttribute("type")).equals("full")){
        %>
        <form action="change.jsp" method="POST">
            <%}else{%>
        <form action="shortChange.jsp" method="POST">
            <%}%>
            <a href="" onClick="this.parentNode.submit(); return false;" class="previous round">&#8249;</a>
        </form>
            </center>
    </body>
</html>
