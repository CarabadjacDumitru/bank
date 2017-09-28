<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>

    <div class="navbar    nav-justified navbar-fixed-top">
        <jsp:include page="NavBar.jsp"/>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">Hello 2222222 </a>
    </c:if>
    <br><br><br><br><br>
    <h6>AAAAAAAAAAAAAAAAA </h6>
    <div class="navbar    nav-justified navbar-fixed-bottom">
         <jsp:include page="footer.jsp"/>
    </div>
</body>
</html>