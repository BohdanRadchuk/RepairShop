<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Users orders</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../script/script.js" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<div class="container">
    <h3>Tabs With Dropdown Menu</h3>
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Submenu 1-1</a></li>
                <li><a href="#">Submenu 1-2</a></li>
                <li><a href="#">Submenu 1-3</a></li>
            </ul>
        </li>
        <li><a href="#">Menu 2</a></li>
        <li><a href="#">Menu 3</a></li>
    </ul>
</div>

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
                <td>
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" id="drop${item.idOrder}" onclick="drop()"
                                data-toggle="dropdown">Dropdown
                            <span class="caret"></span></button>

                        <form class="dropdown-menu" method="post" action="/in/user/send_comment">
                            <input type="hidden" name="orderId" value="${item.idOrder}">
                            <label for="comment"></label>
                            <textarea class="form-control" rows="3" cols="10"
                                      name="comment" id="comment" placeholder="Enter your commit here"
                                      required></textarea>
                            <input type="submit" value="<fmt:message key="submit"/>"
                                   class="btn btn-success btn-block">
                                <%--  <ul >
                                      <li><a href="#">HTML</a></li>
                                      <li><a href="#">CSS</a></li>
                                      <li><a href="#">JavaScript</a></li>
                                  </ul>--%>
                    </div>
                </td>
                    <%--<script>
                                        $(document).ready(function(){
                                            $(".dropdown").on("hide.bs.dropdown", function(){
                                                $(".btn").html('Dropdown <span class="caret"></span>');
                                            });
                                            $(".dropdown").on("show.bs.dropdown", function(){
                                                $(".btn").html('Dropdown <span class="caret caret-up"></span>');
                                            });
                                        });
                                    </script>--%>
                    <%--
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
                    </form>--%>
                </c:if>
                <c:if test="${item.status =='REFUSE'}">
                    ${item.refuseReason}
                </c:if>
            </div>
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
