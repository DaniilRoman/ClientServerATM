<%@page errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netcracker.atm.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>companies</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="buttons.css" media="all">
        <center>
        <h3>List of companies:</h3>
        <%
            ArrayList<Company> list = null;
            list = (ArrayList<Company>)session.getAttribute("companies");
            if(list!=null){
            for(Company company:list){
        %> 
                <form action="Services" method="POST">
                     <input type="submit" name="company" value="<%=company.getTitle()%>"><br><br>
                </form>     
        <%
            }
            }
        %>
        <br><br>
        <a href="change.jsp" class="previous round">&#8249;</a>
        </center>
    </body>
</html>
