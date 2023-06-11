
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
<section ng-init="getUserCartData" class="vh-100" style="margin-top: 20px">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 text-black">
                <div class="px-5 ms-xl-4">
                    <i
                            class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4"
                            style="color: #709085"
                    ></i>
                    <span class="h1 fw-bold mb-0">${errorMessage}</span>
                </div>

                <div
                        class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5"
                >
                    <form style="width: 23rem" action ="/login/log" method="post">
                        <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                            Log in
                        </h3>

                        <div class="form-outline mb-4">
                            <input
                                    type="text"
                                    id="form2Example18"
                                    name ="username"
                                    placeholder="Username"
                                    class="form-control form-control-lg"
                            />
                            <label class="form-label" for="form2Example18"
                            >Email address</label
                            >
                        </div>

                        <div class="form-outline mb-4">
                            <input
                                    type="password"
                                    id="form2Example28"
                                    placeholder="Password"
                                    name ="password"
                                    required
                                    class="form-control form-control-lg"
                            />
                            <label class="form-label" for="form2Example28">Password</label>
                        </div>

                        <div class="pt-1 mb-4">
                            <button
                                    class="btn btn-info btn-lg btn-block"
                                    type="submit"
                            >
                                Login
                            </button>
                        </div>

                        <p class="small mb-5 pb-lg-2">
                            <a class="text-muted" href="#/forgot-pw">Forgot password?</a>
                        </p>
                        <p>
                            Don't have an account?
                            <a href="#/sign-up" class="link-info">Register here</a>
                        </p>
                    </form>
                </div>
            </div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img
                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
                        alt="Login image"
                        class="w-100 vh-100"
                        style="object-fit: cover; object-position: left"
                />
            </div>
        </div>
    </div>
</section>
<%@include file="../WEB-INF/layout/footer.jsp" %>

<script>
    window.onload = function() {
        // Check if the cart is missing
        if (${errorMessage}) {
            alert('Your cart is empty. Please login.');
        }
        // Redirect to the login page
        window.location.href = '/login';
    }
</script>
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

