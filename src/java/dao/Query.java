/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

public class Query {

    //=================== Course List ==========================================
    String get5Features = "SELECT * FROM courselist order by updatedDate desc limit 5";
    String getNumberOfCourseList = "select count(*) from courselist";
    String pagingCourseList = "select * from courselist order by updatedDate desc limit 8 offset ?";
    String getNumberOfSearch = "select count(*) from courselist where title like ?";
    String pagingSearch = "select * from courselist where title like ? order by updatedDate desc limit 6 offset ?";
    String getCourseByDate = "select * from courselist where updatedDate between ? and ?";
    String getAllCoursesList = "select * from courselist";
    String deleteRegisteredCourseByClassId = "delete from registered_courses where class_id = ?";
    String getTop1CourseEachCate = "select (select courseid from courselist where  category = t.category group by courseid limit 1) \n" +
"id_top_course from courselist t group by t.category";
    String getCourseById = "select * from courselist where courseid = ?";
    //=================== Category ==========================================
    String getAllCategories = "select * from blog_category";

    //=================== Slide ==========================================
    String getAllSlides = "SELECT * FROM slide";
    String getPagingActiveOrNonActiveSlides = "SELECT * FROM slide where status = ? order by id limit 4 offset ?;";
    String countSlide = "select count(*) as total from slide";
    String getPagingSlide = "select * from slide where ? is not null order by id limit 4 offset ?";
    String getSlideById = "select * from slide where id = ?";
    String updateSlide = "update slide set name = ?, detail = ?, image = ?, status = ? where id = ?";
    String addSlide = "insert into slide (name, detail, image, status) values (?, ?, ?, ?)";
    String deleteSlide = "delete from slide where id = ?";
    String changeStatus = "update slide set status = ? where id = ?";
    String searchSlide = "select * from slide where name like ?";

    //=================== Blog ==========================================
    String getAllBlogs = "select * from blog";
    String getAllBlogsByBlogCateId = "select b.*, a.name, a.image, a.job, bc.name from blog as b, blog_category as bc, author as a "
            + "where b.blog_category_id = bc.id and b.author_id = a.id and bc.id = ? order by b.updated_date desc";
    String getBlogById = "select * from swp391.blog where id = ?";
    String getBlogsToPostHomePage = "select b.id, b.short_detail, b.detail, b.author_id, a.name, a.job, a.image "
            + "from author as a  inner join blog as b where b.author_id = a.id";
    String getBlogByAuthorId = "select b.* from blog as b where b.author_id = ?";
    String getBlogByTitle = "select b.*, a.name, a.image, a.job, bc.name from blog as b, blog_category as bc, author as a \n"
            + "where b.blog_category_id = bc.id and b.author_id = a.id and b.title like ? order by b.updated_date desc";
    String countBlog = "select count(*) as total from swp391.blog";
    String countBlogByCateId = "select count(*) as total from blog as b where b.blog_category_id = ?";
    String pagingBlog = "select b.*, a.name, a.image, a.job, bc.name as blog_category_name from blog as b, blog_category as bc, author as a "
            + "where b.blog_category_id = bc.id and b.author_id = a.id order by b.updated_date desc limit 4 offset ?";
    String pagingBlogByCateId = "select b.*, a.name, a.image, a.job, bc.name as blog_category_name from blog as b, blog_category as bc, author as a\n"
            + "where b.blog_category_id = bc.id and b.author_id = a.id and bc.id = ? order by b.updated_date desc limit 4 offset ?";
    String getTop5Blog = "select * from blog order by updated_date desc limit 5";
    //=================== Blog Category ==========================================
    String getBlogCateNameById = "select bc.name from blog_category as bc where bc.id = ?";
    String getAllBlogCates = "select bc.* from blog_category as bc";

    //=================== Login ==========================================
    String login = "select * from account where email = ? and password = ? ";

    //=================== Author ==========================================
    String getAuthorById = "select a.* from author as a where a.id = ?";
    String getAllAuthors = "select a.* from author as a";

    //=================== Lesson ==========================================
    String getLesson = "SELECT * FROM lesson";
    String getLessonById = "select * from lesson where id = ?";

    //=================== Account ==========================================
    String updateAccountInfo = "UPDATE `swp391`.`account`\n"
            + "SET\n"
            + "`fullname` = ?,\n"
            + "`phone` = ?\n"
            + "WHERE `aid` = ?;";
    String changeAccountPassword = "UPDATE `swp391`.`account`\n"
            + "SET\n"
            + "`password` = ?\n"
            + "WHERE `aid` = ?;";
    String getAccountInfo = "SELECT account.*\n"
            + "    FROM account\n"
            + "    WHERE account.aid = ?;";
    String getAccountsByDate = "select * from account where created_at between ? and ?";
//=================== Class ============================================
    String getAllClass = "SELECT * FROM class order by id";
    String updateClass = "update class set name = ?, teacher = ?, status = ?, note = ? where id = ?";
    String getClassById = "SELECT * FROM class where id = ?";
    String deleteClass = "delete from class where id = ?";
    String addClass = "insert into class (name, teacher, status, note) values (?, ?, ?, ?)";
}
