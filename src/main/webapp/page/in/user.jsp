<%@ include file="../util/init.jsp"%>

<html>
<head>
    <meta charset="utf-8">
    <title>User Menu</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/header_reg.jsp"/>

<c:forEach items="${sessionScope.userEmail} " var="item"  >
    ${item}
</c:forEach>
<%--<c:out value="${sessionScope.role}"></c:out>--%>

<div class="container">
<c:forEach items="${applicationScope['logged_email']} " var="item"  >
<table>
    <tr>
    ${item}
    </tr>
</table>
</c:forEach>
</div>



hi user
</body>
</html>
