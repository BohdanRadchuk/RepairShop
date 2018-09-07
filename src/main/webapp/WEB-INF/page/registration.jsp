<%@ include file="util/init.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/WEB-INF/page/header_unreg.jsp"/>

<div class="container cont-pad">
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
                                           class="form-control input-sm floatlabel" placeholder="First Name"
                                           required title="<fmt:message key="regex_name"/>">
                                </div>

                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-sm"
                                           placeholder="Last Name"  required title="<fmt:message key="regex_name"/>">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address" required>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm"
                                           placeholder="Password"
                                           required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"
                                           title="<fmt:message key="regex_password"/>">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation"
                                           class="form-control input-sm" placeholder="Confirm Password"
                                           required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"
                                           title="<fmt:message key="regex_password"/>">
                                </div>
                            </div>
                        </div>
                        <c:if test="${param.err == 'pass'}">
                            <p style="background-color:Tomato;"><fmt:message key="err_pass_mismatch"/></p>
                        </c:if>
                        <c:if test="${param.err == 'login'}">
                            <p style="background-color:Tomato;"><fmt:message key="err_email_exist"/></p>
                        </c:if>
                        <c:if test="${param.err == 'regex'}">
                            <p style="background-color:Tomato;"><fmt:message key="regex_name"/></p>
                        </c:if>
                        <input class="btn btn-info btn-block" type="submit" value=
                        <fmt:message key="register"/> >
                        <a href="/home" class="btn btn-info btn-block"><fmt:message key="back"/></a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
