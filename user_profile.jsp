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
            .col-md-6 h2{
                padding-bottom: 3%;
                padding-left: 5%;
                font-size: 40px;
            }
            .profile-picture{
                padding-top: 10%;
                display: block;
                margin-left: auto;
                margin-right: auto;
                text-align: center; 
            }
            .save-profile-picture-button{
                display: block;
                margin-left: auto;
                margin-right: auto;
                text-align: center;
            }
            .edit-info-button{
                display: table-cell;
            }
            .modal-header{
                border: none;
            }
            .modal-footer{
                border: none;
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
                <div class="row">
                    <div class="col-md-6">
                        <h2>User Profile</h2>
                        <div class="left-sidebar">
                            <c:choose>
                                <c:when test="${param.success eq 1}">
                                    <p class="text-center" style="color: green; font-size: 18px">Update successfully!</p>
                                </c:when>
                                <c:when test="${param.success eq 0}">
                                    <p class="text-center" style="color: red; font-size: 18px">Update failed! Please check and try again!</p>
                                </c:when>
                                <c:when test="${param.passsuccess eq 1}">
                                    <p class="text-center" style="color: green; font-size: 18px">Password changed successfully!</p>
                                </c:when>
                                <c:when test="${param.passsuccess eq 0}">
                                    <p class="text-center" style="color: red; font-size: 18px">Password changed failed! Please contact admin and try again!</p>
                                </c:when>
                            </c:choose>
                            <table class="table table-responsive table-striped">
                                <tbody>
                                    <tr>
                                        <th>
                                            Full Name:
                                        </th>
                                        <td>
                                            ${info.fullname}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Phone:
                                        </th>
                                        <td>
                                            ${info.phone}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Email:
                                        </th>
                                        <td>
                                            ${info.email}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Gender:
                                        </th>
                                        <td>
                                            <c:choose>
                                                <c:when test="${info.gender eq 0}">
                                                    Female
                                                </c:when>
                                                <c:when test="${info.gender eq 1}">
                                                    Male
                                                </c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Title:
                                        </th>
                                        <td>
                                            ${info.user_title}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Birthday:
                                        </th>
                                        <td>
                                            <fmt:parseDate value="${info.dob}" pattern="yyyy-MM-dd'T'HH:mm" var="dob"></fmt:parseDate>
                                            <fmt:formatDate value="${dob}"  pattern="dd-MM-yyyy"></fmt:formatDate >
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Role:
                                            </th>
                                            <td>
                                            <c:choose>
                                                <c:when test="${info.role_id eq 1}">
                                                    Admin
                                                </c:when>
                                                <c:when test="${info.role_id eq 2}">
                                                    Expert
                                                </c:when>
                                                <c:when test="${info.role_id eq 3}">
                                                    Marketing
                                                </c:when>
                                                <c:when test="${info.role_id eq 4}">
                                                    Sale
                                                </c:when>
                                                <c:when test="${info.role_id eq 5}">
                                                    Customer
                                                </c:when>
                                            </c:choose>

                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            Created at:
                                        </th>
                                        <td>
                                            <fmt:parseDate value="${info.created_at}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="created_at"></fmt:parseDate>
                                            <fmt:formatDate value="${created_at}"  pattern="dd-MM-yyyy"></fmt:formatDate >

                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Password:
                                            </th>
                                            <td>
                                                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#changePasswordModal">Change Password</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                <button class="btn btn-primary edit-info-button" data-toggle="modal" data-target="#changeInfoModal" >Edit Information</button>
                                            </th>
                                            <td>

                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <form name="changepfp" action="changepfp" method="POST" enctype="multipart/form-data">
                                <div class="profile-picture" style="margin-top: 15%">
                                <c:choose>
                                    <c:when test="${not empty info.pfp}">
                                        <img id="profile_picture" src="${pageContext.request.contextPath}/images/profile/${info.pfp}" width="250" height="250">
                                    </c:when>
                                    <c:otherwise>
                                        <img id="profile_picture" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png" width="250" height="250">
                                    </c:otherwise>
                                </c:choose>
                                <input type="file" id="imagefile" name="imagefile" onchange="changePreviewAndButton(this);" class="btn btn-primary save-profile-picture-button" style="display: none">
                            </div>
                            <button id="upload_button" type="button" class="btn btn-primary save-profile-picture-button center-block"  onclick="document.getElementById('imagefile').click()">Upload...</button>
                            <button id="save_button" type="submit" class="btn btn-primary save-profile-picture-button" style="display: none">Save changes</button>
                        </form>

                    </div>
                </div>
            </div>
        </section>

        <!-- Modal -->
        <div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Change Password</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="changePasswordForm" name="changePasswordForm" action="changepassword" method="POST" onsubmit="return passwordCheck()">
                        <div class="modal-body">
                            <table class="table table-responsive table-striped">
                                <tbody>
                                <input type="text" name="aid" value="${info.aid}" required="" hidden=""/>
                                <tr>
                                    <th>
                                        Old Password:
                                    </th>
                                    <td>
                                        <input id="old_password" type="password" name="old_password" value="" required=""/>
                                    </td>
                                </tr>
                                <tr id="old_password_row" style="display: none;">
                                    <th>
                                    </th>
                                    <td>
                                        <span id="old_password_msg" style="color: red">Old password does not match !</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        New Password:
                                    </th>
                                    <td>
                                        <input id="new_password" type="password" name="new_password" value="" required=""/>
                                    </td>
                                </tr>
                                <tr id="new_password_row" style="display: none;">
                                    <th>
                                    </th>
                                    <td>
                                        <span id="new_password_msg" style="color: red">Password must have at least 6 characters !</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        Enter again:
                                    </th>
                                    <td>
                                        <input id="renew_password" type="password" name="renew_password" value="" required=""/>
                                    </td>
                                </tr>
                                <tr id="renew_password_row" style="display: none;">
                                    <th>
                                    </th>
                                    <td>
                                        <span id="renew_password_msg" style="color: red">New password does not match !</span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" form="changePasswordForm">Save changes</button>
                    </div>

                </div>
            </div>
        </div>


        <div class="modal fade" id="changeInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title" id="exampleModalCenterTitle">Edit Information</h2>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="editInfoForm" name="editInfoForm" action="profile" method="POST">
                        <div class="modal-body">
                            <table class="table table-responsive table-striped">
                                <tbody>
                                <input type="text" name="aid" value="${info.aid}" required="" hidden=""/>
                                <input type="text" name="email" value="${info.email}" required="" hidden=""/>
                                <tr>
                                    <th>
                                        Full Name:
                                    </th>
                                    <td>
                                        <input type="text" name="fullname" value="${info.fullname}" required=""/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        Phone:
                                    </th>
                                    <td>
                                        <input type="tel" name="phone" value="${info.phone}" onkeypress="return onlyNumberKey(event)" required=""/>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" form="editInfoForm">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <!--/Modal-->

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


        <script>
            function onlyNumberKey(evt) {

                // Only ASCII character in that range allowed
                var ASCIICode = (evt.which) ? evt.which : evt.keyCode
                if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
                    return false;
                return true;
            }

            function passwordCheck() {
                var password = '${sessionScope.currentUser.password}';
                var oldPassword = document.getElementById('old_password').value;
                var newPassword = document.getElementById('new_password').value;
                var renewPassword = document.getElementById('renew_password').value;

                var old_password_row_style = document.getElementById('old_password_row').style;
                var oldPasswordCheck = true;
                if (oldPassword !== password) {
                    old_password_row_style.display = 'table-row';
                    oldPasswordCheck = false;
                } else {
                    old_password_row_style.display = 'none';
                    oldPasswordCheck = true;
                }

                var new_password_row_style = document.getElementById('new_password_row').style;
                var newPasswordCheck = true;
                if (newPassword.length < 6) {
                    new_password_row_style.display = 'table-row';
                    newPasswordCheck = false;
                } else {
                    new_password_row_style.display = 'none';
                    newPasswordCheck = true;
                }

                var renew_password_row_style = document.getElementById('renew_password_row').style;
                var renewPasswordCheck = true;
                if (newPassword !== renewPassword) {
                    renew_password_row_style.display = 'table-row';
                    renewPasswordCheck = false;
                } else {
                    renew_password_row_style.display = 'none';
                    renewPasswordCheck = true;
                }

                if (oldPasswordCheck === false || newPasswordCheck === false || renewPasswordCheck === false) {
                    return false;
                }
            }

            function changePreviewAndButton(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#profile_picture')
                                .attr('src', e.target.result)
                                .width(200)
                                .height(200);
                    };
                    reader.readAsDataURL(input.files[0]);
                }

                //hide upload button
                var upload_button_style = document.getElementById('upload_button').style;
                upload_button_style.display = 'none';

                //show save button
                var save_button_style = document.getElementById('save_button').style;
                save_button_style.display = 'block';
            }
        </script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
