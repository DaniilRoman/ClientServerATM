<%-- 
    Document   : newjsp
    Created on : 31.08.2017, 12:51:21
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
	com.netcracker.atm.bank.Bank port = service.getBankPort();
	 // TODO initialize WS operation arguments here
	int cardNumber = 0;
	// TODO process result here
	float result = port.getCurrentBalance(cardNumber);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
