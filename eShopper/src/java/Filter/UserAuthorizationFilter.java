/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import entity.Account;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthorizationFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public UserAuthorizationFilter() {
    }

    private boolean isAdminPage(String uri) {
        if (uri.startsWith("/admin")) {
            return true;
        }
        return false;
    }

    private boolean isAccessable(String uri, String[] actionList) {
        for (String action : actionList) {
            if (uri.equals(action)) {
                return true;
            }
        }
        return false;
    }

    private static final String[] expertActions = {
        "/profile",
        "/LessonController",
        "/my_course",
        "/sliders_list_controller",
        "/class_detail_controller",
        "/pie_chart_controller",
        "/admin/subject/list",
        "/admin/registration_list",
        "/ClassListController",
        "/class_detail_controller",
        "/NewSubjectController",
        "/SubjectLessonController",
        "/LessonDetailController",
        "/EditLessonDetailController"};

    private static final String[] marketingActions = {
        "/profile",
        "/admin/post/delete",
        "/admin/post/detail",
        "/admin/post/list",
        "/admin/post/add",
        "/sliders_list_controller"};

    private static final String[] saleActions = {
        "/profile"};

    private static final String[] customerActions = {
        "/profile",
        "/LessonController",
        "/my_course",
        "/LessonViewController"};

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("UserAuthorizationFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("UserAuthorizationFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("UserAuthorizationFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = req.getSession();
            Account currentAccount = (Account) req.getSession().getAttribute("currentUser");
            //check if user is logged in, redirect to login page if not
            if (currentAccount == null) {
                resp.sendRedirect(req.getContextPath() + "/login_controller");
            } else {
                //get role of current user
                int role_id = currentAccount.getRole_id();
                String uri = req.getRequestURI().substring(req.getContextPath().length());
                switch (role_id) {
                    //Admin
                    case 1:
                        chain.doFilter(request, response);
                        break;

                    //Expert
                    case 2:
                        if (isAccessable(uri, expertActions)) {
                            chain.doFilter(request, response);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/list_home_controller");
                        }
                        break;

                    //Marketing
                    case 3:
                        if (isAccessable(uri, marketingActions)) {
                            chain.doFilter(request, response);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/list_home_controller");
                        }
                        break;

                    //Sale
                    case 4:
                        if (isAccessable(uri, saleActions)) {
                            chain.doFilter(request, response);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/list_home_controller");
                        }
                        break;

                    //Customer
                    case 5:
                        if (isAccessable(uri, customerActions)) {
                            chain.doFilter(request, response);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/list_home_controller");
                        }
                        break;

                    //Guess
                    case 6:
                        if (isAdminPage(uri)) {
                            resp.sendRedirect(req.getContextPath() + "/list_home_controller");
                        }
                        break;
                }

            }
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("UserAuthorizationFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("UserAuthorizationFilter()");
        }
        StringBuffer sb = new StringBuffer("UserAuthorizationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
