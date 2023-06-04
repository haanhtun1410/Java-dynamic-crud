<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.example.demo_springboot.domain.FormField" %>
<%@ page import="java.lang.reflect.Field" %>

<!DOCTYPE html>
<html>
<head>
    <title>KhachHang List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
</head>
<body>
 <c:set var="fieldsOfData" value="${fieldsOfData}"></c:set>
   <c:set var="entity" value="${entity}"></c:set>

 <div class="container-fluid">
     <div class=" mt-5">
         <table class="table mx-auto p-2 table-success table-striped table-hover">
             <thead><tr>
                 <c:forEach var="field" items="${labels}">
                     <th class="text-truncate align-middle">${field}</th>
                 </c:forEach>
                 <th >Function</th>
             </tr></thead>
             <tbody>
             <c:forEach var="object" items="${listDatas}">
                 <tr class="align-middle">
                     <c:forEach var="field" items="${fieldsOfData}">
                         <c:if test="${field.getName() eq 'id'}">
                             <c:set var="valueId" value="${field.get(object)}"></c:set>
                         </c:if>
                         <td>${field.get(object)}</td>
                     </c:forEach>
                     <td class="text-truncate">
                         <a class="btn btn-danger" role="button" href="/test/curd/${entity}/delete/${valueId.toString()}"> Delete </a>
                         <a class="btn btn-primary product-update" role="button" href="/test/curd/${entity}/detail/${valueId.toString()}">
                             <i class="fas fa-eye"></i> Detail
                         </a>
                     </td>
                 </tr>
             </c:forEach>
             </tbody>
         </table>
     </div>
 </div>
 <button type="button" class="btn btn-primary d-grid gap-2 col-6 m-auto fixed-top create-modal" data-bs-toggle="modal" data-bs-target="#createModal">
     Add record
 </button>

 <div class="modal fade" id="createModal" tabindex="-1"  data-mdb-modal-non-invasive="true" aria-labelledby="exampleModalLabel" >
     <div class="modal-dialog modal-lg">
         <div class="modal-content">
             <div class="modal-header">
                 <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
             </div>
             <div class="modal-body">
                 <form method="POST" action="/test/curd/${entity}/add" name="formModel" >
                     <c:forEach var="entry" items = "${typeInputs}" varStatus="ind">
                         <c:if test="${fieldsOfData[ind.index].name ne 'id'}">
                             <label for="${entry.key}">${ind.index}. ${entry.key}: ${fieldsOfData[ind.index].name} </label>
                             <c:choose>
                                 <c:when test="${entry.value eq 'select'}">
                                     <select name="${fieldsOfData[ind.index].name}"  class=" form-control" >
                                         <c:forEach var="opt" items="${listOfListInner.get(fieldsOfData[ind.index].type.simpleName)}">
                                             <option  value="${opt.id}">${opt}</option>
                                         </c:forEach>
                                     </select>
                                 </c:when>
                                 <c:when test="${entry.value ne 'select'}">
                                     <input type="${entry.value}" name="${fieldsOfData[ind.index].name}"
                                            class="form-control"
                                            placeholder="${fieldsOfData[ind.index].type.simpleName}"
                                            required />
                                 </c:when>
                             </c:choose>
                         </c:if>
                     </c:forEach>
                     <center> <input type="submit" class="btn btn-primary mt-3" value="Submit"></center>
                 </form>
             </div>
         </div>
     </div>
 </div>
 <div class="modal fade" id="ProductModal"  aria-hidden="true">
     <div class="modal-dialog modal-lg" >
         <div class="modal-content">
     </div>
     </div>
 </div>
 <script>

     $(document).ready(function() {
         $(".create-modal").on("click", function(e) {
             $("#createModal").modal('show')
             $('.modal-backdrop').remove();
         });
         $('.modal-backdrop').remove();
         $(".product-update").on("click", function(e) {
             e.preventDefault();
             $("#ProductModal").modal('show').find(".modal-content").load($(this).attr('href'));
             $('.modal-backdrop').remove();
         });
     });

 </script>


 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
         integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous">
 </script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

 </body>
</html>
