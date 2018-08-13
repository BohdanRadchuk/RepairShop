<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="bundle"/>
<html lang="${language}">

<head>
    <meta charset="utf-8">
    <title>HomePage</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="lang.en"/></option>
        <option value="ua" ${language == 'ua' ? 'selected' : ''}><fmt:message key="lang.ua"/></option>

    </select>
</form>

<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <a href="registration" class="button btn-info"><fmt:message key="register"/></a>
            <table class="centered-form">
                <th> <li class="breadcrumb-item active" aria-current="page"></li>№</th>
                <th>услуга</th>
                <th>цена</th>

                <th>button select</th>
            </table>
            <h2>Hello World!</h2>
        </div></div></div>
</body>
</html>
