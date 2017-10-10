<title>Welcome  Page</title>
<!DOCTYPE html>
<html>
<body>
<header>
    <jsp:include page="NavHeader.jsp">
        <jsp:param name="param1" value="${login.userName}"></jsp:param>
    </jsp:include>
</header>
<table>
    <br><br><br><br><br><br>
    <td>Welcome  </td>

</table>


<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="NavFooter.jsp"/>
</div>
</body>