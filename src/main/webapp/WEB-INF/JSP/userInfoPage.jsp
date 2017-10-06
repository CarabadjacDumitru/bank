<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<header>
    <jsp:include page="NavBar.jsp"/>
</header>

<h4> USER INFOOOOOOOO</h4>

<h1>Message : ${message}</h1>
</body>

</tr>

<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="auth.jsp"/>
    <jsp:include page="footer.jsp"/>
</div>

</html>