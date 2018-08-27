<%@ include file="util/init.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
    <link href="..//css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/header_unreg.jsp"/>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><fmt:message key="login_user"/></h3>
                </div>
                <div class="panel-body">
                    <form method="post" action="/login_confirm">

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-sm"
                                   placeholder="Password">
                        </div>
                        <input type="submit" value="<fmt:message key="login"/>" class="btn btn-info btn-block">
                        <a href="/home" class="btn btn-info btn-block"><fmt:message key="back"/></a>
                    </form>

                    <c:if test="${param.err != null}">
                        <c:if test="${param.err == 'email'}">
                            <fmt:message key="err_email"/>
                        </c:if>
                        <c:if test="${param.err == 'pass'}">
                            <fmt:message key="err_pass"/>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
