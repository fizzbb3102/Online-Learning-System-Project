<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Director | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/Admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${pageContext.request.contextPath}/Admin/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${pageContext.request.contextPath}/Admin/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${pageContext.request.contextPath}/Admin/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
        <!-- Daterange picker -->
        <link href="${pageContext.request.contextPath}/Admin/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- iCheck for checkboxes and radio inputs -->
        <link href="../../Admin/css/iCheck/all.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/Admin/css/style.css" rel="stylesheet" type="text/css" />



        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
          <![endif]-->

        <style type="text/css">

        </style>
    </head>
    <body class="skin-black">
        <jsp:include page="/Admin/admin_header.jsp" />
        <!-- header logo: style can be found in header.less -->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            
            <jsp:include page="/Admin/admin_sidebar.jsp" />

            <aside class="right-side">

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    SLIDERS LIST
                                </header>
                                <div class="panel-body">
                                    <div class="container">
                                        <div class="col">
                                            <div class="row">
                                                <div class="col-6 col-md-4 form-group">
                                                    <form action="sliders_list_controller?action=list" method="post">
                                                        <select class="form-control" id="settingList" name="option">
                                                            <option <c:if test="${selected == 'all'}">selected="selected"</c:if> value="all">All Lists</option>
                                                            <option <c:if test="${selected == 'active'}">selected="selected"</c:if> value="active">active</option>
                                                            <option <c:if test="${selected == 'deactive'}">selected="selected"</c:if> value="deactive">non-active</option>
                                                            </select>
                                                            <button type="submit">Search</button>
                                                        </form>
                                                    </div>
                                                    <form action="sliders_list_controller?action=search" method="post">
                                                        <div class="col-12 col-md-8">

                                                            <div class="input-group">
                                                                <input type="text" class="form-control" placeholder="title/description" name="txtSearch" value="${txtSearch}"/>
                                                            <div class="input-group-btn">
                                                                <button class="btn btn-primary btn-shape" type="submit">
                                                                    <span class="glyphicon glyphicon-search"></span>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="row" style="margin-left: 3px">
                                                <a href="sliders_list_controller?action=addGet" style="font-size: 17px;text-decoration: underline">Add New Setting</a>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Title</th>
                                                <th scope="col">Description</th>
                                                <th scope="col">Image</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Display(hide/show)</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${slideList}" var="o">
                                                <tr>
                                                    <td>${o.id}</td>
                                                    <td>${o.name}</td>
                                                    <td>${o.detail}</td>
                                                    <td><img src="images/slide/${o.image}" alt=""></td>
                                                    <td>${o.status}</td>
                                                    <c:if test="${o.status == 'active'}">
                                                        <td><a href="sliders_list_controller?action=changeStatus&id=${o.id}">Hide</a></td>
                                                    </c:if>
                                                    <c:if test="${o.status == 'deactive'}">
                                                        <td><a href="sliders_list_controller?action=changeStatus&id=${o.id}">Show</a></td>
                                                    </c:if>
                                                    <td><a href="sliders_list_controller?action=editGet&id=${o.id}">Edit</a>
                                                        <a href="sliders_list_controller?action=delete&id=${o.id}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="pagination-area">
                                        <ul class="pagination">
                                            <c:forEach begin="1" end="${endPage}" var="o">
                                                <li class="${tag == o?"active":""}"><a href="sliders_list_controller?index=${o}">${o}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                            </section>
                        </div>
                    </div>
                    <form id="form-submit" action="${pageContext.request.contextPath}/admin/setting-list" method="GET">
                        <input type="hidden" name="search" id="search" value="${search}">
                        <input type="hidden" name = "orderBy" id = "orderBy" value="${orderBy}">
                        <input type="hidden" name = "typeId" id = "typeId" value = ${typeId}>
                    </form>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/Admin/js/jquery.min.js" type="text/javascript"></script>

        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/Admin/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Director App -->
        <script src="${pageContext.request.contextPath}/Admin/js/Director/app.js" type="text/javascript"></script>
    </body>
</html>