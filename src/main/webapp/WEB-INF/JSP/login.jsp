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

<h3>Enter user name and password:</h3>

<form:form method="POST" commandName="">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <spring:message code="login.label.User" />
            <td>Username :</td>
            <td><form:input path="userName" />

            </td>
        </tr>
        <tr>
            <spring:message code="login.label.PassWord" />
            <td>Username :</td>
            <td><form:input path="password" />
            <td colspan="3"><input type="submit" />
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>