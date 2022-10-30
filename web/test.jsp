<%-- 
    Document   : test
    Created on : Jan 31, 2022, 9:44:57 AM
    Author     : ductd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach items="${list}" var="o">
        <div class="col-sm-11">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div style="background-color:#FAEBD7;border: 2px solid orange;border-radius: 10px;" class="productinfo text-center">
                        <h4><a class="title" href="LessonController?id=${o.id}" >${o.topic}</a></h4>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</body>
</html>
