<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link href="<c:url value='/static/css/navbar.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap-theme.min.css' />" rel="stylesheet"></link>
</head>
<header>
    <jsp:include page="NavHeader.jsp">
        <jsp:param name="param1" value="${loggedinuser}"/>
    </jsp:include>
</header>

<body>
<script type="text/javascript" src='<c:url value="/static/js/jquery-3.2.1.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/static/js/bootstrap.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/static/js/navbar.js"/>'></script>
<<!--<script type="text/javascript" src='<c: url value="/sta tic/js/menu.js"/>'></script>-->

<div class="container">
    <div class="col-md-5">
        <div class="form-area">
            <form role="form"><br style="clear:both"/>
                <h3 style="margin-bottom: 25px; text-align: center">Contact Form</h3>
                <div class="form-group">
                    <input class="form-control" id="name" type="text" name="name" placeholder="Name" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="email" type="text" name="email" placeholder="Email" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="mobile" type="text" name="mobile" placeholder="Mobile Number" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="subject" type="text" name="subject" placeholder="Subject" required=""/>
                </div>
                <div class="form-group">
                    <textarea class="form-control" id="message" type="textarea" placeholder="Message" maxlength="140" rows="7"></textarea><span class="help-block">
            <p class="help-block" id="characterLeft">0 Left</p></span>
                </div>
                <button class="btn btn-primary pull-right" id="submit" type="button" name="submit">Submit Form</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>