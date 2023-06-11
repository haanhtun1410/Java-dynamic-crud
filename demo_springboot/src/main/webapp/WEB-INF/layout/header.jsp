<%--
  Created by IntelliJ IDEA.
  User: longv
  Date: 4/3/2023
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<html>
<head>
    <link href="${basePath}/assets/img/favicon.png" rel="icon" />
    <link href="${basePath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon" />
    <link
            rel="stylesheet"
            href="${basePath}/css/plugins/iconic/css/material-design-iconic-font.css"
    />
    <link href="${basePath}/css/plugins/animate.css/animate.min.css" rel="stylesheet" />
    <link href="${basePath}/css/plugins/bootstrap.min.css" rel="stylesheet" />
    <link
            href="${basePath}/css/plugins/bootstrap-icons/bootstrap-icons.css"
            rel="stylesheet"
    />
    <link href="${basePath}/css/plugins/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link
            href="${basePath}/css/plugins/glightbox/css/glightbox.min.css"
            rel="stylesheet"
    />
    <link href="${basePath}/css/plugins/remixicon/remixicon.css" rel="stylesheet" />
    <link href="${basePath}/css/plugins/swiper/swiper-bundle.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${basePath}/css/custom/core-style.css" />
    <link href="${basePath}/css/custom/style.css" rel="stylesheet" />
</head>
<body>

<header  id="header"
         class="fixed-top d-flex align-items-center">
<div class="container d-flex align-items-center">
    <h1 class="logo me-auto"><a href="/main-page">Sailor</a></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html" class="logo me-auto"><img src="/assets/img/logo.png" alt="" class="img-fluid"></a>-->
    <nav id="navbar" class="navbar">
        <ul>
            <li><a href="/main-page">Home</a></li>
            <li class="dropdown">
                <a href="/api/curd/NhanVien"
                ><span>CRUD </span> <i class="bi bi-chevron-down"></i
                ></a>
                <ul>
                    <c:forEach var="clazz" items="${classList}">
                        <li>
                            <a href="/api/curd/${clazz.toString()}">${clazz.toString()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </li>
            <li><a href="/shop">Product</a></li>
            <li><a href="#/about"  onclick="navigateToAnotherURL(this.href)">About</a></li>
            <li><a href="#/blog" onclick="navigateToAnotherURL(this.href)">Blog</a></li>
            <li><a href="#/contact" onclick="navigateToAnotherURL(this.href)">Contact</a></li>
         <c:if test="${LoggedAccount ne null}">   <li>
             <a href="/cart">
                 <i style="font-size: 16px; color: gray" class="bi bi-basket3-fill"></i>
                 <c:if test="${listItems.size() >0}">
                       <span
                               style="background-color: red"
                               class="badge badge-light"
                       >${listItems.size()}</span>
                 </c:if>
             </a>
         </li>

         </c:if>
            <c:if test="${LoggedAccount eq null}"><li><a href="/login" class="getstarted">Login</a></li>  </c:if>
            <c:if test="${LoggedAccount ne null}">
                <li class="dropdown">
                <a href="#/home"
                ><span>${LoggedAccount.ten}</span> <i class="bi bi-chevron-down"></i
                ></a>
                <ul>
                    <li><a href="#/update-password">Update password</a></li>
                    <li><a href="#/bought-product">Bought product</a></li>
                    <li><a href="/login/logout" >Log out</a></li>
                </ul>
                </li>
            </c:if>
            </ul>
    </nav>
     </div>
</header>

<script>
    function navigateToAnotherURL(to) {
        var url = to;
        var hash = url.substring(url.indexOf('#'));
        var newURL = 'http://localhost:8080/main-page'+hash;
        window.location.href = newURL;
    }
</script>
</body>
</html>
