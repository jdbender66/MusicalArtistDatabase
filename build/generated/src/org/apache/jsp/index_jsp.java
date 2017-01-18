package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("        <title>Author Listing Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"main.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"contentwrapper\">\n");
      out.write("            <h1>FAVORITE ARTISTS ORGANIZER</h1>\n");
      out.write("            <form method =\"post\" action = \"listAuthorMessages?tempurlvar=");
      out.print(request.getParameter("tempuservar"));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"tempuname\" value=\"");
      out.print( session.getAttribute("user_name"));
      out.write("\">\n");
      out.write("                <h2>Welcome, you are now logged in.</h2>\n");
      out.write("                <h3>User Stats:</h3>\n");
      out.write("                <ul>\n");
      out.write("                    ");

                    Connection conn=null;
                    Connection conn2=null;
                    Statement st;
                    ResultSet rs=null;
                    Statement st2;
                    ResultSet rs2=null;
                    
                     try{
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            String connectionURL = "jdbc:derby://localhost:1527/ss_message";
                            conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
                            conn2 = DriverManager.getConnection(connectionURL, "TEST", "TEST");
                            // here we attach the connection to a session variable
                            session.setAttribute("myconn", conn);
                            st = conn.createStatement();
                            st2 = conn2.createStatement();
                            int foo = Integer.parseInt(request.getParameter("tempuservar"));

                            String q1 = new String("SELECT * FROM members WHERE id = "+foo+"");
                            String q2 = new String("SELECT COUNT(*) AS rowcount FROM artists WHERE user_id = "+foo+"");
                            rs =  st.executeQuery(q1);
                            rs2 =  st2.executeQuery(q2);
                            while(rs.next())
                                {
                                    
                                    out.print("<li>First Name: "+rs.getString("first_name")+"</li>");
                                    out.print("<li>Last Name: "+rs.getString("last_name")+"</li>");
                                    out.print("<li>Email Address: "+rs.getString("email")+"</li>");
                                    out.print("<li>Registration Date: "+rs.getString("regdate")+"</li>");
                                    out.print("<li>User ID: "+rs.getString("id")+"</li>");
                                    
                                    
                                    
                
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <input type=\"hidden\" name=\"author\" value=\"");
      out.print(rs.getString("first_name"));
      out.write("\">\n");
      out.write("\n");
      out.write("                ");

                                }
                            rs2.next();
                            int counter = rs2.getInt("rowcount");
                            rs2.close();
                              
                            
                            out.print("<h3>Number of artists in database: "+counter+"</h3>");
                                    
                            rs.close();
                            st.close();
                            rs2.close();
                            st2.close();
                         }
                    catch( ClassNotFoundException cnfe){
                        cnfe.printStackTrace();
                    }
                    catch (SQLException se){
                        se.printStackTrace();
                    }
                 
      out.write("\n");
      out.write("                  <input id=\"buttonstyle\" type=\"submit\" value=\"Enter Database\" name=\"List\" />\n");
      out.write("            </form>\n");
      out.write("            <p><a id=\"buttonstyle\" href =\"logout.jsp\">LOGOUT</a></p>\n");
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
