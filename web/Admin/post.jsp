<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Setting List</title>
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
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="/WebApplication2/admin" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Admin Page
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/Admin/img/avatar3.png" class="img-circle" alt="User Image"/>
                                                </div>
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li><!-- end message -->
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/Admin/img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Director Design Team
                                                    <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/Admin/img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Developers
                                                    <small><i class="fa fa-clock-o"></i> Today</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/Admin/img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Sales Department
                                                    <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/Admin/img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Reviewers
                                                    <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <li class="dropdown tasks-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-tasks"></i>
                                <span class="label label-danger">9</span>
                            </a>
                            <ul class="dropdown-menu">

                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Design some buttons
                                                    <small class="pull-right">20%</small>
                                                </h3>
                                                <div class="progress progress-striped xs">
                                                    <div class="progress-bar progress-bar-success" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Create a nice theme
                                                    <small class="pull-right">40%</small>
                                                </h3>
                                                <div class="progress progress-striped xs">
                                                    <div class="progress-bar progress-bar-danger" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">40% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Some task I need to do
                                                    <small class="pull-right">60%</small>
                                                </h3>
                                                <div class="progress progress-striped xs">
                                                    <div class="progress-bar progress-bar-info" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">60% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Make beautiful transitions
                                                    <small class="pull-right">80%</small>
                                                </h3>
                                                <div class="progress progress-striped xs">
                                                    <div class="progress-bar progress-bar-warning" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">80% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>

                            </ul>
                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span>Jane Doe <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">Account</li>

                                <li>
                                    <a href="#">
                                        <i class="fa fa-clock-o fa-fw pull-right"></i>
                                        <span class="badge badge-success pull-right">10</span> Updates</a>
                                    <a href="#">
                                        <i class="fa fa-envelope-o fa-fw pull-right"></i>
                                        <span class="badge badge-danger pull-right">5</span> Messages</a>
                                    <a href="#"><i class="fa fa-magnet fa-fw pull-right"></i>
                                        <span class="badge badge-info pull-right">3</span> Subscriptions</a>
                                    <a href="#"><i class="fa fa-question fa-fw pull-right"></i> <span class=
                                                                                                      "badge pull-right">11</span> FAQ</a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#">
                                        <i class="fa fa-user fa-fw pull-right"></i>
                                        Profile
                                    </a>
                                    <a data-toggle="modal" href="#modal-user-settings">
                                        <i class="fa fa-cog fa-fw pull-right"></i>
                                        Settings
                                    </a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#"><i class="fa fa-ban fa-fw pull-right"></i> Logout</a>
                                </li>
                            </ul>

                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${pageContext.request.contextPath}/Admin/img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="/WebApplication2/admin">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="/WebApplication2/admin/setting/add">
                                <i class="fa fa-gavel"></i> <span>Add Setting</span>
                            </a>
                        </li>

                        <li>
                            <a href="/WebApplication2/admin/setting/details?sid=3">
                                <i class="fa fa-globe"></i> <span>View Setting Details</span>
                            </a>
                        </li>

                        <li>
                            <a href="/WebApplication2/admin">
                                <i class="fa fa-glass"></i> <span>Simple tables</span>
                            </a>
                        </li>

                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->


                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    POST LIST
                                </header>
                                <div class="panel-body">
                                    <div class="container">
                                        <div class="col">
                                            <div class="row">
                                                <form>
                                                    <div class="col-6 col-md-4 form-group">
                                                        <select class="form-control" id="categoryList" name = "cateId">
                                                            <option value="all">All category</option>
                                                            <c:forEach items="${categoryList}" var="item">
                                                                <option value="${item.id}" ${item.id == cateId ? 'selected' :''}>${item.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-6 col-md-4 form-group">
                                                        <select class="form-control" id="authorList" name = "authorId">
                                                            <option value="all">All author</option>
                                                            <c:forEach items="${authorList}" var="item">
                                                                <option value="${item.aid}" ${item.aid == authorId ? 'selected' :''}>${item.fullname}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-6 col-md-4 form-group">
                                                        <select class="form-control" id="statusList"  name = "status">
                                                            <option value="all" ${status == "all" ? 'selected' :''}>All status</option>
                                                            <option value="Enabled" ${status == "Enabled" ? 'selected' :''}>Enabled</option>
                                                            <option value="Disabled" ${status == "Disabled" ? 'selected' :''}>Disabled</option>
                                                        </select>
                                                        <br>
                                                    </div>
                                                </form>
                                                <div class="col-6 col-md-8 form-group">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" placeholder="Search by title ..." id="txtSearch" value="${search}"/>
                                                        <div class="input-group-btn">
                                                            <button class="btn btn-primary btn-shape" type="submit" onclick="triggerSubmitForm()">
                                                                <span class="glyphicon glyphicon-search"></span>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-6 col-md-4 form-group">
                                                    Sort By:   <select class="form-control" id="sortByList" name = "sortBy">
                                                        <option value="none" ${sortBy == "none" ? 'selected' :''}>----*----</option>
                                                        <option value="title" ${sortBy == "title" ? 'selected' :''}>Title</option>
                                                        <option value="category" ${sortBy == "category" ? 'selected' :''}>Category</option>
                                                        <option value="author" ${sortBy == "author" ? 'selected' :''}>Author</option>
                                                        <option value="status" ${sortBy == "status" ? 'selected' :''}>Status</option>
                                                        <option value="featured" ${sortBy == "featured" ? 'selected' :''}>Featured</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <br>

                                        </div>
                                    </div>
                                    <label>

                                        <a href="${pageContext.request.contextPath}/admin/post/add" style="text-decoration: underline">ADD NEW</a>
                                    </label>
                                    <br>
                                    <br>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Category</th>
                                                <th scope="col">Title</th>
                                                <th scope="col">Author</th>
                                                <th scope="col">Featured</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Thumbnail</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${data}">

                                                <tr>
                                                    <td>${item.getId()}</td>
                                                    <td>${item.getCategory().getName()}</td>
                                                    <td>${item.getTitle()}</td>
                                                    <td>${item.getAuthor().getAid()}</td>
                                                    <td>${item.getFeatured()}</td>
                                                    <td>${item.getStatus()}</td>
                                                    <td>${item.getThumbnail()}</td>
                                                    <td><a href="${pageContext.request.contextPath}/admin/post/detail?id=${item.getId()}"> view</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <c:if test="${paging.size()>0}">
                                        <nav aria-label="Page navigation example">
                                            <ul class="pagination">
                                                <li class="page-item">
                                                    <a class="page-link" href="${pageContext.request.contextPath}/admin/posts?pageIndex=${pageIndex - 1 <= 0 ? paging.size (): pageIndex - 1}&sortBy=${sortBy}&cateId=${cateId}&authorId=${authorId}&status=${status}&search=${search}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>
                                                <c:forEach var="item" items="${paging}">
                                                    <li class="page-item ${item == pageIndex ? 'active':''}">
                                                        <a class="page-link" href="${pageContext.request.contextPath}/admin/posts?pageIndex=${item}&sortBy=${sortBy}&cateId=${cateId}&authorId=${authorId}&status=${status}&search=${search}">${item}</a></li>
                                                    </c:forEach>
                                                <li class="page-item">
                                                    <a class="page-link"  href="${pageContext.request.contextPath}/admin/posts?pageIndex=${pageIndex + 1 > paging.size() ? 1 : (pageIndex + 1)}&sortBy=${sortBy}&cateId=${cateId}&authorId=${authorId}&status=${status}&search=${search}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                        <span class="sr-only">Next</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </c:if>
                            </section>
                        </div>
                    </div>
                    <form id="form-submit" action="${pageContext.request.contextPath}/admin/posts" method="GET">
                        <input type="hidden" name="search" id="search" value="${search}">
                        <input type="hidden" name = "sortBy" id = "sortBy" value="${(sortBy == null || sortBy == "" )? "none":sortBy }">
                        <input type="hidden" name = "cateId" id = "cateId" value = ${(cateId == null || cateId == "" ) ? "all" :cateId} >
                        <input type="hidden" name = "authorId" id = "authorId" value = ${(authorId == null || authorId == "" ) ? "all" : authorId}>
                        <input type="hidden" name = "status" id = "status" value = ${(status == null || status == "") ? "all" : status}>
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
        <script type="text/javascript">
                                                                function triggerSubmitForm() {
                                                                    var txtSearchValue = document.getElementById("txtSearch").value;
                                                                    document.getElementById("search").value = txtSearchValue;
                                                                    document.getElementById('form-submit').submit();
                                                                }
                                                                document.getElementById('categoryList').addEventListener('change', function () {
                                                                    document.getElementById("cateId").value = this.value;
                                                                    document.getElementById('form-submit').submit();
                                                                });
                                                                document.getElementById('authorList').addEventListener('change', function () {
                                                                    document.getElementById("authorId").value = this.value;
                                                                    document.getElementById('form-submit').submit();
                                                                });
                                                                document.getElementById('statusList').addEventListener('change', function () {
                                                                    document.getElementById("status").value = this.value;
                                                                    document.getElementById('form-submit').submit();
                                                                });
                                                                document.getElementById('sortByList').addEventListener('change', function () {
                                                                    document.getElementById("sortBy").value = this.value;
                                                                    document.getElementById('form-submit').submit();
                                                                });


        </script>
    </body>
</html>

