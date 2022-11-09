<%-- 
    Document   : CourseList
    Created on : Jan 22, 2022, 7:49:17 PM
    Author     : ductd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin | Subject Lesson Detail</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/Admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />

        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/Admin/css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <style>
            .btn-shape{
                padding: 7px 14px
            }
        </style>
    </head>
    <body class="skin-black">
        <jsp:include page="admin_header.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <jsp:include page="admin_sidebar.jsp"/>
                <!-- /.sidebar -->
            </aside>

            <aside class="right-side">
                <h2 style="margin-left: 20px">Lesson Detail</h2>
                <div style="margin-left: 20px">
                    <table class="table table-striped">
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Title</th>
                                <td>${getLessonByDetail.title}</td>
                            </tr>
                            <tr>
                                <th scope="row">Type</th>
                                <td>${getLessonByDetail.type}</td>
                            </tr>
                            <tr>
                                <th scope="row">Belonging Topic</th>
                                <td>${getLessonByDetail.belongingtopic}</td>

                            </tr>
                            <tr>
                                <th scope="row">Order</th>
                                <td>${getLessonByDetail.order}</td>
                            </tr>
                            <tr>
                                <th scope="row">Status</th>
                                <td>${getLessonByDetail.status}</td>
                            </tr>
                            <tr>
                                <th scope="row">Video Link</th>
                                <td>${getLessonByDetail.videolink}</td>
                            </tr>
                            <tr>
                                <th scope="row">Content</th>
                                <td>${getLessonByDetail.conent}</td>
                            </tr>
                        </tbody>
                        <td><a href="EditLessonDetailController?id=${getLessonByDetail.id}">Edit Lesson</a></td>
                    </table>
                </div>
            </aside>               

            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.scrollUp.min.js"></script>
            <script src="js/price-range.js"></script>
            <script src="js/jquery.prettyPhoto.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>
