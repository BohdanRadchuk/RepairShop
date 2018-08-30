<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>New Order</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<div class="container">
    <c:if test="${language=='en'}">
        ${service_description.descriptionEn}
    </c:if>

    <c:if test="${language=='ua'}">
        ${service_description.descriptionUa}
    </c:if>
    <form method="post" action="/in/user/new_order_confirm">
        <input type="hidden" id="serveId" name="serveId" value="${service_description.idServe}">
        <input type="submit" class="button btn-success" value="<fmt:message key="send_order"/>">
    </form>
    <a href="/home" class="button btn-info"><fmt:message key="back"/></a>
</div>
</body>
</html>
