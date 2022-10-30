<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Add New Subject | Online Learn</title>
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
            <c:if test = "${requestScope.mess!=null}">
                <div class="alert alert-warning" style="text-align: center;" role="alert">
                    Category must be 1 (Information Tech) - 2 (Literaturesss) - 4 (English) - 6 (asd)
                </div>                    </c:if>
                <h2>New Subject</h2>
                <form action="NewSubjectController" method="post">
                    <table class="table table-striped">
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Title</th>
                                <td><input class="form-control" type="text" name="Title"  required="" aria-label="default input example">
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Thumbnail</th>
                                <td>
                                    <input type="file" id="image_input" name="Thumbnail">
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Category</th>
                                <td>
                                    <select name="Category">
                                        <option value="1">Information Tech</option>
                                        <option value="2">Literature</option>
                                        <option value="4">English</option>
                                        <option value="6">Science</option>
                                    </select>
                                </td>

                            </tr>
                            <tr>
                                <th scope="row">Brief Info</th>
                                <td>
                                    <textarea rows = "5" cols = "50" name = "Brief">
                                    </textarea>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Author</th>
                                <td><input class="form-control" type="text" name="Author"   required="" aria-label="default input example">
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Featured Flag</th>
                                <td>
                                    <input type="checkbox" id="flag" name="Flag" value="flaged">
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Introduction</th>
                                <td>
                                    <textarea rows="" cols="" id="Introduction" name="Introduction" style="width: 820px;height: 175px;">${getLessonByDetail.conent}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">List Price</th>
                            <td><input class="form-control" type="text" name="price"  required="" aria-label="default input example">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Sale Price</th>
                            <td><input class="form-control" type="text" name="sale"   required="" aria-label="default input example">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td>
                                <input type="radio" name="status" value="activate"> Activate
                                <br>
                                <input type="radio" name="status" value="deactivate"> Deactivate
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"></th>
                            <td><button style="color: red;color: white;background-color: #006dcc;font-style: oblique;font-weight: bold;border-radius: 10px;width: 150px;height: 50px;" type="submit">Add Subject </button></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

        <script>
            const image_input = document.querySelector("#image_input");
            var uploaded_image;

            image_input.addEventListener('change', function () {
                const reader = new FileReader();
                reader.addEventListener('load', () => {
                    uploaded_image = reader.result;
                    document.querySelector("#display_image").style.backgroundImage = `url(${uploaded_image})`;
                });
                reader.readAsDataURL(this.files[0]);
            });
        </script>
        <script>
            var editor = '';
            $(document).ready(function () {
                editor = CKEDITOR.replace('Introduction');
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
