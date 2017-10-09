<%@page session="false"%>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<jsp:include page="NavBar.jsp">
    <jsp:param name="param1" value="${login.userName}"></jsp:param>
</jsp:include>
<H6>ACCESS DENIED</H6>
<h3 style="color:red;">${message}</h3>
</body>
</html>