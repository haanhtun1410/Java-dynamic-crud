
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
<section class="container align-items-center">
    <div class="main-content-wrapper d-flex">
        <!-- Mobile Nav (max width 767px)-->

        <div class="shop_sidebar_area">
            <!-- ##### Single Widget ##### -->
            <div class="widget catagory">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Catagories</h6>

                <!--  Catagories  -->
                <div class="catagories-menu">
                    <ul>
                        <li><a href="/shop">all</a></li>
                       <c:forEach var="category" items="${listDSP}">
                           <li>
                               <a href="/shop/${category.id}"> ${category.ten}</a>
                           </li>
                       </c:forEach>

                    </ul>
                </div>
            </div>
        </div>

        <!--ddont mess with this-->
        <div class="amado_product_area section-padding-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div
                                class="product-topbar d-xl-flex align-items-end justify-content-between"
                        >
                            <!-- Total Products -->
                            <div class="total-products">
                                <p>
                                    Showing ${list.size()}
                                </p>
                            </div>
                            <!-- Sorting -->
                        </div>
                    </div>
                </div>

                <div class="row">
                    <!-- Single Product Area -->
                    <c:forEach items="${list}" var="product" varStatus="index" >
                    <div class="col-12 col-sm-3 col-md-12 col-xl-3">
                        <a href="/shop/detail/${product.id}">
                            <div class="single-product-wrapper">
                                <!-- Product Image -->
                                <div class="product-img">
                                    <img
                                            src="../assets/img/product/${index.index+1}.jpg"
                                            style="width: 240px; height: 300px; object-fit: cover"
                                            alt=""
                                    />
                                </div>
                                <!-- Product Description -->
                                <div class="product-description d-flex align-items-center justify-content-between">
                                    <!-- Product Meta Data -->
                                    <div class="product-meta-data">
                                        <h6>${product.sanPham.ten}</h6>
                                        <p class="product-price">$${product.giaBan}</p>
                                    </div>
                                    <!-- Ratings & Cart -->
                                    <div class="ratings-cart text-right">
                                        <div class="cart">
                                            <a
                                                    data-toggle="tooltip"
                                                    data-placement="left"
                                                    title="Add to Cart"
                                                    style="margin-right: 5px"
                                            ><img src="/assets/img/cart.png" alt=""
                                            /></a>
                                        </div>
                                    </div>
                                </div></div
                            ></a>
                    </div>
                    </c:forEach>
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

