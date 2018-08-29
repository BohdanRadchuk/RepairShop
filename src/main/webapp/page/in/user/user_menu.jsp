<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>User Menu</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<div class="container">
    <table class="table table-hover ">
        <th><fmt:message key="serve_type"/></th>
        <th><fmt:message key="serve_price"/></th>
        <c:forEach items="${requestScope.services}" var="serve">
        <div class="container">
            <tr>
                <td>
                    <form method="post" action="/in/user/new_order">
                        <input type="hidden" id="serveId" name="serveId" value="${serve.idServe}">
                        <c:if test="${language=='en'}">
                            <input type="submit" class="button btn-success" value="${serve.typeEn}">
                        </c:if>
                        <c:if test="${language=='ua'}">
                            <input type="submit" class="button btn-success" value="${serve.typeUa}">
                        </c:if>
                    </form>
                </td>
                <td>${serve.price}</td>
            </tr>
            </c:forEach>
        </div>
    </table>
    <a href="/in/user/users_orders" class="button btn-info"><fmt:message key="users_orders"/></a>
</div>
</body>
</html>
