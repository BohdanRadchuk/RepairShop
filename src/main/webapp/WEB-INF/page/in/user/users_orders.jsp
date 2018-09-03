<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Users orders</title>
    <link href="../../../../css/style.css" rel="stylesheet" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<jsp:include page="/WEB-INF/page/in/header_reg.jsp"/>

<div class="container cont-pad">
    <table id="orders" class="table table-hover ">

        <th>#</th>
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
        <c:forEach items="${orders}" var="item" varStatus="index">
            <tr>
                <td> ${index.index +1}</td>
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
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button"
                                onclick="drop()"
                                data-toggle="dropdown">Dropdown
                            <span class="caret"></span></button>

                        <form class="dropdown-menu" method="post" action="/in/user/send_comment">
                            <input type="hidden" name="orderId" value="${item.idOrder}">
                            <label for="comment"></label>
                            <textarea class="form-control" rows="5" cols="150"
                                      name="comment" id="comment" placeholder="Enter your commit here"
                            ></textarea>
                            <input type="submit" value="<fmt:message key="submit"/>"
                                   class="btn btn-success btn-block">
                        </form>
                    </div>
                    </c:if>
                    <c:if test="${item.status =='REFUSE'}">
                        ${item.refuseReason}
                    </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <a href="/home" class="button btn-info"><fmt:message key="back"/></a>
</div>
<script type="text/javascript" src="../../../../js/script.js"></script>
</body>
</html>
