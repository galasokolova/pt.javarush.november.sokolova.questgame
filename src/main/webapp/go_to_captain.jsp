<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html  "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="header.jsp" %>
    <link href="index.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Quest Adventure</title>
</head>
<body>
<br><br>
<p>${sessionScope.goToCaptainResult.text}</p>
<br><br>
<td><button onclick="window.location.href = '${sessionScope.tellTruthResult.url}'">${sessionScope.tellTruthAnswer.text}</button></td>
<br><br>
<td><button onclick="window.location.href = '${sessionScope.tellLiesResult.url}'">${sessionScope.tellLiesAnswer.text}</button></td>
<td colspan="2">
    <p id="message"></p>
</td>
</body>
</html>
