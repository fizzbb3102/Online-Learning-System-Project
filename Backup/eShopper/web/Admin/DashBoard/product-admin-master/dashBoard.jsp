<%@page import="entity.DateForPieChart"%>
<%@page import="entity.OptionForPieChart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Load the Visualization API and the piechart package.
            google.charts.load('current', {'packages': ['corechart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.charts.setOnLoadCallback(drawChart);

            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {
                // Create the data table.
                //var data = new google.visualization.DataTable();
                //data.addColumn('string', 'Topping');
                //data.addColumn('number', 'Slices');
                /*data.addRows([
                 <c:forEach items="${pieDataListAccount}" var="entry">
                 [ '${entry.fullname}', ${entry.count} ],
                 </c:forEach>
                 ]);*/
                var data = google.visualization.arrayToDataTable([
                    ['Country', 'Area(square km)'],
            <c:forEach items="${pieDataListAccount}" var="entry">
                    [ '${entry.fullname}', ${entry.count} ],
            </c:forEach>
                ]);

                // Set chart options
                var options = {
//                    'title': 'Area-wise Top Seven Countries in the World', //title which will be shown right above the Google Pie Chart
                    is3D: true, //render Google Pie Chart as 3D
                    pieSliceText: 'label', //on mouse hover show label or name of the Country
                    tooltip: {showColorCode: true}, // whether to display color code for a Country on mouse hover
                    'width': 465, //width of the Google Pie Chart
                    'height': 300 //height of the Google Pie Chart
                };

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_div_account'));

                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            // Load the Visualization API and the piechart package.
            google.charts.load('current', {'packages': ['corechart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.charts.setOnLoadCallback(drawChart);

            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {
                // Create the data table.
                //var data = new google.visualization.DataTable();
                //data.addColumn('string', 'Topping');
                //data.addColumn('number', 'Slices');
                /*data.addRows([
                 <c:forEach items="${pieDataListCourse}" var="entry">
                 [ '${entry.title}', ${entry.count} ],
                 </c:forEach>
                 ]);*/
                var data = google.visualization.arrayToDataTable([
                    ['Country', 'Area(square km)'],
            <c:forEach items="${pieDataListCourse}" var="entry">
                    [ '${entry.title}', ${entry.count} ],
            </c:forEach>
                ]);

                // Set chart options
                var options = {
//                    'title': 'Area-wise Top Seven Countries in the World', //title which will be shown right above the Google Pie Chart
                    is3D: true, //render Google Pie Chart as 3D
                    pieSliceText: 'label', //on mouse hover show label or name of the Country
                    tooltip: {showColorCode: true}, // whether to display color code for a Country on mouse hover
                    'width': 465, //width of the Google Pie Chart
                    'height': 300 //height of the Google Pie Chart
                };

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_div_course'));

                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            function submitForm() {
                document.getElementById("searchForm").submit();
            }
        </script>
        <script type="text/javascript">
            function submitFormDate() {
                document.getElementById("submitFormDate").submit();
            }
        </script>
        <%
            List<OptionForPieChart> listOption = (ArrayList<OptionForPieChart>) request.getAttribute("listOption");
            List<DateForPieChart> listDate = (ArrayList<DateForPieChart>) request.getAttribute("listDate");
            int optionId = (Integer) request.getAttribute("optionId");
            int dateId = (Integer) request.getAttribute("dateId");
        %>
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
                                    DASHBOARD
                                </header>
                                <div class="panel-body">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col">
                                                <form action="pie_chart_controller?action=date&optionId=${optionId}" method="post" id="submitFormDate">
                                                    <select name="dateId" onchange="submitFormDate();">
                                                        <%
                                                            for (DateForPieChart o : listDate) {
                                                        %>
                                                        <option 
                                                            <%=(o.getId() == dateId) ? "selected=\"selected\"" : ""%>
                                                            value="<%=o.getId()%>"
                                                            ><%=o.getDate()%>
                                                        </option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- row -->
                                        <div class="row tm-content-row">
                                            <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                                                <div class="tm-bg-primary-dark tm-block">
                                                    <h2 class="tm-block-title">Account</h2>
                                                    <div id="chart_div_account"></div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                                                <div class="tm-bg-primary-dark tm-block">
                                                    <h2 class="tm-block-title">Course</h2>
                                                    <div id="chart_div_course"></div>
                                                </div>
                                            </div>
                                            <div class="col-12 tm-block-col">
                                                <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                                                    <form action="pie_chart_controller?action=details&dateId=${dateId}" method="post" id="searchForm">
                                                        <select name="optionId" onchange="submitForm();">
                                                            <%
                                                                for (OptionForPieChart o : listOption) {
                                                            %>
                                                            <option 
                                                                <%=(o.getId() == optionId) ? "selected=\"selected\"" : ""%>
                                                                value="<%=o.getId()%>"
                                                                ><%=o.getName()%>
                                                            </option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </form>

                                                    <table class="table">
                                                        <%
                                                            if (optionId == 1) {
                                                        %>
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">Full Name</th>
                                                                <th scope="col">Email</th>
                                                                <th scope="col">PassWord</th>
                                                                <th scope="col">Phone</th>
                                                                <th scope="col">Date Created</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${detailsList}" var="o">
                                                                <tr>
                                                                    <td>${o.fullname}</td>
                                                                    <td>${o.email}</td>
                                                                    <td>${o.password}</td>
                                                                    <td>${o.phone}</td>
                                                                    <td>${o.created_at}</td>
                                                                </tr>  
                                                            </c:forEach>
                                                        </tbody>
                                                        <%
                                                        } else {
                                                        %>
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">Title</th>
                                                                <th scope="col">Author</th>
                                                                <th scope="col">Rated Star</th>
                                                                <th scope="col">List Price</th>
                                                                <th scope="col">Sale Price</th>
                                                                <th scope="col">Thumbnail</th>
                                                                <th scope="col">UpdatedDate</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${detailsList}" var="o">
                                                                <tr>
                                                                    <td>${o.title}</td>
                                                                    <td>${o.author}</td>
                                                                    <td>${o.ratedStar}</td>
                                                                    <td>${o.listPrice}</td>
                                                                    <td>${o.salePrice}</td>
                                                                    <td>${o.thumbnail}</td>
                                                                    <td>${o.updatedDate}</td>
                                                                </tr>  
                                                            </c:forEach>
                                                        </tbody>
                                                        <%
                                                            }
                                                        %>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
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
        <script src="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="${pageContext.request.contextPath}/Admin/DashBoard/product-admin-master/js/tooplate-scripts.js"></script>
        <script>
                                    Chart.defaults.global.defaultFontColor = 'white';
                                    let ctxLine,
                                            ctxBar,
                                            ctxPie,
                                            optionsLine,
                                            optionsBar,
                                            optionsPie,
                                            configLine,
                                            configBar,
                                            configPie,
                                            lineChart;
                                    barChart, pieChart;
                                    // DOM is ready
                                    $(function () {
                                        drawLineChart(); // Line Chart
                                        drawBarChart(); // Bar Chart
                                        drawPieChart(); // Pie Chart

                                        $(window).resize(function () {
                                            updateLineChart();
                                            updateBarChart();
                                        });
                                    })
        </script>
    </body>
</html>