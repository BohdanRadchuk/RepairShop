<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Users orders</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<div class="container">
    <table class="table table-hover ">
        <th>
            <fmt:message key="service_type"/>
        </th>
        <th>
            <fmt:message key="status"/>
        </th>
        <th>
            <fmt:message key="price"/>
        </th>
        <th>
            <fmt:message key="commentary"/>
        </th>
        <c:forEach items="${orders}" var="item">
        <tr>
            <div class="container">
                <td><c:if test="${language=='en'}">
                    ${item.typeEn}
                </c:if>
                    <c:if test="${language=='ua'}">
                        ${item.typeUa}
                    </c:if>
                </td>
                <td>${item.status}</td>
                <td>${item.price}</td>
                <td>${item.commentary}
                    <c:if test="${item.commentary==null && item.status=='DONE'}">
                        <form method="post" action="/in/user/send_comment">
                                <%--  <div class="form-group">--%>
                                <%-- <input type="text" name="commentary" id="commentary" 2500 class="form-control input-sm" placeholder="Last Name">--%>
                            <input type="hidden" name="orderId" value="${item.idOrder}">
                            <label for="comment"></label>
                            <textarea class="form-control" rows="3" cols="10"
                                      name="comment" id="comment" placeholder="Enter your commit here"
                                      required></textarea>
                            <input type="submit" value="<fmt:message key="submit"/>"
                                   class="btn btn-success btn-block">
                                <%--</div>--%>
                        </form>
                    </c:if>
                    <c:if test="${item.status =='REFUSE'}">
                        ${item.refuseReason}
                    </c:if>
                </td>
                    <%--${item.refuseReason!=null &&--%>

                    <%--<c:otherwise>
                        <td>0</td>
                    </c:otherwise>--%>

        </tr>
</div>
</c:forEach>
</table>
<div>
    <a href="/home" class="button btn-info"><fmt:message key="back"/></a>
</div>
</div>
</body>
</html>
