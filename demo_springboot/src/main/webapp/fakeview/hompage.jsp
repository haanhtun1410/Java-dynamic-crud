<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>KhachHang List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>KhachHang List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Ngay Sinh</th>
            <th>Dia Chi</th>
            <th>Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${classList}" var="khachHang">
            <tr>
                <td>${khachHang.ma}</td>
                <td>${khachHang.ten}</td>
                <td>${khachHang.ngaySinh}</td>
                <td>${khachHang.sdt}</td>
                <td>${khachHang.diaChi}</td>
                <td>
                    <a href="/khach-hang/edit/${khachHang.id}" class="btn btn-sm btn-primary mr-2">Edit</a>
                    <!-- Button to delete customer -->
                    <a href="/khach-hang/delete/${khachHang.id}" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/khach-hang/create">Create new</a>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
