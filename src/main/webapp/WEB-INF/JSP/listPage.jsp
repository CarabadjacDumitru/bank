<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
</head>

<body>
<div class="generic-container">
    <jsp:include page="auth.jsp"/>
    <div class="panel NavBar-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <th>Enabled</th>
                <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                    <th width="100"></th>
                </sec:authorize>
                <sec:authorize access="hasRole('USER')">
                    <th width="100"></th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${logins}" var="user">
                <tr>
                    <td>${login.userName}</td>
                    <td>${login.passWord}</td>
                    <td>${login.email}</td>
                    <td>${login.enabled}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <sec:authorize access="hasRole('USER')">
        <div class="well">
            <a href="<c:url value='//register' />">Add New User</a>
        </div>
    </sec:authorize>
</div>

<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="auth.jsp"/>
</div>

<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>