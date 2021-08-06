<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ShowNhanVien</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-dark">
    <thread>
    <tr style="background-color: blue">
        <th>Id</th>
        <th>UserName</th>
        <th>PassWord</th>
        <th>Ten</th>
        <th>NgaySinh</th>
        <th>Số ĐT</th>
        <th>Email</th>
        <th>Địa Chỉ</th>
        <th>Role</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    </thread>
    <c:forEach items="${listAcc}" var="acc" varStatus="loop">
        <tr>
            <td>${acc.id}</td>
            <td>${acc.userName}</td>
                <%--Nếu birthday viết thường là lỗi--%>
            <td>${acc.passWord}</td>
            <td>${acc.ten}</td>
            <td>${acc.ngaySinh}</td>
            <td>${acc.soDT}</td>
            <td>${acc.email}</td>
            <td>${acc.diaChi}</td>
            <td>${acc.role}</td>
                <%--Button thì k chuyển hướng được nên phải dùng thẻ a--%>
            <td><a href="/account?action=edit&index=${loop.index}">Edit</a></td>
            <td><a href="/account?action=delete&id=${acc.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/views/homepage.jsp" class="cancelbtn" style="border: #04AA6D" >Home Page</a>
</body>
</html>
