<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>
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

</head>
<body>
<header>
    <jsp:include page="NavBar.jsp"/>
</header>


<div class="container">

    <div class="row" style="margin-top:60px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form action="loginProcess" method='POST' class="form-signin">
                <c:if test="${param.error == 'true'}">
                    <div style="color:red;margin:10px 0px;">

                        Login Failed!!!<br/>
                        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

                    </div>
                </c:if>
                <fieldset>
                    <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
                        <h2>Please Sign In</h2>
                        <hr class="colorgraph">

                        <div class="form-group">
                            <input type="text" name="userName" id="email" class="form-control input-lg"
                                   placeholder="enter Email Address" required>
                        </div>

                        <div class="form-group">
                            <input type="password" name="passWord" id="password" class="form-control input-lg"
                                   placeholder="Password" required>
                        </div>


                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">

                                <form:button id="login" name="login" type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">Login</form:button>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <a href="/register" class="btn btn-lg btn-primary btn-block">Register</a>
                            </div>
                        </div>
                    </form:form>
                </fieldset>
            </form>
        </div>
    </div>

</div>

<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
