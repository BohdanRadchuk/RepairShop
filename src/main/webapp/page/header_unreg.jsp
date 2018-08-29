<%@include file="util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <link href="../css/header_style.css" rel="stylesheet" type="text/css">
    <title>header</title>
</head>
<body>

<div class="menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="../image/logo.png">
            <a href="/home"><fmt:message key="repair_shop"/></a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="registration"><span class="glyphicon glyphicon-user"></span>
                    <fmt:message key="register"/></a></li>
                <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="login"/></a></li>
                <li>
                    <form>
                        <div class="mt-5">
                            <input name="language" type="image" value="en"
                            ${language=='en' ? 'selected' : '' } src="../image/flag_en.png"
                                   style="height: 24px; width: 32px; margin: 8px 0 0 0;">
                            <input name="language" type="image" value="ua"
                            ${language=='ua' ? 'selected' : '' } src="../image/flag_ua.png"
                                   style="height: 24px; width: 32px; margin: 8px 0 0 0;">
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
