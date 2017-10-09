<title>Welcome  Page</title>
<!DOCTYPE html>
<html>
<body>
<header>
    <jsp:include page="NavBar.jsp">
        <jsp:param name="param1" value="${login.userName}"></jsp:param>
    </jsp:include>
</header>
<table>
    <tr>
        <td>Welcome  </td>
    </tr>
    <tr>
    </tr>
    <tr>
    </tr>
    <tr>

        </td>
    </tr>
</table>

<br><br><br><br><br>
Welcome Page


<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="auth.jsp" />
    <jsp:include page="footer.jsp"/>
</div>
</body>