<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:set var="language" value="${not empty param.language
                                        ? param.language : not empty language
                                        ? language : 'en'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="bundle"/>

<html lang="${language}">

<head>
    <meta charset="utf-8">
    <title>HomePage</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <link href="../css/header_style.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
                <li>
                    <a href="${pageContext.request.contextPath}/registration"><span
                            class="glyphicon glyphicon-user"></span>
                        <fmt:message key="register"/></a></li>
                <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>
                    <fmt:message key="login"/></a></li>
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

<div class="container">

    <div class="row centered-form">
        <c:if test="${param.success == 'true'}">
            <p style="background-color:greenyellow;"><fmt:message key="reg_success"/></p>
        </c:if>

        <h2><fmt:message key="greetings"/></h2>
    </div>
</div>
</body>
</html>
