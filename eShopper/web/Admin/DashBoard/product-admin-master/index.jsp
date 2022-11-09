<%-- 
    Document   : newjsp
    Created on : Mar 16, 2022, 6:52:54 PM
    Author     : LENOVO
--%>

<%@page import="entity.DateForPieChart"%>
<%@page import="entity.OptionForPieChart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Product Admin - Dashboard HTML Template</title>
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
    </head>

    <body id="reportsPage">
        <div class="" id="home">
            <nav class="navbar navbar-expand-xl">
                <div class="container h-100">
                    <a class="navbar-brand" href="index.html">
                        <h1 class="tm-site-title mb-0">Product Admin</h1>
                    </a>
                    <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-bars tm-nav-icon"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mx-auto h-100">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <i class="fas fa-tachometer-alt"></i>
                                    Dashboard
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="far fa-file-alt"></i>
                                    <span>
                                        Reports <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Daily Report</a>
                                    <a class="dropdown-item" href="#">Weekly Report</a>
                                    <a class="dropdown-item" href="#">Yearly Report</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="products.html">
                                    <i class="fas fa-shopping-cart"></i>
                                    Products
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="accounts.html">
                                    <i class="far fa-user"></i>
                                    Accounts
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-cog"></i>
                                    <span>
                                        Settings <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Profile</a>
                                    <a class="dropdown-item" href="#">Billing</a>
                                    <a class="dropdown-item" href="#">Customize</a>
                                </div>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link d-block" href="login.html">
                                    Admin, <b>Logout</b>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
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
            <footer class="tm-footer row tm-mt-small">
                <div class="col-12 font-weight-light">
                    <p class="text-center text-white mb-0 px-4 small">
                        Copyright &copy; <b>2018</b> All rights reserved. 

                        Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                    </p>
                </div>
            </footer>
        </div>

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
