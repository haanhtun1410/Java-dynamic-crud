<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>KhachHang List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Add KhachHang</h2>

    <form:form action="/khach-hang/update/${id}" method="POST" modelAttribute="khachHang">
        <div class="form-group">
            <label for="ma">Ma:</label>
            <form:errors path="ma"></form:errors>
            <form:input path="ma" id="ma" class="form-control" />
        </div>
        <div class="form-group">
            <label for="ten">Ten:</label>
            <form:input path="ten" id="ten" class="form-control" />
        </div>
        <div class="form-group">
            <label for="ngaySinh">Ngay Sinh:</label>
            <input type="date" name="date" id="ngaySinh" value="${date2}" class="form-control" />
        </div>
        <div class="form-group">
            <label for="sdt">SDT:</label>
            <form:input path="sdt" id="sdt" class="form-control" />
        </div>
        <div class="form-group">
            <label for="diaChi">Dia Chi:</label>
            <form:input path="diaChi" id="diaChi" class="form-control" />
        </div>
        <div class="form-group">
            <label for="thanhPho">Thanh Pho:</label>
            <form:input path="thanhPho" id="thanhPho" class="form-control" />
        </div>
        <div class="form-group">
            <label for="quocGia">Quoc Gia:</label>
            <form:input path="quocGia" id="quocGia" class="form-control" />
        </div>
        <div class="form-group">
            <label for="matKhau">Mat Khau:</label>
            <form:input path="matKhau" id="matKhau" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>