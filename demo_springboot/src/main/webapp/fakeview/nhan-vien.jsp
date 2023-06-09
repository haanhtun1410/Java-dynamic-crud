<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>CuaHang List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>CuaHang List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Gioi Tinh</th>
            <th>Ngay Sinh</th>
            <th>Dia Chi</th>
            <th>SDT</th>
            <th>Mat Khau</th>
            <th>Trang Thai</th>
            <th>Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nhanVienList}" var="nhanVienTEST">
            <tr>
                <td>${nhanVienTEST.ma}</td>
                <td>${nhanVienTEST.ten}</td>
                <td>${nhanVienTEST.gioiTinh}</td>
                <td>${nhanVienTEST.ngaySinh}</td>
                <td>${nhanVienTEST.diaChi}</td>
                <td>${nhanVienTEST.sdt}</td>
                <td>${nhanVienTEST.matKhau}</td>
                <td>${nhanVienTEST.trangThai}</td>
                <td>
                    <a href="/nhan-vien/edit/${nhanVienTEST.id}" class="btn btn-sm btn-primary mr-2">Edit</a>
                    <!-- Button to delete brand -->
                    <a href="/nhan-vien/delete/${nhanVienTEST.id}" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/nhan-vien/create">  Create new </a>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>