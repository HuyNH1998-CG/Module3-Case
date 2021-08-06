<%@ page import="models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Electro - HTML Ecommerce Template</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +070-272-0441</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> TongDucChung12@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> CodeGym</a></li>
            </ul>
            <ul class="header-links pull-right">
                <%
                    Account user = (Account) request.getSession().getAttribute("user");
                    if (user == null) {
                %>
                <li><a href="/views/loginpage.jsp"><i class="fa fa-user-o"></i> My Account</a><li>
                    <%
                } else {
                %>
                <li><a href="/user"><i class="fa fa-user-secret"></i> My Account</a></li>
                <li><a href=""><i class="fa fa-user-o"></i>${user.ten}</a></li>
                <li><a href="/login?action=logout">Log out</a><li>
                    <%
                    }
                %>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/" class="logo">
                            <img style="width: 200px" src="data:image/jpeg;base64,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" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
                            <select class="input-select">
                                <option value="0">Tất cả</option>
                                <option value="1">Đồ Gia Dụng </option>
                                <option value="2">Đồ Điện Tử</option>
                                <option value="3">Sách</option>
                                <option value="4">Quần Áo</option>
                                <option value="5">Khác</option>
                            </select>
                            <input class="input" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Cart -->
                        <div class="dropdown">
                            <a href="/cart">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Giỏ hàng</span>
                                <div class="qty">${cart.size()}</div>
                            </a>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="/views/Home.jsp">Home</a></li>
                <li><a href="/Show/DoGiaDung.jsp">Đồ Gia Dụng</a></li>
                <li><a href="/Show/DoDt.jsp">Đồ Điện Tử</a></li>
                <li><a href="/Show/Sach.jsp">Sách</a></li>
                <li><a href="/Show/Quanao.jsp">Quần Áo</a></li>
                <li><a href="/Show/Khac.jsp">Khác</a></li>
                <li><a href="/order?action=view">Xem Đơn Hàng</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb-tree">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Tất Cả</a></li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- ASIDE -->
            <div id="aside" class="col-md-3">
                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Danh Mục</h3>
                    <div class="checkbox-filter">

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-1">
                            <label for="category-1">
                                <span></span>
                                Đồ Điện Tử
                                <small>(120)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-2">
                            <label for="category-2">
                                <span></span>
                                Đồ Gia Dụng
                                <small>(740)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-3">
                            <label for="category-3">
                                <span></span>
                                Sách
                                <small>(1450)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-4">
                            <label for="category-4">
                                <span></span>
                                Quần Áo
                                <small>(578)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-5">
                            <label for="category-5">
                                <span></span>
                                Khác
                                <small>(120)</small>
                            </label>
                        </div>
                    </div>
                </div>
                <!-- /aside Widget -->

                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Price</h3>
                    <div class="price-filter">
                        <div id="price-slider"></div>
                        <div class="input-number price-min">
                            <input id="price-min" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                        <span>-</span>
                        <div class="input-number price-max">
                            <input id="price-max" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                    </div>
                </div>
                <!-- /aside Widget -->

                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Nhà Phân Phối</h3>
                    <div class="checkbox-filter">
                        <div class="input-checkbox">
                            <input type="checkbox" id="brand-1">
                            <label for="brand-1">
                                <span></span>
                                TiKi
                                <small>(578)</small>
                            </label>
                        </div>
                        <div class="input-checkbox">
                            <input type="checkbox" id="brand-2">
                            <label for="brand-2">
                                <span></span>
                                Điện Máy Xanh
                                <small>(125)</small>
                            </label>
                        </div>
                        <div class="input-checkbox">
                            <input type="checkbox" id="brand-3">
                            <label for="brand-3">
                                <span></span>
                                Thế Giới Di Động
                                <small>(755)</small>
                            </label>
                        </div>
                        <div class="input-checkbox">
                            <input type="checkbox" id="brand-4">
                            <label for="brand-4">
                                <span></span>
                                AmazonJP
                                <small>(578)</small>
                            </label>
                        </div>
                        <div class="input-checkbox">
                            <input type="checkbox" id="brand-5">
                            <label for="brand-5">
                                <span></span>
                                Shopee
                                <small>(125)</small>
                            </label>
                        </div>

                    </div>
                </div>
                <!-- /aside Widget -->


            </div>
            <!-- /ASIDE -->

            <!-- STORE -->
            <div id="store" class="col-md-9">

                <!-- store products ----------------------------------------------------------------------------------------->
                <div class="row">
                        <c:forEach items="${listSp}" var="SP">
                        <div class="col-md-4 col-xs-6" >
                            <div class="product">
                                <div class="product-img">
                                    <img src="${SP.hinhanh}" alt="" style="height: 300px">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${SP.phanloai}</p>
                                    <p class="product-status">${SP.status}</p>
                                    <h3 class="product-name"><a href="#">${SP.ten}</a></h3>
                                    <h4 class="product-price">${SP.gia} VND </h4>
                                    <div class="product-rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-o"></i>
                                    </div>
                                    <div class="product-btns">
                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Thêm vào Yêu Thích</span></button>
                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">Xem</span></button>
                                    </div>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <a href="/cart?action=add&id=${SP.id}" class="add-to-cart-btn"><i
                                        class="fa fa-shopping-cart"></i> add to cart</a>
                            </div>
                        </div>
                        </c:forEach>
                </div>
                <!-- /store products -->
            </div>
            <!-- /STORE -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /NEWSLETTER -->

<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+070-272-0441</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>TongDucChung@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                            <li><a href="#">Hot deals</a></li>
                            <li><a href="#">Laptops</a></li>
                            <li><a href="#">Smartphones</a></li>
                            <li><a href="#">Cameras</a></li>
                            <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="/electro-master/js/jquery.min.js"></script>
<script src="/electro-master/js/bootstrap.min.js"></script>
<script src="/electro-master/js/slick.min.js"></script>
<script src="/electro-master/js/nouislider.min.js"></script>
<script src="/electro-master/js/jquery.zoom.min.js"></script>
<script src="/electro-master/js/main.js"></script>

</body>
</html>
