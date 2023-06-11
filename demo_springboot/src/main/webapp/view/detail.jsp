
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <link href="../assets/img/favicon.png" rel="icon" />
    <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon" />
    <link
            rel="stylesheet"
            href="../css/plugins/iconic/css/material-design-iconic-font.css"
    />
    <link href="../css/plugins/animate.css/animate.min.css" rel="stylesheet" />
    <link href="../css/plugins/bootstrap.min.css" rel="stylesheet" />
    <link
            href="../css/plugins/bootstrap-icons/bootstrap-icons.css"
            rel="stylesheet"
    />
    <link href="../css/plugins/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link
            href="../css/plugins/glightbox/css/glightbox.min.css"
            rel="stylesheet"
    />
    <link href="../css/plugins/remixicon/remixicon.css" rel="stylesheet" />
    <link href="../css/plugins/swiper/swiper-bundle.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../css/custom/core-style.css" />
    <link href="../css/custom/style.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="../WEB-INF/layout/header.jsp" />
<section class="py-5">
    <div class="container px-4 px-lg-4 my-5">
        <div class="row gx-10 gx-lg-5 align-items-center">
            <div class="col-md-6">
                <img
                        class="card-img-top mb-5 mb-md-0"
                        src="/assets/img/product/1.jpg"
                        alt="..."
                />
            </div>
            <div class="col-md-6">
                <div class="small mb-1">${detail.dongSp.ten}</div>
                <h1 class="display-5 fw-bolder">${detail.sanPham.ten}</h1>
                <div class="fs-5 mb-5">
                    <span>${detail.giaBan}$</span>
                </div>
                <p class="lead">${detail.moTa}</p>
                <p class="lead">Màu : ${detail.mauSac.ten}</p>
                <p class="lead">Số lượng : ${detail.soLuongTon}</p>

                <form action="/cart/add/quantity-change" method="post" class="d-flex">
                    <input
                            class="form-control text-center me-3"
                            id="inputQuantity"
                            type="number"
                            step="1"
                            min="1"
                            name="quantity"
                            max="${detail.soLuongTon}"
                            style="max-width: 5rem"
                            value="1"
                    />
                    <input type="hidden" name="idsp" value="${detail.id}">
                    <input type="hidden" name="idgh" value="${cart.id}">
                    <button
                            class="btn btn-outline-dark flex-shrink-0"
                            type="submit"
                    >
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Related items section-->
<%@include file="../WEB-INF/layout/footer.jsp" %>
</body>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../css/plugins/iconic/fonts/Material-Design-Iconic-Font.woff"></script>
<script src="../css/plugins/iconic/css/material-design-iconic-font.css"></script>
<script src="../css/plugins/glightbox/js/glightbox.min.js"></script>
<script src="../css/plugins/isotope-layout/isotope.pkgd.min.js"></script>
<script src="../css/plugins/swiper/swiper-bundle.min.js"></script>
<script src="../css/plugins/waypoints/noframework.waypoints.js"></script>
<script src="../css/plugins/php-email-form/validate.js"></script>

</html>

