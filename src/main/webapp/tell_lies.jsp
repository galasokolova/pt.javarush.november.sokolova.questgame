<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <meta charset="UTF-8">
    <title>Not Accept Call</title>
</head>

<body>
<br><br>
<h1>Oh, NO!</h1>
<br><br>
<h2>${sessionScope.tellLiesResult.text}</h2>
<td><button onclick="window.location.href = '${sessionScope.restart}'">RESTART</button></td>
<td colspan="2">
    <p id="message"></p>
</td>


</body>
</html>
