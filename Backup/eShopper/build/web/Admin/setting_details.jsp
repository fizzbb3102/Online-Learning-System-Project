<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Setting Details</title>
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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            function validateForm() {
                var a = document.forms["form"]["value"].value;
                if (a == null || a === "") {
                    alert("Value cannot be empty");
                    return false;
                }
            }

            function deleteConfirm() {
                var confirm = window.confirm("Are you sure to delete this?");
                if (confirm) {
                    location.href = '/WebApplication2/admin/setting/delete?sid=${setting.settingId}';
                }
                return confirm;
            }

        </script>
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
                                    Setting Details
                                </header>
                                <div class="panel-body">
                                    <form id="form" class="form-horizontal tasi-form" method="post" onsubmit="return validateForm()">
                                        <div class="form-group">
                                            <c:if test="${param.success eq 1}">
                                                <p class="text-center" style="color: green; font-size: 18px">Updated successfully!</p>
                                            </c:if>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Type</label>
                                            <div class="col-lg-10">
                                                <select name="type" class="form-control m-b-10">
                                                    <c:forEach items="${typelist}" var="type">
                                                        <c:choose>
                                                            <c:when test="${setting.typeId == type.typeId}">
                                                                <option value="${type.typeId}" selected>${type.typeName}</option>
                                                            </c:when>
                                                            <c:when test="${setting.typeId != type.typeId}">
                                                                <option value="${type.typeId}">${type.typeName}</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label">Value</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="value" id="value" class="form-control" value="${setting.value}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label">Order</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="order" class="form-control round-input" value="${setting.order}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label">Note</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="note" class="form-control round-input" value="${setting.note}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label">Status</label>
                                            <div class="col-lg-10">
                                                <select name="status" class="form-control m-b-10">
                                                    <c:choose>
                                                        <c:when test="${not setting.status}">
                                                            <option value="1" >Enable</option>
                                                            <option value="0" selected>Disable</option>
                                                        </c:when>
                                                        <c:when test="${setting.status eq true}">
                                                            <option value="1" selected>Enable</option>
                                                            <option value="0" >Disable</option>
                                                        </c:when>
                                                    </c:choose>
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="col-lg-offset-2 col-md-10">
                                        <button type="submit" class="btn btn-info" form="form" >Update</button>
                                        <button class="btn btn-info btn-danger" onclick="deleteConfirm()" >Delete</button>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>

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

