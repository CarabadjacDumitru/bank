<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <spring:url value="/static/css/font-awesome.css" var="awecss"/>
    <spring:url value="/static/css/bootstrap.css" var="bootcss"/>
    <spring:url value="/static/css/navbar.css" var="navcss"/>

    <spring:url value="/static/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/static/js/bootstrap.js" var="bootstrJs"/>
    <spring:url value="/static/js/navbar.js" var="navbarJs"/>


    <link href="${bootcss}" rel="stylesheet"/>
    <link href="${navcss}" rel="stylesheet"/>
    <link href="${awecss}" rel="stylesheet"/>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootstrJs}" type="text/javascript"></script>
    <script src="${navbarJs}" type="text/javascript"></script>

    <title>Register Page</title>
</head>
<body>
<header>
    <jsp:include page="NavBar.jsp"/>
</header>

<div class="generic-container">
    <div class="well lead">User Registration Form</div>
    <form:form method="POST" action="registerProcess" modelAttribute="login" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="userName" id="userName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="userName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passWord">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="passWord" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="passWord" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="eMail">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="roles">Roles</label>
                <div class="col-md-7">
                    <form:select path="roles" items="${roles}" multiple="false" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="roles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/welcome' />">Cancel</a>
            </div>
        </div>
    </form:form>

</div>
<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>