<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Manager Menu</title>
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

        <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.idOrder}</td>
            <td>${item.idUser}</td>
            <td>${item.idServe}</td>
            <td>${item.status}
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
        <%-- <td><c:if test="${language=='en'}">
             ${item.typeEn}
         </c:if>
             <c:if test="${language=='ua'}">
                 ${item.typeUa}
             </c:if>
         </td>
         </td>--%>

        <%-- <c:if test="${item!=null}">
    </c:if>--%>


        <%-- <td>${item.commentary}
             <c:if test="${item.commentary==null && item.status=='DONE'}">

                 <form method="post" action="/in/user/send_comment">
                         &lt;%&ndash;  <div class="form-group">&ndash;%&gt;
                         &lt;%&ndash; <input type="text" name="commentary" id="commentary" 2500 class="form-control input-sm" placeholder="Last Name">&ndash;%&gt;
                     <input type="hidden" name="orderId" value="${item.idOrder}">
                     <label for="comment"></label>
                     <textarea class="form-control" rows="3" cols="10"
                               name="comment" id="comment" placeholder="Enter your commit here"
                               required></textarea>
                     <input type="submit" value="<fmt:message key="submit"/>"
                            class="btn btn-success btn-block">
                         &lt;%&ndash;</div>&ndash;%&gt;
                 </form>
             </c:if>
         </td>--%>

</body>
</html>