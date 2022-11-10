<%-- 
    Document   : CourseList
    Created on : Mar 04, 2022, 8:49:17 PM
    Author     : ductd
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin | Subject Lesson List</title>
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
                <h2 style="margin-left: 20px">Subject Lesson</h2>
                <div style="padding-left: 900px">
                    <div class="btn-group">
                        <button type="button"  class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                            ${select}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <c:forEach items="${listCourse}" var="i">
                                <li><a href="SubjectLessonController?id=${i.id}&subject=${i.title}">${i.title}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <a href="AddLessonDetail.jsp">Add New Lesson </a>
                </div>

                <form action="SubjectLessonController" method="post">
                    <div style="margin-left: 20px">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Type</th>
                                    <th>Belonging Topic</th>
                                    <th>Order</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listLesson}" var="o">
                                    <tr>
                                        <td>${o.id}</td>
                                        <td>${o.title}</td>
                                        <td>${o.type}</td>
                                        <td>${o.belongingtopic}</td>
                                        <td>${o.order}</td>
                                        <td>${o.status}</td>

                                        <td><a onclick="return confirmComplete();" href="changeStatus?lid=${o.id}">
                                                <c:if test = "${o.status == 'Activate'}">
                                                    Deactivate
                                                </c:if>
                                                <c:if test = "${o.status == 'Deactivate'}">
                                                    Activate
                                                </c:if>
                                            </a></td>
                                            <td><a style="" href="LessonDetailController?id=${o.id}">View Detail</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
            </aside>
            <script type="text/javascript">
                function confirmComplete() {
                    var answer = confirm("Are you sure to activate/ deactivate this lesson?");
                    if (answer === true)
                    {
                        return true;
                    } else
                    {
                        return false;
                    }
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
