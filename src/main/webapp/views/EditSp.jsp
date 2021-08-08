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
    <form  method="post">
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <td><input placeholder="Nhập Id" name="id"readonly value="${edit.id}" ></td>
        </tr>
        <tr>
            <th>Tên Sản Phẩm</th>
            <td><input placeholder="Nhập Tên" name="ten" value="${edit.ten}"></td>
        </tr>
        <tr>
            <th>Giá</th>
            <td><input placeholder="Nhập Giá" name="gia" value="${edit.gia}"></td>
        </tr>
        <tr>
            <th>Mô Tả</th>
            <td><textarea placeholder="Nhập Mô Tả" name="mota" value="${edit.mota}"></textarea></td>
        </tr>
        <tr>
            <th>Hình Ảnh</th>
            <td><input placeholder="Nhập Hình Ảnh" name="hinhanh" value="${edit.hinhanh}"></td>
        </tr>
        <tr>
            <th>Phân Loại</th>
            <td><select name="phanloai" >
                <option value="1">Đồ gia dụng</option>
                <option value="2">Đồ điện tử</option>
                <option value="3">Sách</option>
                <option value="4">Quần áo</option>
                <option value="5">Khác</option>
            </select>
        </tr>
        <tr>
            <th>Số lượng</th>
            <td><input placeholder="Số lượng" name="trongKho" value="${edit.trongKho}"></td>
        </tr>
        <tr>
            <button type="submit" class="btn btn-danger">Edit</button>
        </tr>
    </table>
    </form>
</div>

</body>
</html>