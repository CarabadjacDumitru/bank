<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@page session="true"%>
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

</head>
<body>
<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top" navbar-toggleable-md="md">
            <div class="container">
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/" class="">Home</a></li>
                        <!--   HOME    -->

                        <li class=" dropdown">
                            <!--   BANK    -->
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Banks <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">View Banks</a>
                                </li>
                                <li><a href="#">Add New Bank</a></li>
                            </ul>
                        </li>

                        <li class=" dropdown">
                            <!--   Branches    -->
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Branches <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">View Branches</a>
                                </li>
                                <li><a href="#">Add New Branch</a></li>
                            </ul>
                        </li>

                        <li class=" dropdown">
                            <!--   Customer    -->
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Customers <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">View Customers</a>
                                </li>
                                <li><a href="#">Add New Customer</a></li>
                            </ul>
                        </li>

                        <li class=" dropdown">
                            <!--   Contracts    -->
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Contract <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">View Contract</a>
                                </li>
                                <li><a href="#">Add New Contract</a></li>
                            </ul>
                        </li>

                    </ul>


                        <ul class="nav navbar-nav pull-right">
                            <li class=""><a href="login">Log in</a></li>
                            <li class=""><a href="register">Register</a></li>
                        </ul>


                        <ul class="nav navbar-nav pull-right">

                            <li class=" dropdown">
                                <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">Signed in as<span class="caret"/>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="LoginModify">Change Password</a></li>
                                    <li><a href="userInfo">My Profile</a></li>
                                </ul>
                            </li>
                            <li class=""><a href="logout">Log Out</a></li>
                        </ul>

                </div>
            </div>
        </nav>
    </div>
</div>
</body>
</html>