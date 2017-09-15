
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        Enter the withdrawal amount:<br>
        <form action="Withdraw" method="POST">
            <input type="number" name="cash" min="0"><br><br>
            <input type="submit" value="withdraw"><br>
        </form>
         <%
            if(((String)request.getSession().getAttribute("type")).equals("full")){
        %>
        <form action="change.jsp" method="POST">
            <%}else{%>
        <form action="shortChange.jsp" method="POST">
            <%}%>
            <a href="" onClick="this.parentNode.submit(); return false;" class="previous round">&#8249;</a>
        </form><br>
        <script type="text/javascript" src="newjavascript.js"></script>
        <link rel="stylesheet" type="text/css" href="newcss.css" media="all">
        <div class="popup" onclick="myFunction()"><u>Info</u>
        <span class="popuptext" id="myPopup">The amount must be a multiple 100.</span>
        </div>
        </center>
    </body>
</html>
