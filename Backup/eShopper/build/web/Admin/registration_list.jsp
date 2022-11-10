<%-- 
    Document   : registration_list.jsp
    Created on : Mar 11, 2022, 10:39:10 AM
    Author     : Zake
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin | Registration List</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/Admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- google font -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/Admin/css/style.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <style>
            .date-time-input{
                display: inline-block;
                width: 200px;
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

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel">
                                <header class="panel-heading">
                                    Registration List
                                </header>
                                <!-- <div class="box-header"> -->
                                <!-- <h3 class="box-title">Responsive Hover Table</h3> -->

                                <!-- </div> -->
                                <div class="panel-body">
                                    <div class="box-tools m-b-15">
                                        <div class="row m-b-15" style="display: inline-block">
                                            <form name="searchForm" id="searchForm" action="registration_list" method="GET">
                                                <div class="col-sm-2" style="width: auto">
                                                    <input type="text" name="email" id="email" class="form-control input-sm pull-left" style="width: 150px;" placeholder="Search by email" value="${email}"/>
                                                </div>
                                                <div class="col-sm-2" style="width: auto">
                                                    <select class="form-control input-sm pull-left" name="courseId" id="courseId">
                                                        <option selected="" value="0">All Subject</option>
                                                        <c:forEach items="${distinctCourseList}" var="subject">
                                                            <option value="${subject.course_id}" <c:if test="${courseId eq subject.course_id}">selected</c:if>>
                                                                <c:forEach items="${courses}" var="course">
                                                                    <c:if test="${subject.course_id eq course.id}">
                                                                        ${course.title}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </option>
                                                        </c:forEach>
                                                    </select> 
                                                </div>
                                                <div class="col-sm-1" style="width: auto">
                                                    <select class="form-control input-sm pull-left" name="status" id="status">
                                                        <option selected="" value="-1">All Status</option>
                                                        <option value="0" <c:if test="${status eq 0}">selected</c:if>>Pending</option>
                                                        <option value="1" style="color: greenyellow" <c:if test="${status eq 1}">selected</c:if>>Approved</option>
                                                        <option value="2" style="color: red" <c:if test="${status eq 2}">selected</c:if>>Rejected</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-4" style="width: auto;">
                                                    <label for="registration_time_from">Registration time: From: </label>
                                                    <input class="form-control input-sm date-time-input" type="date" id="fromDate" name="fromDate" value="${fromDate}">
                                                </div>
                                                <div class="col-sm-3 pull-left" style="width: auto">
                                                    <label for="registration_time">To: </label>
                                                    <input class="form-control input-sm date-time-input" type="date" id="toDate" name="toDate" value="${toDate}">
                                                    <button class="btn btn-sm btn-default" type="submit"><i class="fa fa-search"></i></button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <table class="table table-bordered" name="registration_table" id="registration_table">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Email</th>
                                                <th>Registration Time</th>
                                                <th>Subject</th>
                                                <th>Cost</th>
                                                <th>Status</th>
                                                <th>Last Update</th>
                                                <th>Update By</th>
                                                <th>Note</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Email</th>
                                                <th>Registration Time</th>
                                                <th>Subject</th>
                                                <th>Cost</th>
                                                <th>Status</th>
                                                <th>Last Update</th>
                                                <th>Update By</th>
                                                <th>Note</th>
                                                <th>Action</th>
                                            </tr>
                                        </tfoot>

                                        <tbody>
                                            <c:set var="modalcount" value="0"/>
                                            <c:forEach items="${list}" var="reg">
                                                <tr>
                                                    <td>${reg.id}</td>
                                                    <td>
                                                        <c:forEach items="${accounts}" var="acc">
                                                            <c:if test="${reg.account_id eq acc.aid}">
                                                                ${acc.email}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>
                                                        <fmt:parseDate value="${reg.registration_time}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="reg_time"></fmt:parseDate> 
                                                        <fmt:formatDate value="${reg_time}"  pattern="dd-MM-yyyy HH:mm"></fmt:formatDate >
                                                        </td>
                                                        <td>
                                                        <c:forEach items="${courses}" var="course">
                                                            <c:if test="${reg.course_id eq course.id}">
                                                                ${course.title}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>${reg.total_cost}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${reg.status eq 0}">
                                                                <span class="label label-primary">Pending</span>
                                                            </c:when>
                                                            <c:when test="${reg.status eq 1}">
                                                                <span class="label label-success">Approved</span>
                                                            </c:when>
                                                            <c:when test="${reg.status eq 2}">
                                                                <span class="label label-danger">Rejected</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                    <td>
                                                        <fmt:parseDate value="${reg.last_updated}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="last_updated"></fmt:parseDate> 
                                                        <fmt:formatDate value="${last_updated}"  pattern="dd-MM-yyyy HH:mm"></fmt:formatDate >
                                                        </td>
                                                        <td>
                                                        <c:forEach items="${accounts}" var="acc">
                                                            <c:if test="${reg.updated_by eq acc.aid}">
                                                                ${acc.fullname}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>
                                                        ${reg.note}
                                                    </td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${reg.status eq 0}">
                                                                <button class="btn btn-success" onclick="location.href = '${pageContext.request.contextPath}/admin/registration_list?page=${currentPage}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}&rid=${reg.id}&action=approve';">Approve</button>
                                                                <button class="btn btn-danger" onclick="location.href = '${pageContext.request.contextPath}/admin/registration_list?page=${currentPage}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}&rid=${reg.id}&action=reject';">Reject</button>
                                                            </c:when>
                                                            <c:when test="${reg.status eq 1}">
                                                                <button class="btn btn-danger" onclick="location.href = '${pageContext.request.contextPath}/admin/registration_list?page=${currentPage}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}&rid=${reg.id}&action=reject';">Reject</button>
                                                            </c:when>
                                                            <c:when test="${reg.status eq 2}">
                                                                <button class="btn btn-success" onclick="location.href = '${pageContext.request.contextPath}/admin/registration_list?page=${currentPage}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}&rid=${reg.id}&action=approve';">Approve</button>
                                                            </c:when>
                                                        </c:choose>
                                                        <button class="btn btn-primary" href="#edit_note_modal${modalcount}" data-toggle="modal" data-target="#edit_note_modal${modalcount}" id="editnote">Edit Note</button>
                                                    </td>
                                                </tr>
                                                <!-- </edit_note_modal> -->
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="edit_note_modal${modalcount}" class="modal fade">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                                            <h4 class="modal-title">Edit Note</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form role="form" action="registration_list" method="POST">
                                                                <div class="form-group">
                                                                    <input name="reg_id" id="reg_id" value="${reg.id}" hidden="">
                                                                    <textarea class="form-control" name="note" id="note" style="width:500px;height:150px;" cols="40" rows="5" placeholder="Enter your notes...">${reg.note}</textarea>
                                                                </div>
                                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- ./edit_note_modal -->
                                            <c:set var="modalcount" value="${modalcount + 1}"/>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="table-foot">
                                        <ul class="pagination pagination-sm pull-left">
                                            <c:if test="${currentPage > 1}">
                                                <li><a href="${pageContext.request.contextPath}/admin/registration_list?page=${currentPage - 1}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}">&laquo;</a></li>
                                                <li><a href="${pageContext.request.contextPath}/admin/registration_list?page=${currentPage - 1}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}">${currentPage - 1}</a></li>
                                                </c:if>
                                            <li><a href="#">${currentPage}</a></li>
                                                <c:if test="${currentPage lt numofPage}">
                                                <li><a href="${pageContext.request.contextPath}/admin/registration_list?page=${currentPage + 1}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}">${currentPage + 1}</a></li>
                                                <li><a href="${pageContext.request.contextPath}/admin/registration_list?page=${currentPage + 1}&email=${email}&courseId=${courseId}&status=${status}&fromDate=${fromDate}&toDate=${toDate}">&raquo;</a></li>
                                                </c:if>
                                        </ul>
                                    </div>
                                </div><!-- /.box -->
                            </div><!-- /.box-body -->

                        </div>
                    </div>
                </section><!-- /.content -->
                <div class="footer-main">
                    Copyright &copy Director, 2014
                </div>
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/Admin/js/jquery.min.js" type="text/javascript"></script>

        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/Admin/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Director App -->
        <script src="${pageContext.request.contextPath}/Admin/js/Director/app.js" type="text/javascript"></script>
        <script>
        </script>
    </body>
</html>
