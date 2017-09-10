<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: simd0922
  Date: 08/09/2017
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form commandName="event">
    <form:errors path="*" cssClass="errorBlock" element="div"/>
    <label for="textinput1">enter minutes </label>
    <form:input path="name" cssErrorClass="error"/>
    <form:errors path="name" cssErrorClass="error"/>
    <br>
    <input type="submit" class="btn" value="Enter event">


</form:form>
</body>
</html>
