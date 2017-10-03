<%@page session="false"%>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<header>
     <jsp:include page="NavBar.jsp" />
</header>

<h4>  USER INFOOOOOOOO</h4>

<h1>Message : ${message}</h1>
</body>

</tr>

<div class="navbar nav-justified">
    <%@include file="auth.jsp" %>
</div>

<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>

</html>