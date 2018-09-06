<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Manager Menu</title>
    <link href="../../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/WEB-INF/page/in/header_reg.jsp"/>

<div class="container cont-pad">

    <c:if test="${param.err == 'price'}">
        <p style="background-color:Tomato;"><fmt:message key="err_price"/></p>
    </c:if>

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

                        <input type="text" name="price" placeholder="Price" required>

                        <input type="submit" value="<fmt:message key="confirm"/>" class="btn btn-success">

                    </form>
                </td>
                <td>
                    <form method="post" action="/in/manager/refuse">

                        <input type="hidden" name="orderId" value="${item.idOrder}">

                        <input type="text" name="reason" placeholder="Reason" required>

                        <input type="submit" value="<fmt:message key="refuse"/>" class="btn btn-danger">

                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

<nav aria-label="Navigation for countries">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="/in/manager/manager_menu?currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/in/manager/manager_menu?currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="/in/manager/manager_menu?currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>

<script src="../../../../js/jquery-3.1.1.slim.min.js"></script>
<script src="../../../../js/tether.min.js"></script>
<script src="../../../../js/bootstrap.min.js"></script>


</body>
</html>