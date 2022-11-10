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
        <jsp:include page="admin_header.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <jsp:include page="admin_sidebar.jsp"/>
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
                                    SETTING LIST
                                </header>
                                <div class="panel-body">
                                    <div class="container">
                                        <div class="col">
                                            <div class="row">
                                                <div class="col-6 col-md-4 form-group">
                                                    <select class="form-control" id="settingList">
                                                        <option value="all">All setting</option>
                                                        <c:forEach items="${typelist}" var="type">
                                                            <option value="${type.typeId}" ${type.typeId == typeId ? 'selected' :''}>${type.typeName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-12 col-md-8">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" placeholder="name/value" id="txtSearch" value="${search}"/>
                                                        <div class="input-group-btn">
                                                            <button class="btn btn-primary btn-shape" type="submit" onclick="triggerSubmitForm()">
                                                                <span class="glyphicon glyphicon-search"></span>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row" style="margin-left: 3px">
                                                <a href="${pageContext.request.contextPath}/admin/setting/add" style="font-size: 17px;text-decoration: underline">Add New Setting</a>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Type</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Detail</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${data}">

                                                <tr>
                                                    <td>${item.getSettingId()}</td>
                                                    <td>${item.getValue()}</td>
                                                    <td>
                                                        <c:forEach items="${typelist}" var="type">
                                                            <c:if test = "${item.typeId == type.typeId}">
                                                                ${type.typeName}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>${item.status}</td>
                                                    <td><a href="${pageContext.request.contextPath}/admin/setting/details?sid=${item.settingId}"> view</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <c:if test="${paging.size()>0}">
                                        <nav aria-label="Page navigation example">
                                            <ul class="pagination">
                                                <li class="page-item">
                                                    <a class="page-link" href="${pageContext.request.contextPath}/admin/setting-list?pageIndex=${pageIndex - 1}&typeId=${typeId}&search=${search}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>
                                                <c:forEach var="item" items="${paging}">
                                                    <li class="page-item ${item == pageIndex ? 'active':''}">
                                                        <a class="page-link" href="${pageContext.request.contextPath}/admin/setting-list?pageIndex=${item}&typeId=${typeId}&search=${search}">${item}</a></li>
                                                    </c:forEach>
                                                <li class="page-item">
                                                    <a class="page-link"  href="${pageContext.request.contextPath}/admin/setting-list?pageIndex=${pageIndex + 1}&typeId=${typeId}&search=${search}" aria-label="Next">
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
        <script type="text/javascript">
                                                                function triggerSubmitForm() {
                                                                    var txtSearchValue = document.getElementById("txtSearch").value;
                                                                    document.getElementById("search").value = txtSearchValue;
                                                                    document.getElementById('form-submit').submit();
                                                                }
                                                                document.getElementById('settingList').addEventListener('change', function () {
                                                                    document.getElementById("typeId").value = this.value;
                                                                });
        </script>
    </body>
</html>

