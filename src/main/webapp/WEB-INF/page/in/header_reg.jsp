<%@include file="../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <link href="../../../css/header_style.css" rel="stylesheet" type="text/css">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <title>header</title>
</head>
<body>
<div class="menu navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="../../../image/logo.png">
            <a href="/home"><fmt:message key="repair_shop"/></a>
        </div>

        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> <fmt:message key="logout"/></a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
