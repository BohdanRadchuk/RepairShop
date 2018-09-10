<%@ include file="../../util/init.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>AdminUsersMenu</title>
    <link href="../../../../css/style.css" rel="stylesheet" type="text/css">
    <link href="../../../../css/admin.css" rel="stylesheet" type="text/css">
    <link href="../../../../css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<jsp:include page="../header_reg.jsp"/>
<jsp:include page="admin_side_panel.jsp"/>


<div class="container cont-pad">
    <div class="row">
        <table>
            <c:forEach items="${users}" var="item">
                <tr>
                    <form class="admin_form" method="post" action="/in/admin/user_update">
                        <input type="hidden" name="id" placeholder="id" value="${item.id}">
                        <td>${item.id}</td>
                        <td><input type="text" name="name" placeholder="name" value="${item.name}"></td>
                        <td><input type="text" name="surname" placeholder="surname" value="${item.surname}">
                        </td>
                        <td><input type="email" name="email" placeholder="email" value="${item.email}"></td>
                        <td><input type="text" name="password" placeholder="password"
                                   value="${item.password}"></td>
                        <td><select name="role">
                            <option value="${item.role}">${item.role}</option>
                            <option value="USER">USER</option>
                            <option value="MANAGER">MANAGER</option>
                            <option value="MASTER">MASTER</option>
                            <option value="ADMIN">ADMIN</option>
                        </select></td>
                        <td><input type="submit" value="<fmt:message key="edit"/>"
                                   class="btn btn-info btn-block"></td>
                    </form>
                    <form method="post" action="/in/admin/user_delete">
                        <input type="hidden" name="id_delete" value="${item.id}"/>
                        <td><input type="submit" value="<fmt:message key="delete"/>"
                                   class="btn btn-danger btn-block"></td>
                    </form>

                </tr>

            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
