<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
        <style>
            .rectangle{
                padding-top: 20px;
                padding-left: 20px;
                padding-right: 20px;
                width:100%;
                height:200px;
                border:1px solid #000; 
                position: relative;
                padding-bottom: 20px;
                border-radius: 20px;
                font-size: 17px;
            }
            .col-md-8 h2{
                padding-bottom: 3%;
                padding-left: 5%;
                font-size: 40px;
            }

            .buttoncenter {
                margin: 0;
                position: absolute;
                left: 60%;
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

        </style>
    </head><!--/head-->

    <body>
        <jsp:include page="header.jsp"/>

        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">


                    </div>
                </div>
            </div>
        </section>
        <!--/slider-->

        <section>
            <div class="container">
                <h2>My Courses</h2><br/>
                <div class="col-md-9">
                    <c:forEach items="${reg_courses}" var="reg">

                        <c:forEach items="${courses}" var="course">
                            <c:if test="${reg.course_id eq course.id}">
                                <c:set var="cr" value="${course}"/>
                            </c:if>
                        </c:forEach>

                        <c:forEach items="${classes}" var="cls">
                            <c:if test="${cls.id eq reg.class_id}">
                                <c:set var="cl" value="${cls}"/>
                            </c:if>
                        </c:forEach>

                        <div class="rectangle" style="background-color:  #fff2e6;">
                            <img src="images/login/${cr.thumbnail}" style="max-height: 100%; max-width: 100%; padding-right: 10px;" class="pull-left"> 
                            <span style="font-size: 20px">ID: ${cr.id} - ${cr.title}</span><br>
                            Class: ${cl.name}<br>
                            <fmt:parseDate value="${reg.from_date}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="from_date"></fmt:parseDate>
                            <fmt:parseDate value="${reg.to_date}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="to_date"></fmt:parseDate>
                            From: <fmt:formatDate value="${from_date}"  pattern="dd-MM-yyyy"></fmt:formatDate > - To: <fmt:formatDate value="${to_date}"  pattern="dd-MM-yyyy"></fmt:formatDate ><br>
                            <fmt:parseDate value="${reg.last_access}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="last_access"></fmt:parseDate> 
                            Last Access: <fmt:formatDate value="${last_access}"  pattern="dd-MM-yyyy HH:mm"></fmt:formatDate ><br>
                                <div class="progress">
                                    <!-- ID of prBar (By default width is 25%) -->

                                    <div id="prgBar" class="progress-bar" style="width:${reg.progress}%">${reg.progress}%</div>
                            </div>
                            <c:choose>
                                <c:when test="${reg.progress <= 0}">
                                    <button class="btn btn-primary buttoncenter" style="text-align: center">Start Studying</button>
                                </c:when>
                                <c:when test="${reg.progress > 0}">
                                    <button class="btn btn-primary buttoncenter" style="text-align: center">Continue Studying</button>
                                </c:when>
                            </c:choose>
                        </div><br/>
                    </c:forEach>
                    <div class="row">
                        <div style="text-align: center;">
                            <c:if test="${currentPage > 1}">
                                <div class="page-item btn btn-default" onclick="location.href = '${pageContext.request.contextPath}/my_course?page=${currentPage - 1}&searchtxt=${search}&subjectId=${subjectId}&fromDateSearch=${fromDate}&toDateSearch=${toDate}';">Previous</div>
                                <div class="page-item btn btn-default" onclick="location.href = '${pageContext.request.contextPath}/my_course?page=${currentPage - 1}&searchtxt=${search}&subjectId=${subjectId}&fromDateSearch=${fromDate}&toDateSearch=${toDate}';">
                                    ${currentPage - 1}
                                </div>
                            </c:if>

                            <div class="page-item btn btn-default" style=".btn-primary{ background: #8c8c8c;}">
                                ${currentPage}
                            </div>
                            <c:if test="${currentPage lt numOfPage}">
                                <div class="page-item btn btn-default" onclick="location.href = '${pageContext.request.contextPath}/my_course?page=${currentPage + 1}&searchtxt=${search}&subjectId=${subjectId}&fromDateSearch=${fromDate}&toDateSearch=${toDate}';">
                                    ${currentPage + 1}
                                </div>
                                <div class="page-item btn btn-default" onclick="location.href = '${pageContext.request.contextPath}/my_course?page=${currentPage + 1}&searchtxt=${search}&subjectId=${subjectId}&fromDateSearch=${fromDate}&toDateSearch=${toDate}';">Next</div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="rectangle" style="height: 350px; line-height: 30px; background-color:  #f2f2f2;">
                        <form name="searchForm" id="searchForm" action="my_course" method="POST">
                            <input type="text" name="searchtxt" placeholder="Search..." value="${search}"><br>
                            Subject: <select name="subjectId">
                                <option value="0" selected >All subject</option>
                                <c:forEach items="${subjectList}" var="subject">
                                    <c:forEach items="${courses}" var="course">
                                        <c:if test="${subject.course_id eq course.id}">
                                            <c:set var="s" value="${course}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${param.subjectId eq s.id}">
                                            <option value="${s.id}" selected="">${s.title}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${s.id}">${s.title}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select><br>
                            From: <input type="date" name="fromDateSearch" id="fromDateSearch" class="input-group" style="max-width: 100%" value="${fromDate}"><br>
                            To: <input type="date" name="toDateSearch" id="toDateSearch" class="input-group" style="max-width: 100%" value="${toDate}">
                            <button class="btn btn-primary" type="submit" onclick="location.href = '${pageContext.request.contextPath}/my_course?searchtxt=${search}&subjectId=${subjectId}&fromDateSearch=${fromDate}&toDateSearch=${toDate}';">Search</button>
                        </form>
                    </div><br/>

                    <div class="rectangle" style="height: auto; background-color:  #f2f2f2;" >
                        <div class="feature"><h2 class="title text-center">Top 5 Features</h2></div>
                        <c:forEach items="${top5Features}" var="o">
                            <div class="productinfo text-center">
                                <img style="width: 100%;height: 50px;width: 50px;" src="images/login/${o.thumbnail}" alt=""/>
                                <h4><a class="title" href="#" >${o.title}</a></h4>
                                <p>Price: ${o.listPrice} $</p>
                                <p>Sale Price: ${o.salePrice} $</p>
                                <p>${o.ratedStar}<i style="color: orange" class="fa fa-star"></i></p></div>
                            <hr class="line" style="padding-bottom: 0px;">
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>

        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="companyinfo">
                                <h2><span>Online</span>-Learn</h2>
                                <p>...where success is the only option...</p>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/login/1.png" alt=""/>
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>IT Course</p>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/login/2.png" alt=""/>
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Social Course</p>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/login/3.png" alt=""/>
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Geography Course</p>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/login/4.png" alt=""/>
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div> 
                                    </a>
                                    <p>Science Course</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer-widget">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Online Learn</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">About</a></li>
                                    <li><a href="">What We Offer</a></li>
                                    <li><a href="">Leadership</a></li>
                                    <li><a href="">Careers</a></li>
                                    <li><a href="">Catalog</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Community</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Learners</a></li>
                                    <li><a href="">Partners</a></li>
                                    <li><a href="">Developers</a></li>
                                    <li><a href="">Translators</a></li>
                                    <li><a href="">Blog</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Policies</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Terms of Use</a></li>
                                    <li><a href="">Privacy Policy</a></li>
                                    <li><a href="">Refund Policy</a></li>
                                    <li><a href="">Billing System</a></li>
                                    <li><a href="">Ticket System</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>More</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Press</a></li>
                                    <li><a href="">Investors</a></li>
                                    <li><a href="">Help</a></li>
                                    <li><a href="">Contact</a></li>
                                    <li><a href="">Articles</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3 col-sm-offset-1">
                            <div class="single-widget">
                                <h1>
                                    <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
                                        <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
                                        </svg></a>
                                    <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-twitter" viewBox="0 0 16 16">
                                        <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"/>
                                        </svg></a>
                                    <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="orange" class="bi bi-whatsapp" viewBox="0 0 16 16">
                                        <path d="M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z"/>
                                        </svg></a>
                                    <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="red" class="bi bi-instagram" viewBox="0 0 16 16">
                                        <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"/>
                                        </svg></a>
                                </h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <p class="pull-left">Copyright © 2022 Online Learn Inc. All rights reserved.</p>
                        <p class="pull-right">Designed by <span><a target="_blank" href="#">Group 5</a></span></p>
                    </div>
                </div>
            </div>
        </footer><!--/Footer-->

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
        <script>
        </script>
    </body>
</html>
