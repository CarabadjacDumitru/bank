<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
    <title>Admin Page</title>
</head>
<body>

<h2>Admin Page</h2>


<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>

<b>This is protected page!</b>
</body>
</html>