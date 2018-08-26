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

<c:forEach items="${sessionScope.userEmail}" var="itemSession">
    ${itemSession}
</c:forEach>
<%--<c:out value="${sessionScope.role}"></c:out>--%>

<div class="container">
    <c:forEach items="${applicationScope['logged_email']}" var="itemLogged">
        <table>
            <tr>
                    ${itemLogged}
            </tr>
        </table>
    </c:forEach>

    <table class="table table-hover ">
        <th><fmt:message key="serve_type"/></th>
      <%--  <th><fmt:message key="serve_description"/></th>--%>
        <th><fmt:message key="serve_price"/></th>
        <c:forEach items="${requestScope.services}" var="serve">
        <div class="container">
            <tr>
                <td>
                    <form method="post" action="/in/user/new_order">
                        <input type="hidden" id="serveId" name="serveId" value="${serve.idServe}">
                        <c:if test="${language=='en'}">
                        <input type="submit" value="${serve.typeEn}">
                        </c:if>
                        <c:if test="${language=='ua'}">
                        <input type="submit" value="${serve.typeUa}">
                        </c:if>
                    </form>

                </td>
                    <%-- <td>
                                  <form method="post" action="/neworder">
                                      <input type="hidden" id="orderId" name="orderId" value="${serve.idServe}">--%>
                    <%-- <td> <a href="/neworder?o=${serve.idServe}">${serve.typeEn}</a></td>--%>
                    <%--  <td>${serve.descriptionEn}</td>--%>


                <%--    <td>${serve.typeUa}</td>
                    <td>${serve.descriptionUa}</td>
             --%>
                <td>${serve.price}</td>
            </tr>
            </c:forEach>

    </table>
</div>

hi user
</body>
</html>
