<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/account?action=create" method="post">
    <div class="container">
        <h2>Đăng Ký Tài Khoản</h2>
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
                <td><input type="text" name="username" placeholder="Nhap UserName"></td>
                <td><input type="text" name="password" placeholder="Nhap PassWord"></td>
                <td><input type="text" name="ten" placeholder="Nhap Ten"></td>
                <td><input type="text" name="ngaysinh" placeholder="Nhap NgaySinh"></td>
                <td><input type="text" name="sdt" placeholder="Nhap SDT"></td>
                <td><input type="email" name="email" placeholder="Nhap Email"></td>
                <td><input type="text" name="diachi" placeholder="Nhap DiaChi"></td>
            </tr>

            </tbody>
            <tr>
                <td>
                    <button type="submit" style="color: aquamarine">Đăng Ký Tài Khoản</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
