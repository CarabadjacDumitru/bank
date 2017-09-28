<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

<title>Login</title>

<header>
    <jsp:include page="NavBar.jsp"/>
</header>


<div class="container">

    <div class="row" style="margin-top:60px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form method="post" modelAttribute="login" action="/loginProcess"  class="form-signin"  >
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p>Invalid username and password.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p>You have been logged out successfully.</p>
                    </div>
                </c:if>
                <fieldset>
                    <h2>Please Sign In</h2>
                    <hr class="colorgraph">

                    <div class="form-group">
                        <input type="password" name="ssoId" id="email" class="form-control input-lg"
                               placeholder="enter Email Address" required>
                    </div>

                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg"
                               placeholder="Password" required>
                    </div>


                    <span class="button-checkbox">
					    <button type="button" class="btn" data-color="info">Remember Me</button>

                        <input type="checkbox" id="rememberme" name="remember-me" checked="checked" class="hidden">
					    <a href="" class="btn btn-link pull-right">Forgot Password?</a>
				    </span>
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <a href="/register/" class="btn btn-lg btn-primary btn-block">Register</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

</div>

<div class="navbar    nav-justified navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
