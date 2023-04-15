<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <meta charset="UTF-8">
    <title>Not Accept Call</title>
</head>
<body>
<br><br><br>
<h1>${sessionScope.refuseResult.text}</h1>
<br><br>
<td><button onclick="window.location.href = '${sessionScope.restart}'">RESTART</button></td>

<td colspan="2">
    <p id="message"></p>
</td>


</body>
</html>
