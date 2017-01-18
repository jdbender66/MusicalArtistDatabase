package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class review_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=windows-1252");
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("        <title>Review Artist Listing</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"main.css\" >\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"contentwrapper\">\n");
      out.write("        <h1>Edit Artist Page</h1>\n");
      out.write("        <form method =\"post\" action = \"acceptAuthorMessage\">\n");
      out.write("            <input type=\"hidden\" name=\"file\" value=\"");
      out.print( request.getParameter("file"));
      out.write("\" >\n");
      out.write("            <table border=\"1\"> <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Artist Name:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" value=\"");
      out.print(  request.getAttribute("artist_name"));
      out.write("\" size=50 ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Your favorite album(s) released by this artist:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"fav_a\" value=\"");
      out.print(  request.getAttribute("fav_a"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Your favorite song(s) by this artist:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"fav_s\" value=\"");
      out.print(  request.getAttribute("fav_s"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Your favorite member(s) of this group:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"fav_m\" value=\"");
      out.print(  request.getAttribute("fav_m"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Shows attended:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"attended\" value=\"");
      out.print(  request.getAttribute("attended"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Friends you know who also enjoy this artist:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"friends\" value=\"");
      out.print(  request.getAttribute("friends"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Music mediums purchased:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"mediums\" value=\"");
      out.print(  request.getAttribute("mediums"));
      out.write("\" size=\"50\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Comments:</td>\n");
      out.write("                        <td><textarea name=\"comments\" rows=\"4\" cols=\"50\">");
      out.print(  request.getAttribute("comments"));
      out.write("</textarea></td>\n");
      out.write("                    </tr> \n");
      out.write("                    <tr> \n");
      out.write("                        <td>\n");
      out.write("                             <a id=\"buttonstyle\" href =\"listAuthorMessages?tempurlvar=");
      out.print(session.getAttribute("user_id"));
      out.write("\">Return to artist list</a>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"buttonstyle\" type=\"submit\" value=\"Save Edited Artist\" name=\"Submit\" >\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table> \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
