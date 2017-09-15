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

<form:form commandName="Login">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <label for="textInput1">Enter User name</label>
    <form:input path="username" cssErrorClass="error"/>
    <form:errors path="username" cssClass="error"/>

    <br>
    <label for="textInput2">Enter User name</label>
    <form:input path="password" cssErrorClass="error"/>
    <form:errors path="password" cssClass="error"/>
    <br>
    <input type="submit" class="btn" value="Enter for logining">
</form:form>


</body>
</html>