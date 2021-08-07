<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2021
  Time: 9:52 AM
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

<div class="container">
    <h2>Quản Lí Sản Phẩm Admin</h2>
    <h3>Edit Sản Phẩm </h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Mô Tả</th>
        </tr>
        <tr>
            <th>Hình Ảnh</th>
            <th>Phân Loại</th>
            <th>Nhà Phân Phối</th>
            <th>Tình Trạng</th>
        </tr>
        </thead>
        <tbody>
        <form  method="post">
            <tr>
                <td><input placeholder="Nhập Id" name="id"readonly value="${IndexEdit.id}" ></td>
                <td><input placeholder="Nhập Tên" name="ten"></td>
                <td><input placeholder="Nhập Giá" name="gia"></td>
                <td><input placeholder="Nhập Mô Tả" name="mota"></td>
            </tr>
            <tr>
                <td><input placeholder="Nhập Hình Ảnh" name="hinhanh"></td>
                <td><input placeholder="Nhập Phân Loại" name="phanloai"></td>
                <td><input placeholder="Nhập Nhà Cung Cấp" name="trongKho"></td>
                <td><input placeholder="Nhập Status" name="status"></td>
                <th>
                    <button type="submit" class="btn btn-danger">Edit</button>
                </th>
            </tr>
        </form>
        </tbody>
    </table>
</div>

</body>
</html>