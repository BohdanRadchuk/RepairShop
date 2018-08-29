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
                    <h3 class="panel-title"><fmt:message key="create_user"/></h3>
                </div>
                <div class="panel-body">
                    <form method="post" action="/registration_confirm">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name"
                                           class="form-control input-sm floatlabel" required placeholder="First Name">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-sm"
                                           placeholder="Last Name">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address">
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm"
                                           placeholder="Password">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation"
                                           class="form-control input-sm" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>
                        <c:if test="${param.err == 'pass'}">
                            <p style="background-color:Tomato;"><fmt:message key="err_pass_mismatch"/></p>
                        </c:if>
                        <c:if test="${param.err == 'login'}">
                            <p style="background-color:Tomato;"><fmt:message key="err_email_exist"/></p>
                        </c:if>
                        <input type="submit" value="Register" class="btn btn-info btn-block">
                        <a href="/home" class="btn btn-info btn-block">Back</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
