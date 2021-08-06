<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2021
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<li><a href="/login?action=logout">Log out</a><li>
<div class="container">
    <h2>Quản Lí Sản Phẩm Admin</h2>
    <a href="/?action=create" class="btn btn-danger">Thêm mới</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Mô Tả</th>
            <th>Hình Ảnh</th>
            <th>Phân Loại</th>
            <th>Số lượng trong kho</th>
            <th>Tình Trạng</th>
            <th>Xóa</th>
            <th>Edit</th>
        </tr>
        </thead>

        <tbody>
        <form action="/"method="post">
            <c:forEach items="${listSp}" var="sanpham" varStatus="loop">
                <tr>
                    <td>${sanpham.id}</td>
                    <td>${sanpham.ten}</td>
                    <td>${sanpham.gia}</td>
                    <td>${sanpham.mota}</td>
                    <td>${sanpham.hinhanh}</td>
                    <td>${sanpham.phanloai}</td>
                    <td>${sanpham.trongKho}</td>
                    <td>${sanpham.status}</td>
                    <td> <a href="/?action=create" class="btn btn-danger">Thêm mới</a></td>
                    <td> <a href="/?action=edit" class="btn btn-danger">Thêm mới</a></td>
                </tr>
            </c:forEach>
        </form>
        </tbody>
    </table>
</div>
</body>
</html>
