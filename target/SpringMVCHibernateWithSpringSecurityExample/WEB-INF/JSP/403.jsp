<%@page session="false" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<jsp:include page="NavHeader.jsp">
    <jsp:param name="param1" value="${loggedinuser}"></jsp:param>
</jsp:include>
<H6>ACCESS DENIED</H6>
<h3 style="color:red;">${message}</h3>
</body>

<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="NavFooter.jsp"/>
</div>

</html>