
<%@page errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        <h3>
            <%= request.getSession().getAttribute("title")%>:</h3>
        <ul>
        <%
            ArrayList<String> list = null;
            list = (ArrayList<String>)session.getAttribute("services");
            if(list!=null){
            for(String service:list){
        %> 
            <li>
                <form action="payForService.jsp" method="POST">
                    <input type="submit" name="enter" value="<%=service%>"><br>
                </form>
            </li><br>
        <%
            }
            }
        %>
        </ul><br><br>
        <a href="companies.jsp" class="previous round">&#8249;</a>
        </center>
    </body>
</html>
