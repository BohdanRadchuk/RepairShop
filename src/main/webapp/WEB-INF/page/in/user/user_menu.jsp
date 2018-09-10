<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>User Menu</title>
    <link href="../../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/WEB-INF/page/in/header_reg.jsp"/>
<div class="container cont-pad">
    <c:if test="${param.success == 'true'}">
        <p style="background-color:greenyellow;"><fmt:message key="order_success"/></p>
    </c:if>
    <table class="table table-hover ">
        <th><fmt:message key="serve_type"/></th>
        <th><fmt:message key="serve_price"/></th>
        <c:forEach items="${requestScope.services}" var="serve">
            <tr>
                <td><c:if test="${language=='en'}">
                   ${serve.typeEn}
                </c:if>
                    <c:if test="${language=='ua'}">
                        ${serve.typeUa}
                    </c:if>
                </td>
                <td>${serve.price}</td>
                <td>
                    <form method="post" action="/in/user/new_order">
                        <input type="hidden" id="serveId" name="serveId" value="${serve.idServe}">
                        <input type="submit" class="button btn-success" value="<fmt:message key="order"/>">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/in/user/users_orders" class="button btn-info"><fmt:message key="users_orders"/></a>
</div>
</body>
</html>
