<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>UsersMenu</title>
    <link href="../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../css/admin.css" rel="stylesheet" type="text/css">

    <link href="../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="/page/in/header_reg.jsp"/>
<jsp:include page="/page/in/admin/admin_side_panel.jsp"/>
<div class="container">

    <div class="table">
        <c:forEach items="${users}" var="item">
            <div class="tr">
                <form method="post" action="/in/admin/user_update">
                    <span class="td"><input type="text" name="id" placeholder="id" value="${item.id}" readonly></span>
                    <span class="td"><input type="text" name="name" placeholder="name" value="${item.name}"></span>
                    <span class="td"><input type="text" name="surname" placeholder="surname"
                                            value="${item.surname}"></span>
                    <span class="td"><input type="email" name="email" placeholder="email" value="${item.email}"></span>
                    <span class="td"><input type="text" name="password" placeholder="password"
                                            value="${item.password}"></span>
                    <span class="td"><select name="role">
                    <option value="${item.role}">${item.role}</option>
                        <option value="USER">USER</option>
                        <option value="MANAGER">MANAGER</option>
                        <option value="MASTER">MASTER</option>
                        <option value="ADMIN">ADMIN</option>
                    </select></span>
                    <span class="td"><input type="submit" value="<fmt:message key="edit"/>"
                                            class="btn btn-info btn-block">   </span>

                </form>
                <span class="td"><form method="post" action="/in/admin/user_delete">
                <input type="hidden" name="id_delete" value="${item.id}"/>
                    <span class="td"><input type="submit" value="<fmt:message key="delete"/>" class="btn btn-danger btn-block"></span>
                </form></span>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
