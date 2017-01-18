/**
 *
 * @author jdb117
 */
package jdb117;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
import java.sql.*;

public class listAuthorMessages extends HttpServlet {
    private Statement st;
    private Statement st2;
    private ResultSet rs = null;
    private ResultSet rs2 = null;   
    private int i;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");      
        out.println("<title>Your Favorites</title>");
        out.println("</head><link rel=\"stylesheet\" href=\"main.css\" />");
        out.println("<body>");
        out.println("<div id=\"contentwrapper\">");
        out.println("<h1>Artist List</h1>");
        out.println("<ol>");
        try {
            Connection conn = (Connection)request.getSession(false).getAttribute("myconn");
            Connection conn2 = (Connection)request.getSession(false).getAttribute("myconn");
            st = conn.createStatement();
            st2 = conn2.createStatement();
            String q2 = new String("select * from members where id =" + request.getParameter("tempurlvar") + "");
            rs2 = st2.executeQuery(q2);
            while(rs2.next())
                    {
                        i = rs2.getInt("id");
                        String q1 = new String("select * from artists where user_id = "+i+" order by artist_name");
                        rs = st.executeQuery(q1);
                        while (rs.next()) {
                            out.println("<li><a href=\"reviewAuthorMessage?file="+rs.getString("artist_id")+"\">"+rs.getString("artist_name")+"</a></li>");
                        }
                        rs.close();
                        rs2.close();
                        st.close();
                    }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        out.println("</ol>");
        out.println("<p><a id=\"buttonstyle\" href =\"submit.jsp\">Click here to submit a new Artist</a></p>");
        out.println("<p><a id=\"buttonstyle\" href =\"logout.jsp\">LOGOUT</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
