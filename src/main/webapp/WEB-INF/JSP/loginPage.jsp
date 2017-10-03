<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <spring:url value="/static/css/font-awesome.css" var="awecss"/>
    <spring:url value="/static/css/bootstrap.css" var="bootcss"/>
    <spring:url value="/static/css/navbar.css" var="navcss"/>

    <spring:url value="/static/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/static/js/bootstrap.js" var="bootstrJs"/>
    <spring:url value="/static/js/navbar.js" var="navbarJs"/>

    <link href="${awecss}" rel="stylesheet"/>
    <link href="${bootcss}" rel="stylesheet"/>
    <link href="${navcss}" rel="stylesheet"/>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootstrJs}" type="text/javascript"></script>
    <script src="${navbarJs}" type="text/javascript"></script>
    <title>Login Page</title>
</head>
<body>
<header>
    <jsp:include page="NavBar.jsp"/>
</header>


<div class="container">
    <div class="row" style="margin-top:60px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <c:url var="loginUrl" value="/login"/>
            <form action="${loginUrl}" method="post" class="form-horizontal">
                <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p>You have been logged out successfully.</p>
                    </div>
                </c:if>

                <h2>Please Sign In</h2>
                <hr class="colorgraph">

                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="userName" placeholder="Enter Login" required>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="passWord" placeholder="Enter Password" required>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-block btn-primary btn-default" value="Log in">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <a href="/register" class="btn btn-lg btn-primary btn-block">Register</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>


<div class="navbar nav-justified">
    <%@include file="auth.jsp" %>
</div>
<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
