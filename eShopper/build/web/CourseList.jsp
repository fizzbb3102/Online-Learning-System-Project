<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Course List | Online Learn</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/courselist_main.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.css" rel="stylesheet"> 

    </head><!--/head-->
    <body>
        <jsp:include page="header.jsp" />
        <section>
            <div class="container">
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                        ${select}
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${listCategory}" var="o">
                            <li><a href="CourseListController?id=${o.settingId}&subject=${o.value}">${o.value}</a></li>
                            </c:forEach>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-sm-9 padding-right">
                        <div class="features_items">
                            <h2 class="title text-center"></h2>
                            <c:forEach items="${listPaging}" var="o">
                                <img style="padding-bottom: 55px" src="images/login/${o.thumbnail}" alt=""/>
                                <div style="display: inline-block;padding-left: 20px;">
                                    <h4><a class="title" href="#" >${o.title}</a></h4>
                                    <p style="font-style: oblique;font-weight: bold">Top Instructor: ${o.author}</p>
                                    <p>Price: ${o.listPrice} $</p>
                                    <p>Quality: ${o.ratedStar}<i style="color: orange" class="fa fa-star"></i></p></div>
                                <hr class="hline">
                            </c:forEach>
                        </div>
                        <c:forEach begin="1" end="${endPage}" var="i">
                            <div class="pagination">
                                <a class="${active==i?"active":""}" href="CourseListController?index=${i}&txtSearch=${txtSearch}">${i}</a>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-sm-3">
                        <div class="rightsider">
                            <form class="form-inline"  action="CourseListController"  method="post">
                                <input class="form-control rounded" name ="txtSearch" value="${txtSearch}" type="text" placeholder="What do you want?">
                                <button style="margin-top: 0px;position: absolute;padding-top: 10px" class="btn btn-primary" type="submit"> <i class="fa fa-search"></i></button>
                            </form>
                            <hr class="vertical">
                            <div class="feature"><h2 class="title text-center">Top 5 Features</h2></div>
                            <c:forEach items="${top5Features}" var="o">
                                <div class="productinfo text-center">
                                    <img style="width: 100%;height: 50px;width: 50px;margin-top: 20px;" src="images/login/${o.thumbnail}" alt=""/>
                                    <h4><a class="title" href="#" >${o.title}</a></h4>
                                    <p>Price: ${o.listPrice} $</p>
                                    <p>Sale Price: ${o.salePrice} $</p>
                                    <p>${o.ratedStar}<i style="color: orange" class="fa fa-star"></i></p></div>
                                <hr class="hline">
                                <br>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="footer.jsp" />

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
