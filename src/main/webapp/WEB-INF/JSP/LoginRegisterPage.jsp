<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

    <title>Register Page</title>
</head>
<body>
<header>
    <jsp:include page="NavHeader.jsp">
        <jsp:param name="param1" value="${login.userName}"></jsp:param>
    </jsp:include>
</header>

<div class="generic-container">
    <div class="well lead">User Registration Form</div>
    <form:form method="POST" action="/registerProcess" modelAttribute="loginAtr" class="form-horizontal">
        <form:input type="hidden" path="ID" id="ID"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="LoginName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="LoginName" id="LoginName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="LoginName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passWord">Password</label>
                <div class="col-md-7">
                    <form:input type="passWord" path="passWord" id="passWord" class="form-control input-sm"/>
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
                <label for="enabled" class="col-md-3 control-lable">Enabled</label>
                <div class="col-md-7">
                    <select id="enabled" class="form-control">
                        <option>Enabled</option>
                        <option>Disabled</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for ="role">Role</label>
                <div class="col-md-7">
                    <form:select path="role" items="${roles}" multiple="false" itemValue="ID" itemLabel="role"  class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="role" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                    href="<c:url value='//welcome' />">Cancel</a>
            </div>
        </div>
    </form:form>

</div>

<div class="navbar nav-justified navbar-fixed-bottom">
    <jsp:include page="NavFooter.jsp"/>
</div>
</body>
</html>