<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html  "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="header.jsp" %>

    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Quest Adventure</title>

</head>
<body>

<p>${sessionScope.acceptCallResult.text}</p>
<br><br>
<td><button onclick="window.location.href = '${sessionScope.goToCaptainResult.url}'">${sessionScope.goToCaptainAnswer.text}</button></td>
<br><br>
<td><button onclick="window.location.href = '${sessionScope.notGoToCaptainResult.url}'">${sessionScope.notGoToCaptainAnswer.text}</button></td>
<td colspan="2">
    <p id="message"></p>
</td>
</body>
</html>
