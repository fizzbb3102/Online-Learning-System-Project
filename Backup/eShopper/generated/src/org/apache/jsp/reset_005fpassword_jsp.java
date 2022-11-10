package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reset_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login | Online Learn</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main_login.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"header\" id=\"header\">\n");
      out.write("            <div class=\"header-middle\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"logo pull-left\">\n");
      out.write("                                <h1 class=\"name\">Online Learn</h1>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div style=\"padding-right: 300px;\" class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-4 col-lg-offset-6\" >\n");
      out.write("                    <div class=\"login-form\">\n");
      out.write("                        <h2>Reset your password</h2>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <iframe name=\"dummyframe\" id=\"dummyframe\" style=\"display: none;\"></iframe>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer id=\"footer\">\n");
      out.write("            <div class=\"footer-top\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <div class=\"companyinfo\">\n");
      out.write("                                <h2><span>Online</span>-Learn</h2>\n");
      out.write("                                <p>...where success is the only option...</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-7\">\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"video-gallery text-center\">\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"iframe-img\">\n");
      out.write("                                            <img src=\"images/login/1.png\" alt=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"overlay-icon\">\n");
      out.write("                                            <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <p>IT Course</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"video-gallery text-center\">\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"iframe-img\">\n");
      out.write("                                            <img src=\"images/login/2.png\" alt=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"overlay-icon\">\n");
      out.write("                                            <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <p>Social Course</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"video-gallery text-center\">\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"iframe-img\">\n");
      out.write("                                            <img src=\"images/login/3.png\" alt=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"overlay-icon\">\n");
      out.write("                                            <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <p>Geography Course</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"video-gallery text-center\">\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"iframe-img\">\n");
      out.write("                                            <img src=\"images/login/4.png\" alt=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"overlay-icon\">\n");
      out.write("                                            <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                        </div> \n");
      out.write("                                    </a>\n");
      out.write("                                    <p>Science Course</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-widget\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h2>Online Learn</h2>\n");
      out.write("                                <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                    <li><a href=\"\">About</a></li>\n");
      out.write("                                    <li><a href=\"\">What We Offer</a></li>\n");
      out.write("                                    <li><a href=\"\">Leadership</a></li>\n");
      out.write("                                    <li><a href=\"\">Careers</a></li>\n");
      out.write("                                    <li><a href=\"\">Catalog</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h2>Community</h2>\n");
      out.write("                                <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                    <li><a href=\"\">Learners</a></li>\n");
      out.write("                                    <li><a href=\"\">Partners</a></li>\n");
      out.write("                                    <li><a href=\"\">Developers</a></li>\n");
      out.write("                                    <li><a href=\"\">Translators</a></li>\n");
      out.write("                                    <li><a href=\"\">Blog</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h2>Policies</h2>\n");
      out.write("                                <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                    <li><a href=\"\">Terms of Use</a></li>\n");
      out.write("                                    <li><a href=\"\">Privacy Policy</a></li>\n");
      out.write("                                    <li><a href=\"\">Refund Policy</a></li>\n");
      out.write("                                    <li><a href=\"\">Billing System</a></li>\n");
      out.write("                                    <li><a href=\"\">Ticket System</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h2>More</h2>\n");
      out.write("                                <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                    <li><a href=\"\">Press</a></li>\n");
      out.write("                                    <li><a href=\"\">Investors</a></li>\n");
      out.write("                                    <li><a href=\"\">Help</a></li>\n");
      out.write("                                    <li><a href=\"\">Contact</a></li>\n");
      out.write("                                    <li><a href=\"\">Articles</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3 col-sm-offset-1\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h1>\n");
      out.write("                                    <a href=\"#\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-facebook\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z\"/>\n");
      out.write("                                        </svg></a>\n");
      out.write("                                    <a href=\"#\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-twitter\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z\"/>\n");
      out.write("                                        </svg></a>\n");
      out.write("                                    <a href=\"#\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"orange\" class=\"bi bi-whatsapp\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z\"/>\n");
      out.write("                                        </svg></a>\n");
      out.write("                                    <a href=\"#\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"red\" class=\"bi bi-instagram\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z\"/>\n");
      out.write("                                        </svg></a>\n");
      out.write("                                </h1>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-bottom\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <p class=\"pull-left\">Copyright © 2022 Online Learn Inc. All rights reserved.</p>\n");
      out.write("                        <p class=\"pull-right\">Designed by <span><a target=\"_blank\" href=\"#\">Group 5</a></span></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                                    function showMessage() {\n");
      out.write("                                        var success_msg_style = document.getElementById(\"success_msg\").style;\n");
      out.write("                                        success_msg_style.display = 'block';\n");
      out.write("                                        var expired_msg_style = document.getElementById(\"expired_msg\").style;\n");
      out.write("                                        expired_msg_style.display = ' ';\n");
      out.write("                                    }\n");
      out.write("\n");
      out.write("                                    function passwordCheck() {\n");
      out.write("                                        alert('alo');\n");
      out.write("                                        \n");
      out.write("                                        var newPassword = document.getElementById('new_password').value;\n");
      out.write("                                        var renewPassword = document.getElementById('renew_password').value;\n");
      out.write("\n");
      out.write("                                        var match_old_password_msg_style = document.getElementById('match_old_password_msg').style;\n");
      out.write("                                        var matchOldPasswordCheck = false;\n");
      out.write("                                        if (oldPassword !== password) {\n");
      out.write("                                            match_old_password_msg_style.display = 'block';\n");
      out.write("                                            matchOldPasswordCheck = true;\n");
      out.write("                                        } else {\n");
      out.write("                                            old_password_row_style.display = 'none';\n");
      out.write("                                            matchOldPasswordCheck = false;\n");
      out.write("                                        }\n");
      out.write("\n");
      out.write("                                        var char_count_msg_style = document.getElementById('char_count_msg').style;\n");
      out.write("                                        var charCountCheck = true;\n");
      out.write("                                        if (newPassword.length < 6) {\n");
      out.write("                                            char_count_msg_style.display = 'block';\n");
      out.write("                                            charCountCheck = false;\n");
      out.write("                                        } else {\n");
      out.write("                                            char_count_msg_style.display = 'none';\n");
      out.write("                                            charCountCheck = true;\n");
      out.write("                                        }\n");
      out.write("\n");
      out.write("                                        var renew_password_row_style = document.getElementById('renew_password_row').style;\n");
      out.write("                                        var matchRenewPasswordCheck = true;\n");
      out.write("                                        if (newPassword !== renewPassword) {\n");
      out.write("                                            renew_password_row_style.display = 'block';\n");
      out.write("                                            matchRenewPasswordCheck = false;\n");
      out.write("                                        } else {\n");
      out.write("                                            renew_password_row_style.display = 'none';\n");
      out.write("                                            matchRenewPasswordCheck = true;\n");
      out.write("                                        }\n");
      out.write("\n");
      out.write("                                        if (matchOldPasswordCheck === true || charCountCheck === false || matchRenewPasswordCheck === false) {\n");
      out.write("                                            return false;\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${failed eq 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <p class=\"text-center\" style=\"color: red; font-size: 18px\">Reset password failed! Contact an admin for further instructions!</p>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${expired eq 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <p id=\"expired_msg\" class=\"text-center\" style=\"color: red; font-size: 18px\">This link is already expired. Please enter your Email Address to receive a new link.</p>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                            ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${verified eq 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <form id=\"getEmailForm\" name=\"getEmailForm\" action=\"resetpw\" target=\"dummyframe\" method=\"get\" onsubmit=\"showMessage()\">\n");
        out.write("                                    <input type=\"email\" name=\"email\" placeholder=\"Email Address\" required=\"\" />\n");
        out.write("                                    <button id=\"emailButton\" type=\"submit\" class=\"btn btn-default\" form=\"getEmailForm\">Reset Password</button>\n");
        out.write("                                </form>\n");
        out.write("                                <span id=\"success_msg\" style=\"color: green; display: none\">An email containing the Reset Password link has been sent to your Email address.</span>\n");
        out.write("                                <span>‎‎‎‎</span>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${verified eq 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <form id=\"resetPWform\" name=\"resetPWform\" action=\"resetpw\" method=\"POST\" onsubmit=\"return passwordCheck()\">\n");
        out.write("                                    <input type=\"password\" id=\"new_password\" name=\"new_password\" placeholder=\"Enter new password\" required=\"\" />\n");
        out.write("\n");
        out.write("                                    <span id=\"match_old_password_msg\" style=\"color: red; display: none\">New password must not match old password !</span>\n");
        out.write("                                    <span id=\"char_count_msg\" style=\"color: red; display: none\">Password must have at least 6 characters !</span>\n");
        out.write("\n");
        out.write("                                    <input type=\"password\" id=\"renew_password\" name=\"renew_password\" placeholder=\"Re-enter new password\" required=\"\" />\n");
        out.write("\n");
        out.write("                                    <span id=\"renew_password_msg\" style=\"color: red; display: none\">New password does not match !</span>\n");
        out.write("\n");
        out.write("                                    <button type=\"submit\" class=\"btn btn-primary\" form=\"resetPWform\">Reset Password</button>\n");
        out.write("                                </form>\n");
        out.write("\n");
        out.write("                                <span>‎‎‎‎‎‎\n");
        out.write("                                </span>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }
}
