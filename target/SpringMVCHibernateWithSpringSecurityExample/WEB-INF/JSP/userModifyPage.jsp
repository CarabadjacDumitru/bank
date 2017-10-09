<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <spring:url value="/static/css/bootstrap.css" var="bootcss"/>
    <spring:url value="/static/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/static/js/bootstrap.js" var="bootstrJs"/>

    <link href="${bootcss}" rel="stylesheet"/>
    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootstrJs}" type="text/javascript"></script>
    <title>Modify User</title>
</head>
<body>
<header>
    <jsp:include page="NavBar.jsp"/>
</header>


<div class="generic-container">

    <div class="well lead">User Registration Form</div>
    <form:form method="POST" action="/usermodify/${loginName}" modelAttribute="login" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userName">Username</label>
                <div class="col-md-7">
                    <form:input type="text" path="userName" id="userName" class="form-control input-sm"
                                disabled="true"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passWord">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="passWord" id="passWord" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="passWord" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
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
                <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                <div class="col-md-7">
                    <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="userProfiles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                    href="<c:url value='//admin' />">Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>