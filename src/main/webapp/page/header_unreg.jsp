<%@include file="util/init.jsp" %>

<html>
<head>
    <link href="..//css/header_unreg_style.css" rel="stylesheet" type="text/css">
    <title>header</title>
</head>
<body>
<div class="menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/"><fmt:message key="repair_shop"/></a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">

                <li><a href="registration"><span class="glyphicon glyphicon-user"></span>
                    <fmt:message key="register"/></a></li>
                <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="login"/></a></li>
                <li>
                    <form>
                        <select id="language" name="language" onchange="submit()">
                            <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message
                                    key="lang.en"/></option>
                            <option value="ua" ${language == 'ua' ? 'selected' : ''}><fmt:message
                                    key="lang.ua"/></option>
                        </select>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
