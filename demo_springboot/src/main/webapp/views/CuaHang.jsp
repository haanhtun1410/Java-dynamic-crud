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
            <th>ID</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Dia Chi</th>
            <th>Thanh Pho</th>
            <th>Quoc Gia</th>
            <th>Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cuaHangList}" var="cuaHang">
            <tr>
                <td>${cuaHang.id}</td>
                <td>${cuaHang.ma}</td>
                <td>${cuaHang.ten}</td>
                <td>${cuaHang.diaChi}</td>
                <td>${cuaHang.thanhPho}</td>
                <td>${cuaHang.quocGia}</td>
                <td>
                    <a href="/CuaHang/edit/${cuaHang.id}" class="btn btn-sm btn-primary mr-2">Edit</a>
                    <!-- Button to delete brand -->
                    <a href="/CuaHang/delete/${cuaHang.id}" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/CuaHang/create">  Create new </a>

</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>