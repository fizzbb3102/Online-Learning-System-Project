<%@page import="entity.Course"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css">
    <link href="css/price-range.css" rel="stylesheet" type="text/css">
    <link href="css/animate.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/responsive.css" rel="stylesheet" type="text/css">    
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

</head><!--/head-->

<body>
    <header id="header"><!--header-->
        <div class="header-middle"><!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="logo pull-left">
                            <a href="list_home_controller"><h4>ONLINE LEARN</h4></a>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">
                                <c:if test="${not empty sessionScope.currentUser}">
                                    <li><a><i class="fa"></i>Welcome, ${sessionScope.currentUser.fullname}</a></li>
                                    <li><a href="profile"><i class="fa fa-user"></i>My Account</a></li>
                                    <li><a href="my_course"><i class="fa fa-star"></i> My Course</a></li>
                                    <c:if test="${(sessionScope.currentUser.role_id eq 1) || (sessionScope.currentUser.role_id eq 2) || (sessionScope.currentUser.role_id eq 3) || (sessionScope.currentUser.role_id eq 4)}">
                                    <li><a href="pie_chart_controller"><i class="fa fa-home"></i> Management Page</a></li>
                                    </c:if>
                                </c:if>


                                <c:choose>
                                    <c:when test="${not empty sessionScope.currentUser}">
                                        <li><a href="logout_controller"><i class="fa fa-lock"></i> Logout</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="login_controller"><i class="fa fa-lock"></i> Login</a></li>
                                        </c:otherwise>
                                    </c:choose>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header-middle-->

        <div class="header-bottom"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><a href="list_home_controller">Home</a></li>
                                <li><a href="CourseListController">Course List</a></li>
                                <li><a href="blog_list_controller">Blog List</a></li>
                                <li><a href="SubjectLessonController">Subject Lesson</a></li>
                                <li><a href="contact-us.html">Contact</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div><!--/header-bottom-->
    </header><!--/header-->

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
