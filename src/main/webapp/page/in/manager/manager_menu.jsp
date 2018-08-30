<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Manager Menu</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<c:if test="${param.err == 'price'}">
    <p style="background-color:Tomato;"><fmt:message key="err_price"/></p>
</c:if>
<div class="container">
    <table class="table table-hover ">
        <th>
            <fmt:message key="id_order"/>
        </th>
        <th>
            <fmt:message key="id_user"/>
        </th>
        <th>
            <fmt:message key="service_type"/>
        </th>
        <th>
            <fmt:message key="status"/>
        </th>

        <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.idOrder}</td>
            <td>${item.idUser}</td>
            <td><c:if test="${language=='en'}">
                ${item.typeEn}
            </c:if>
                <c:if test="${language=='ua'}">
                    ${item.typeUa}
                </c:if>
            </td>
            <td>${item.status}</td>
            <td>${item.price}</td>

            <td>
                <form method="post" action="/in/manager/confirm">

                    <input type="hidden" name="orderId" value="${item.idOrder}">

                    <input type="text" name="price" placeholder="Price">
                    <input type="submit" value="<fmt:message key="confirm"/>" class="btn btn-success">

                </form>
            </td>
            <td>
                <form method="post" action="/in/manager/refuse">

                    <input type="hidden" name="orderId" value="${item.idOrder}">

                    <input type="text" name="reason" placeholder="Reason">
                    <input type="submit" value="<fmt:message key="refuse"/>" class="btn btn-danger">

                </form>
            </td>
                    <%--<div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <button class="dropdown-item" type="button">Action</button>
                        <button class="dropdown-item" type="button">Another action</button>
                        <button class="dropdown-item" type="button">Something else here</button>
                    </div>
                </div>
    --%>
        </tr>
        </c:forEach>

</body>
</html>