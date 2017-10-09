<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<header>
    <jsp:include page="NavBar.jsp">
        <jsp:param name="param1" value="${login.userName}"></jsp:param>
    </jsp:include>
</header>
<br><br><br><br><br>


<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="auth.jsp"/>
    <jsp:include page="footer.jsp"/>
</div>
</body>

</html>