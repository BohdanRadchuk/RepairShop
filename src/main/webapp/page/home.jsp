<%@ include file="util/init.jsp"%>
<%--


<c:set var="language" value="${not empty param.language ? param.language : not empty sessionScope.language ?
        sessionScope.language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="bundle"/>
--%>
<html lang="${language}">

<head>
    <meta charset="utf-8">
    <title>HomePage</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/header_unreg.jsp"/>

<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <a href="registration" class="button btn-info"><fmt:message key="register"/></a>
            <table class="centered-form">
                <th> <li class="breadcrumb-item active" aria-current="page"></li>№</th>
                <th>WELCOME TO WATCH REPAIR</th>
            </table>
            <h2>Hello World!</h2>
        </div></div></div>
</body>
</html>
