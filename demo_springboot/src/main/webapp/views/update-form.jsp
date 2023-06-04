<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Data</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
</head>
</script>

<div class="modal-header">
    <h5 class="modal-title">Create Product</h5>
    <button type="button" class="btn-close"   tabindex="-1" data-bs-dismiss="modal" aria-label="Close"></button>
</div>
<div class="modal-body">
    <form method="POST" action="/test/curd/${entity}/add" name="formModel" >
       <span class="position-absolute top-0 start-50 translate-middle-x mt-3 badge bg-primary text-wrap text-uppercase fs-6 text" >
           ${fieldsOfData[0].get(detailEntity)}</span>
        <c:forEach var="entry" items = "${typeInputs}" varStatus="ind">
                <label for="${entry.key}">${ind.index}. ${entry.key}:  </label> <br>
                <c:choose>
                    <c:when test="${entry.value eq 'select'}">
                        <select name="${fieldsOfData[ind.index].name}"  class=" form-control" >
                            <c:forEach var="opt" items="${listOfListInner.get(fieldsOfData[ind.index].type.simpleName)}">
                                <option <c:if test="${fieldsOfData[ind.index].get(detailEntity) eq opt}" > selected </c:if>   value="${opt.id}">${opt}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                    <c:when test="${entry.value ne 'select'}">
                        <input type="${entry.value}" name="${fieldsOfData[ind.index].name}"
                               class="form-control"
                               placeholder="${fieldsOfData[ind.index].type.simpleName}"
                               value="${fieldsOfData[ind.index].get(detailEntity)}"
                               required />
                    </c:when>
                </c:choose>
        </c:forEach>
        <center> <input type="submit" class="btn btn-primary mt-3" value="Update"></center>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
</html>