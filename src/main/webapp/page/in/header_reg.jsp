<%@include file="../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <link href="../../css/header_style.css" rel="stylesheet" type="text/css">
    <title>header</title>
</head>
<body>
<div class="menu">
    <div class="container-fluid">
        <div> <c:if test="${param.logged == true}">
            <fmt:message key="err_email"/>
        </c:if>
        </div>
        <div class="navbar-header">
            <a href="/home"><fmt:message key="repair_shop"/></a>
        </div>

        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> <fmt:message key="logout"/></a></li>
                <%--  <li>
                <form>
                       <input name="language" type="image" value="en"
                       ${language=='en' ? 'selected' : '' } src = "../../image/flag_en.png" style="height: 24px; width: 32px;">
                       <input name="language" type="image" value="ua"
                       ${language=='ua' ? 'selected' : '' } src = "../../image/flag_ua.png" style="height: 24px; width: 32px;">
                   </form>--%>
                    <%--
                    <form>
                        <select id="language" name="language" onchange="submit()">
                            <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message
                                    key="lang.en"/></option>
                            <option value="ua" ${language == 'ua' ? 'selected' : ''}><fmt:message
                                    key="lang.ua"/></option>
                        </select>
                    </form>
                </li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
