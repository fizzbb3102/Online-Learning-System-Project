<%-- 
    Document   : admin_sidebar
    Created on : 17-Mar-2022, 10:30:58
    Author     : Zake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Setting List</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="Admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />

        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="left-side sidebar-offcanvas">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="${pageContext.request.contextPath}/Admin/img/26115.jpg" class="img-circle" alt="User Image" />
                    </div>
                    <div class="pull-left info">
                        <p>Hello, ${sessionScope.currentUser.fullname}</p>

                        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                </div>
                <!-- search form -->
                <form action="#" method="get" class="sidebar-form">
                    <div class="input-group">
                        <input type="text" name="q" class="form-control" placeholder="Search..."/>
                        <span class="input-group-btn">
                            <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                </form>
                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <c:if test="${sessionScope.currentUser.role_id eq 1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/pie_chart_controller">
                                <i class="fa fa-columns"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/SettingListController">
                                <i class="fa fa-gavel"></i> <span>Setting List</span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.currentUser.role_id eq 2}">
                        <li>
                            <a href="${pageContext.request.contextPath}/pie_chart_controller">
                                <i class="fa fa-columns"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/registration_list">
                                <i class="fa fa-globe"></i> <span>Registration List</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/class_detail_controller">
                                <i class="fa fa-columns"></i> <span>Class List</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/SubjectLessonController">
                                <i class="fa fa-columns"></i> <span>Subject Lesson List</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/sliders_list_controller">
                                <i class="fa fa-columns"></i> <span>Sliders List</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
    </body>

    <!-- jQuery 2.0.2 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="Admin/js/jquery.min.js" type="text/javascript"></script>

    <!-- jQuery UI 1.10.3 -->
    <script src="Admin/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <!-- Bootstrap -->
    <script src="Admin/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="Admin/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>

    <script src="Admin/js/plugins/chart.js" type="text/javascript"></script>

    <!-- datepicker
    <script src="Admin/js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>-->
    <!-- Bootstrap WYSIHTML5
    <script src="Admin/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>-->
    <!-- iCheck -->
    <script src="Admin/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!-- calendar -->
    <script src="Admin/js/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>

    <!-- Director App -->
    <script src="js/Director/app.js" type="text/javascript"></script>

    <!-- Director dashboard demo (This is only for demo purposes) -->
    <script src="js/Director/dashboard.js" type="text/javascript"></script>
</body>
</html>
