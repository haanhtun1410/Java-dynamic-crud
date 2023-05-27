<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <title>NhanVien List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Edit NhanVien</h2>
    <%--@elvariable id="nhanVienTEST" type=""--%>
    <form:form action="/nhan-vien/add" method="POST" modelAttribute="nhanVienTEST">
        <div class="form-group">
            <label for="ma">Ma:</label>
            <form:input path="ma" id="ma" class="form-control" />
            <form:errors path="ma"/>
        </div>
        <div class="form-group">
            <label for="ten">Ten:</label>
            <form:input path="ten" id="ten" class="form-control" />
        </div>
        <div class="form-group">
            <label for="gioiTinh">Gioi Tinh:</label>
            <form:input path="gioiTinh" id="gioiTinh" class="form-control" />
        </div>
        <div class="form-group">
            <label for="ngaySinh">Ngay Sinh:</label>
            <input type ="date" name="date" id="ngaySinh" class="form-control" />
        </div>
        <div class="form-group">
            <label for="diaChi">Dia Chi:</label>
            <form:input path="diaChi" id="diaChi" class="form-control" />
        </div>
        <div class="form-group">
            <label for="sdt">SDT:</label>
            <form:input path="sdt" id="sdt" class="form-control" />
        </div>
        <div class="form-group">
            <label for="matKhau">Mat Khau:</label>
            <form:input  path="matKhau" id="matKhau" class="form-control" />
        </div>
        <div class="form-group">
            <label for="trangThai">Trang Thai:</label>
            <form:input type ="number" path="trangThai" id="trangThai" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
