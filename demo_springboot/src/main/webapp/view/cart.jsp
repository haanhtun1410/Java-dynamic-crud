
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<c:set var="subtotal" value="0" />
<section class="container align-items-center">
    <div class="main-content-wrapper d-flex">
        <div class="cart-table-area section-padding-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="cart-title mt-50">
                            <h2>Shopping Cart</h2>
                        </div>
                        <div class="cart-table clearfix">
                            <table class="table table-responsive">
                                <thead>
                                <tr>

                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th style="margin: 0px ;width: 10px;column-width: 10px"></th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="item" items="${listItems}" varStatus="ind">
                                    <tr>
                                        <c:set var="subtotal" value="${subtotal + (item.donGia * item.soLuong)}" />

                                        <td class="cart_product_desc">
                                            <h5>${items[ind.index].sanPham.ten}</h5>
                                        </td>
                                        <td class="price">
                                            <span>$${items[ind.index].giaBan}</span>
                                        </td>
                                        <td class="qty">
                                            <div class="qty-btn d-flex">
                                                <p>Qty</p>
                                                <div class="quantity">
                          <span class="qty-minus"
                          ><i class="fa fa-minus"></i
                          ></span>
                                                    <form action="/cart/add/quantity-change" method="post">
                                                        <input type="number"
                                                               class="qty-text"
                                                               id="qty"
                                                               step="1"
                                                               min="0"
                                                               max="${items[ind.index].soLuongTon}"
                                                               name="quantity"
                                                               value="${item.soLuong}"
                                                               onchange="this.form.submit();"
                                                        />
                                                        <input type="hidden" name="idsp" value="${item.id.idChiTietSP}">
                                                        <input type="hidden" name="idgh" value="${item.id.idGioHang}">
                                                    </form>
                                                </div>
                                            </div>
                                        </td>
                                        <td>$${item.soLuong * items[ind.index].giaBan}  <input class="float-end mx-5" type="checkbox"></td>
                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Cart Total</h5>
                            <ul class="summary-table">
                                <li><span>subtotal:</span> <span>$${subtotal}</span></li>
                                <li><span>delivery:</span> <span>Free</span></li>
                                <li><span>total:</span> <span>$${subtotal}</span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <a href="/checkout" class="btn amado-btn w-100">Checkout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../WEB-INF/layout/footer.jsp" %>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../css/plugins/iconic/fonts/Material-Design-Iconic-Font.woff"></script>
<script src="../css/plugins/iconic/css/material-design-iconic-font.css"></script>
<script src="../css/plugins/glightbox/js/glightbox.min.js"></script>
<script src="../css/plugins/isotope-layout/isotope.pkgd.min.js"></script>
<script src="../css/plugins/swiper/swiper-bundle.min.js"></script>
<script src="../css/plugins/waypoints/noframework.waypoints.js"></script>
<script src="../css/plugins/php-email-form/validate.js"></script>
</body>
</html>