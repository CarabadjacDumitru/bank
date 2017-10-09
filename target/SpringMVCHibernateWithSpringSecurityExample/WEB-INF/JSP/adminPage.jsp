<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <title>Users List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <spring:url value="/static/css/bootstrap.css" var="bootcss"/>
    <link href="${bootcss}" rel="stylesheet"/>

    <spring:url value="/static/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/static/js/bootstrap.js" var="bootstrJs"/>
    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootstrJs}" type="text/javascript"></script>

</head>
<header>
    <jsp:include page="NavBar.jsp">
        <jsp:param name="param1" value="${loggedinuser}"/>
        <jsp:param name="firstname" value="Chaitanya" />
    </jsp:include>
</header>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Password</th>
                <th>Email</th>
                <th>Enabled</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${logins}" var="logins">
                <tr>
                    <td>${logins.userName}</td>
                    <td>${logins.passWord}</td>
                    <td>${logins.eMail}</td>
                    <td>${logins.enabled}</td>
                    <td>${logins.role}</td>
                    <td><a href="<c:url value='/usermodify/${logins.userName}/' />" class="btn btn-success custom-width">edit</a>
                    </td>
                    <td><a href="<c:url value='/userdelete/${logins.userName}/' />" class="btn btn-danger custom-width">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>