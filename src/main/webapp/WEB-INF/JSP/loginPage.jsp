<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<html>

<head>
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
            <form:form id="loginForm" modelAttribute="login"  action="loginProcess"  method="post">
                <c:if test="${param.error == 'true'}">
                    <div style="color:red;margin:10px 0px;">
                        Login Failed!!!<br/>
                        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                    </div>
                </c:if>

                <h2>Please Sign In</h2>
                <hr class="colorgraph">

                <div class="form-group">
                    <form:input id="username" name="userName" path="userName" class="form-control input-lg"
                           placeholder="enter Login" />
                </div>

                <div class="form-group">
                    <form:input id="password" name="passWord" path="passWord"  type="password" class="form-control input-lg" placeholder="Password" />
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <form:button id="login"  name="submit"  class="btn btn-lg btn-success btn-block">Sign In</form:button>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <a href="/register" class="btn btn-lg btn-primary btn-block">Register</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</div>

<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
