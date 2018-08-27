<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>New Order</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<%--
<c:forEach items="${sessionScope.userEmail}" var="itemSession">
    ${itemSession}
</c:forEach>--%>
<%--<c:out value="${sessionScope.role}"></c:out>--%>

<div class="container">
    <%-- <c:forEach items="${applicationScope['logged_email']}" var="itemLogged">
         <table>
             <tr>
                     ${itemLogged}
             </tr>
         </table>
     </c:forEach>
 --%>

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

    <%-- <td>
                  <form method="post" action="/neworder">
                      <input type="hidden" id="orderId" name="orderId" value="${serve.idServe}">--%>
    <%-- <td> <a href="/neworder?o=${serve.idServe}">${serve.typeEn}</a></td>--%>
    <%--  <td>--%>


    <%--    <td>${serve.typeUa}</td>
        <td></td>
 --%>

</div>

</body>
</html>
