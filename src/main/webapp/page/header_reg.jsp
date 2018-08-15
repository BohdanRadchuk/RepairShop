<%@include file="util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <link href="../css/header_unreg_style.css" rel="stylesheet" type="text/css">
    <title>header</title>
</head>
<body>
<div class="menu">
    <div class="container-fluid">
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> <fmt:message key="logout"/></a></li>
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
