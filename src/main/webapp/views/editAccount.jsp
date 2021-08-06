<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account?action=edit" method="post">
<div class="container">
    <h2>Edit Account</h2>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>UserName</th>
            <th>PassWord</th>
            <th>Ten</th>
            <th>NgaySinh</th>
            <th>SĐT</th>
            <th>Email</th>
            <th>DiaChi</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="id" value="${account.id}" readonly></td>
            <td><input type="text" name="username" value="${account.userName}"></td>
            <td><input type="text" name="password" value="${account.passWord}"></td>
            <td><input type="text" name="ten" value="${account.ten}"></td>
            <td><input type="text" name="ngaysinh" value="${account.ngaySinh}"></td>
            <td><input type="text" name="sdt" value="${account.soDT}"></td>
            <td><input type="text" name="email" value="${account.email}"></td>
            <td><input type="text" name="diachi" value="${account.diaChi}"></td>
<%--            <td><input type="text" name="role" value="${account.role}"></td>--%>
<%--            <select name="role" value="${accout.role}">--%>
<%--                <c:forEach items="${listAcc}" var="acc">--%>
<%--                    <option value="${acc.id}">${acc.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
            <td>
                <select type="text" name="role">
                    <option value="admin">Admin</option>
                    <option value="khachhang">KhachHang</option>
                </select>
            </td>

        </tr>

        </tbody>
        <tr>
            <td>
                <button type="submit" style="color: aquamarine">Edit Account</button>
            </td>
        </tr>
    </table>
</div>
</form>
</body>
</html>
