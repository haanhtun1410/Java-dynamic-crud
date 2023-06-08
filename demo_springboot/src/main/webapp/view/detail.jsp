
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
                <div class="d-flex">
                    <input
                            class="form-control text-center me-3"
                            id="inputQuantity"
                            type="number"
                            ng-model="fromDetail"
                            step="1"
                            min="1"
                            max="300"
                            style="max-width: 5rem"
                    />
                    <button
                            ng-click="addToCart(selectedProduct.id)"
                            class="btn btn-outline-dark flex-shrink-0"
                            type="button"
                    >
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related items section-->
<section class="py-5 bg-light">
    <div class="container px-4 px-lg-5 mt-5">
        <h2 class="fw-bolder mb-4">Related products</h2>
        <div
                class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
        >
            <div
                    class="col mb-5"
                    ng-repeat="product in shuffleArray(products) |limitTo : 4"
            >
                <div class="card h-100">
                    <!-- Product image-->
                    <img
                            class="card-img-top"
                            ng-src="/assets/img/product/{{product.image}}"
                            alt="..."
                            style="max-height: 300px; max-width: 300px; object-fit: cover"
                    />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">{{product.name}}</h5>
                            <!-- Product price-->
                            {{product.price}}$
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a
                                    class="btn btn-outline-dark mt-auto"
                                    href="#/detail/{{product.id}}"
                            >View options</a
                            >
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
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

