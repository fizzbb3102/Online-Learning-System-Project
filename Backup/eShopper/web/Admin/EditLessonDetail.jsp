<%-- 
    Document   : CourseList
    Created on : Mar 05, 2022, 8:49:17 PM
    Author     : ductd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin | Edit Lesson Detail</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/Admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <script src="ckeditor/ckeditor.js" type="text/javascript"></script>
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
                <div style="margin-left: 20px" >
                    <h2>Edit Lesson </h2>
                    <form action="EditLessonDetailController?id=${getLessonByDetail.id}" method="post">
                        <table class="table table-striped">
                            <thead>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Title</th>
                                    <td>
                                        <input class="form-control" type="text" name="Title" value="${getLessonByDetail.title}"   aria-label="default input example">
                                    </td>

                                </tr>
                                <tr>
                                    <th scope="row">Type</th>
                                    <td>
                                        <c:if test = "${getLessonByDetail.type == 'topic'}">
                                            <input type="radio" name="Type" value="topic" checked=""> Topic
                                            <br>
                                            <input type="radio" name="Type" value="lesson" > Lesson
                                        </c:if>
                                        <c:if test = "${getLessonByDetail.type == 'lesson'}">
                                            <input type="radio" name="Type" value="topic" > Topic
                                            <br>
                                            <input type="radio" name="Type" value="lesson" checked=""> Lesson
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Belonging Topic</th>
                                    <td>
                                        <select name="Topic">
                                            <option value="Information Tech">Information Tech</option>
                                            <option value="Literature">Literature</option>
                                            <option value="English">English</option>
                                            <option value="Science">Science</option>
                                        </select>
                                    </td>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Order</th>
                                    <td>
                                        <input class="form-control" type="text" name="Order" value="${getLessonByDetail.order}"  aria-label="default input example">
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Status</th>
                                    <td>
                                        <c:if test = "${getLessonByDetail.status == 'Activate'}">
                                            <input type="radio" name="Status" value="Activate" checked=""> Activate
                                            <br>
                                            <input type="radio" name="Status" value="Deactivate" > Deactivate
                                        </c:if>
                                        <c:if test = "${getLessonByDetail.status == 'Deactivate'}">
                                            <input type="radio" name="Status" value="Activate"> Activate
                                            <br>
                                            <input type="radio" name="Status" value="Deactivate" checked=""> Deactivate
                                        </c:if>
                                    </td>

                                </tr>
                                <tr>
                                    <th scope="row">Video Link</th>
                                    <td>
                                        <input class="form-control" type="text" name="Link" value="${getLessonByDetail.videolink}"   aria-label="default input example">
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Content</th>
                                    <td>
                                        <textarea rows="" cols="" id="content" name="Content" style="width: 820px;height: 175px;">${getLessonByDetail.conent}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row"></th>
                                    <td><button style="color: red;color: white;background-color: #006dcc;font-style: oblique;font-weight: bold;border-radius: 10px;width: 150px;height: 50px;" type="submit">Edit Lesson</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </aside>
            <script>
                var editor = '';
                $(document).ready(function () {
                    editor = CKEDITOR.replace('content');
                });
            </script>
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.scrollUp.min.js"></script>
            <script src="js/price-range.js"></script>
            <script src="js/jquery.prettyPhoto.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>
