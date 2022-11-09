/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin.Slider;

import dao.SlideDAO;
import entity.Slide;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class SlidersListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            defaultList(request, response);
        } else {
            switch (action) {
                case "changeStatus":
                    changeStatus(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "editGet":
                    editGet(request, response);
                    break;
                case "addGet":
                    addGet(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listAfterSelected(request, response);
                break;
            case "editPost":
                editPost(request, response);
                break;
            case "addPost":
                addPost(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }

    }

    private void defaultList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        int count = slideDAO.countSlides();
        int endPage = count / 4;
        if (count % 4 != 0) {
            endPage++;
        }

        String indexPage = request.getParameter("index");
        int index;
        if (indexPage == null || indexPage.trim().isEmpty()) {
            index = 1;
        } else {
            index = Integer.parseInt(indexPage);
        }
        List<Slide> slideList = slideDAO.getPagingSlide("all", index);
        request.setAttribute("slideList", slideList);
        request.setAttribute("tag", index);
        request.setAttribute("endPage", endPage);
        request.getRequestDispatcher("/Admin/SliderSetting/slider_list.jsp").forward(request, response);
    }

    private void listAfterSelected(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        String indexPage = request.getParameter("index");
        int index;
        if (indexPage == null || indexPage.trim().isEmpty()) {
            index = 1;
        } else {
            index = Integer.parseInt(indexPage);
        }
        List<Slide> slideList = new ArrayList<>();
        String[] option = request.getParameterValues("option");
        String selected = null;
        for (String string : option) {
            slideList = slideDAO.getPagingSlide(string, index);
            selected = string;
        }
        int count = slideList.size();
        int endPage = count / 4;
        if (count % 4 != 0) {
            endPage++;
        }
        request.setAttribute("selected", selected);
        request.setAttribute("slideList", slideList);
        request.setAttribute("tag", index);
        request.setAttribute("endPage", endPage);
        request.getRequestDispatcher("/Admin/SliderSetting/slider_list.jsp").forward(request, response);
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Slide slide = slideDAO.getSlidebyId(id);
        if (slide.getStatus().equals("active")) {
            slideDAO.changeStatus("deactive", id);
        } else {
            slideDAO.changeStatus("active", id);
        }
        response.sendRedirect("sliders_list_controller");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = slideDAO.deleteSlide(id);
        if (result == true) {
            response.sendRedirect("sliders_list_controller");
        } else {
            response.sendRedirect("sliders_list_controller");
        }
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Slide slide = slideDAO.getSlidebyId(id);
        request.setAttribute("slideGetById", slide);
        request.setAttribute("id", id);
        request.getRequestDispatcher("/Admin/SliderSetting/edit.jsp").forward(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            FileItem idItem = items.get(0);
            FileItem titleItem = items.get(1);
            FileItem descriptionItem = items.get(2);
            FileItem imageItem = items.get(3);
            FileItem statusItem = items.get(4);

            int id = Integer.parseInt(idItem.getString());
            String title = titleItem.getString();
            String description = descriptionItem.getString();
            String image = FilenameUtils.getName(imageItem.getName());
            String status = statusItem.getString();
            Slide slide = new Slide(id, title, description, image, status);
            boolean result = slideDAO.updateSlide(slide);
            if (result) {
                response.sendRedirect("sliders_list_controller?action=editGet&id=" + id);
            } else {
                request.getRequestDispatcher("edit_slider_controller?id=" + slide.getId()).forward(request, response);
            }
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }
    }

    private void addGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Admin/SliderSetting/add.jsp").forward(request, response);
    }

    private void addPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideDAO slideDAO = new SlideDAO();
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            FileItem titleItem = items.get(1);
            FileItem descriptionItem = items.get(2);
            FileItem imageItem = items.get(3);
            FileItem statusItem = items.get(4);

            String title = titleItem.getString();
            String description = descriptionItem.getString();
            String image = FilenameUtils.getName(imageItem.getName());
            String status = statusItem.getString();
            Slide slide = new Slide(title, description, image, status);
            boolean result = slideDAO.addSlide(slide);
            if (result == true) {
                response.sendRedirect("sliders_list_controller");
            } else {
                response.sendRedirect("add_slide_controller");
            }
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txtSearch");
        SlideDAO slideDAO = new SlideDAO();
        List<Slide> slideList = slideDAO.searchSlide(txtSearch);
        request.setAttribute("txtSearch", txtSearch);
        request.setAttribute("slideList", slideList);
        request.getRequestDispatcher("/Admin/SliderSetting/slider_list.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}