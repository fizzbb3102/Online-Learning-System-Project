<%-- 
    Document   : CourseList
    Created on : Mar 06, 2022, 7:55:17 PM
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
        <title>Add Lesson Information | Online Learn</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/courselist_main.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.css" rel="stylesheet"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="ckeditor/ckeditor.js" type="text/javascript"></script>
    </head><!--/head-->
    <body>

        <div class="container">
            <h2>Add Lesson Information</h2>
            <form action="AddLessonController" method="post">
                <table class="table table-striped">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Title</th>
                            <td><input class="form-control" type="text" name="Title" minlength="1" maxlength="50" required="" aria-label="default input example">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Type</th>
                            <td>
                                <input type="radio" name="Type" value="topic"> Topic
                                <br>
                                <input type="radio" name="Type" value="lesson"> Lesson
                            </td>
                        </tr>
                        <tr>
                        <tr>
                            <th scope="row">Belonging Topic</th>
                            <td>
                                <select name="topic">
                                    <option value="Information Tech">Information Tech</option>
                                    <option value="Literature">Literature</option>
                                    <option value="English">English</option>
                                    <option value="Science">Science</option>
                                </select>
                            </td>
                            </td>

                        </tr>
                        <tr>
                            <th scope="row">Subject</th>
                            <td>
                                <select name="Subject">
                                    <option value="1">Machine Learning</option>
                                    <option value="2">Indigenous Canada</option>
                                    <option value="3">The Science of Well-Being</option>
                                    <option value="4">Financial Markets</option>
                                    <option value="5">Introduction to Psychology</option>
                                    <option value="6">Writing in the Sciences</option>
                                    <option value="7">Introduction to Statistics</option>
                                    <option value="8">Food and Health</option>
                                    <option value="9">Essential Strategies and Skills</option>
                                    <option value="10">Introduction to User Experience </option>
                                    <option value="11">Brand and Behavior</option>
                                    <option value="12">First Step Korean</option>
                                    <option value="13">Private Equity and Venture Capital</option>
                                    <option value="14">Primeros Auxilios Psicológicos (PAP)</option>
                                    <option value="15">Management of Fashion and Luxury </option>
                                    <option value="16">A Strategic Playbook</option>
                                    <option value="17">Principles of Sustainable Finance</option>
                                    <option value="18">Agile with Atlassian Jira</option>
                                </select>
                            </td>
                            </td>

                        </tr>
                        <tr>
                            <th scope="row">Order</th>
                            <td><input class="form-control" type="text" name="Order"   required="" aria-label="default input example">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td>
                                <input type="radio" name="status" value="Activate"> Activate
                                <br>
                                <input type="radio" name="status" value="Deactivate"> Deactivate
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Video Link</th>
                            <td><input class="form-control" type="text" name="Video"   required="" aria-label="default input example">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Content</th>
                            <td>
                                <textarea rows="" cols="" id="content" name="content" style="width: 820px;height: 175px;"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"></th>
                            <td><button style="color: red;color: white;background-color: #006dcc;font-style: oblique;font-weight: bold;border-radius: 10px;width: 150px;height: 50px;" type="submit">Add Lesson </button></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

        <script>
            var editor = '';
            $(document).ready(function () {
                editor = CKEDITOR.replace('content');
            });
        </script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
