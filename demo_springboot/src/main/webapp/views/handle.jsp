<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.example.demo_springboot.domain.FormField" %>

<%@ page import="java.lang.reflect.Field" %>
<%@ page import="jakarta.persistence.Id" %>

<!DOCTYPE html>
<html>
<head>
    <title>KhachHang List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table">
        <%--   tên cột    --%>
        <thead>
        <tr>
            <c:forEach var="field" items="${labels}">
                    <th>${field}</th>
            </c:forEach>

        </tr>
        </thead>
        <%--   tên cột    --%>

        <%--   Dữ liệu    --%>
        <tbody>
        <c:forEach var="object" items="${listDatas}" varStatus="loop">
            <tr>
                <c:forEach var="field" items="${fieldsOfData}">
                    <td>${field.get(object)}</td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
        <%--   Dữ liệu    --%>
    </table>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
