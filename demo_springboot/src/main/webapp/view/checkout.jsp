
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
<section style="background-color: #fdccbc">
    <div class="container">
        <div class="row d-flex justify-content-center align-items-center mt-100">
            <div class="col">
                <p>
          <span class="h2">Shopping Cart </span
          ><span class="h4">(1 item in your cart)</span>
                </p>

                <div style="overflow:scroll; height:400px;">
                    <c:forEach var="item" items="${items}" varStatus="ind">
                        <c:set var="subtotal" value="${subtotal + (item.giaBan *listItems[ind.index].soLuong)}" />
                        <div class="card mb-4">
                            <div class="card-body p-4">
                                <div class="row align-items-center">
                                    <div class="col-md-2">
                                        <img
                                                src="../assets/img/product/${ind.index+1}.jpg"
                                                class="img-fluid"
                                                alt="Generic placeholder image"
                                                style="height: 100px;width: 80px"
                                        />
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Name</p>
                                            <p class="lead fw-normal mb-0"> ${item.sanPham.ten}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Color</p>
                                            <p class="lead fw-normal mb-0">
                                                <i class="fas fa-circle me-2" style="color: #fdd8d2"></i>
                                                ${item.mauSac.ten}
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Quantity</p>
                                            <p class="lead fw-normal mb-0">${listItems[ind.index].soLuong}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Price</p>
                                            <p class="lead fw-normal mb-0"> ${item.giaBan}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Total</p>
                                            <p class="lead fw-normal mb-0"> $${item.giaBan *listItems[ind.index].soLuong}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach >
                </div>

    <div class="card mb-5">
        <div class="card-body p-4">
            <div class="float-end">
                <p class="mb-0 me-5 d-flex align-items-center">
                    <span class="small text-muted me-2">Delivery:</span>
                    <span class="lead fw-normal">freeship</span>
                </p>
                <p class="mb-0 me-5 d-flex align-items-center">
                    <span class="small text-muted me-2">Order total:</span>
                    <span class="lead fw-normal">$${subtotal}</span>
                </p>


            </div>
        </div>
    </div>

                <div class="container">
                    <form action="/checkout/submit" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <h3>Billing Address</h3>
                                <div class="form-group">
                                    <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                    <input type="text" id="fname" name="name" class="form-control" placeholder="John M. Doe">
                                </div>
                                <div class="form-group">
                                    <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                    <input type="text" id="adr" name="address" class="form-control" placeholder="542 W. 15th Street">
                                </div>
                                <div class="form-group">
                                    <label for="adr"><i class="fa fa-address-card-o"></i> Phonenumber</label>
                                    <input type="text" id="adr" name="sdt" class="form-control" placeholder="0999999">
                                </div>
                            </div>
                        </div>
                        <br>
                        <input type="submit" value="Purschase" class="btn btn-primary">
                        <button type="button" class="btn btn-light btn-md me-2">
                            Continue shopping
                        </button>
                    </form>

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