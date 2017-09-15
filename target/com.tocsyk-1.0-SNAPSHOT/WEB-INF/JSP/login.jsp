<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

    <title>Login</title>
</head>
<body>
<jsp:include page="menu.jsp"/>


<h1>Login</h1>

<!-- /login?error=true -->
<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login Failed!!!<br/>
        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>
<h2>Login with Username and Password</h2>

<h3>Enter user name and password:</h3>
<div id="login-box">
    <form:form id = "regForm" modelAttribute="login" action="loginProcess" method="post">
        <form:errors path="*" cssClass="errorblock" element="div"/>
        <label for="Login.label.user">Enter User name</label>
        <form:errors path="Login.label.username" cssClass="error"/>

        <br>
        <label for="textInput2">Enter User name</label>
        <form:input path="Login.label.password" cssErrorClass="error"/>
        <form:errors path="Login.label.password" cssClass="error"/>
        <br>
        <input type="submit" class="btn" value="Enter for logining">
    </form:form>
</div>


<form method="post" action="">
    <table>
        <tr>
            <td>
                <strong>
                    <spring:message code="Login.label.user"/>
                </strong>
            </td>
            <td><input name="userName"/></td>
        </tr>
        <tr>
            <td>
                <strong>
                    <spring:message code="Login.label.password"/>
                </strong>
            </td>
            <td><input name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <spring:message code="Label.submit" var="labelSubmit"></spring:message>
                <input type="submit" value="${labelSubmit}"/>
            </td>
        </tr>
    </table>
</form>

<input type="hidden" name="${_csrf.parameterName}"
       value="${_csrf.token}"/>

</form>
</div>


</body>
</html>