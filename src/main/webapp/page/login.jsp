<%@ include file="util/init.jsp" %>


<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
    <link href="..//css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/header_reg.jsp"/>


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
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm"
                                           placeholder="Password">
                                </div>
                            </div>
                        </div>
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
