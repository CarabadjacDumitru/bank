<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>

<html>
<head>

</head>
<body>
<h1>Spring MVC Internationalization i18n Example</h1>

Language : <a href="?lang=en">English</a> | <a href="?lang=fr">French</a>

<form method="post" action="login">
    <table>
        <tr>
            <td><label> <strong><spring:message
                    code="label.firstName" /></strong>
            </label></td>
            <td><input name="firstName" /></td>
        </tr>
        <tr>
            <td><label> <strong><spring:message
                    code="label.lastName" /></strong>
            </label></td>
            <td><input name="lastName" /></td>
        </tr>
        <tr>
            <spring:message code="label.submit" var="labelSubmit"></spring:message>
            <td colspan="2"><input type="submit" value="${labelSubmit}" /></td>
        </tr>
    </table>
</form>
</body>
</html>