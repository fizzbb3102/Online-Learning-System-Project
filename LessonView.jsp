<%-- 
    Document   : LessonView
    Created on : Jan 22, 2022, 7:49:17 PM
    Author     : ductd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Lesson View | Online Learn</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/courselist_main.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.css" rel="stylesheet"> 

    </head><!--/head-->
    <body>
        <jsp:include page="header.jsp" />
        <section>
            <div class="container">

                <div class="row">
                    <div class="col-sm-9 padding-right">
                        <div class="features_items">
                                <c:forEach items="${listCourse}" var="o">
                                    <h2 style="text-align: center" >${o.title}</h2>
                                    <h3>Introduction</h3>
                                    ${o.introduction}
                                    <br>
                                    <hr class="hline">
                                    <h3>Brief Information</h3>
                                    ${o.briefInfo}
                                </c:forEach>
                    </div></div>
                    <div class="col-sm-3">
                        <div class="rightsider">
                            <div class="row">
                                <h2 class="title text-center"></h2>
                                <div class="feature"><h2 class="title text-center">${lesson.belongingtopic}</h2></div>
                                <hr class="hline">
                                    <c:forEach items="${listLesson}" var="o">
                                    <div style="padding-bottom: 20px">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-play-circle-fill" viewBox="0 0 16 16">
                                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM6.79 5.093A.5.5 0 0 0 6 5.5v5a.5.5 0 0 0 .79.407l3.5-2.5a.5.5 0 0 0 0-.814l-3.5-2.5z"/>
                                        </svg>
                                        <a style="color: black;font-weight: bold;font-size: 15px" href="LessonViewDetailController?id=${o.id}&subId=${o.subjectID}">${o.title}</a>
                                        <br>
                                        <hr class="hline">
                                    </div>
                                </c:forEach>
                            </div>
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

