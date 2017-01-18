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
import java.util.Date;
import java.util.regex.*;
import java.sql.*;

public class acceptAuthorMessage extends HttpServlet {
     private ResultSet rs = null;
     private ResultSet rs2 = null;
     private int tempint;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Boolean valid = false;
        String clean_name, clean_fava, clean_favs, clean_favm, clean_attended, clean_friends, clean_mediums, clean_comments;
        clean_name = request.getParameter ("name");
        clean_fava = request.getParameter ("fav_a");
        clean_favs = request.getParameter ("fav_s");
        clean_favm = request.getParameter ("fav_m");
        clean_attended = request.getParameter ("attended");
        clean_friends = request.getParameter ("friends");
        clean_mediums = request.getParameter ("mediums");
        clean_comments = request.getParameter ("comments");

        //open the DBMS and insert the record
        Connection conn = (Connection) request.getSession(false).getAttribute("myconn");
        Connection conn2 = (Connection)request.getSession(false).getAttribute("myconn");   
        try {
            Statement st = conn.createStatement();
            Statement st2 = conn2.createStatement();           
            String q2 = new String("select user_id from artists where artist_id =" + request.getParameter("file") + "");
            rs = st2.executeQuery(q2);
            while(rs.next())
                    {
                        tempint = rs.getInt("user_id");
                        String q1 = new String("UPDATE test.artists SET artists.artist_name = '" + clean_name.trim() + 
                                "', fav_a = '" + clean_fava.trim() + 
                                "', fav_s = '" + clean_favs.trim() + 
                                "', fav_m = '" + clean_favm.trim() + 
                                "', attended = '" + clean_attended.trim() + 
                                "', friends = '" + clean_friends.trim() + 
                                "', medium = '" + clean_mediums.trim() + 
                                "', comments = '" + clean_comments.trim() + 
                                "' WHERE artist_id = "+ request.getParameter("file") +"");
                        st.executeUpdate(q1);
                        st.close();
                        valid = true;
                    }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid) {
            out.println("<html>");
                out.println("<head><link rel=\"stylesheet\" href=\"main.css\" />");
                out.println("<title>Message Confirmation</title>");
                out.println("</head>");
                out.println("<body>");
                    out.println("<div id=\"contentwrapper\">");
                        out.println("<h1>Artist Update Complete</h1>");
                        out.println("<p>The artist was updated with the following information:</p><ol>");
                        out.println("<p>Artist name: "+clean_name+"</p>");
                        out.println("<p>Favorite Artist: " + clean_fava + "</p>");
                        out.println("<p>Favorite Song: " + clean_favs + "</p>");
                        out.println("<p>Favorite Member: " + clean_favm + "</p>");
                        out.println("<p>Shows Attended: " + clean_attended + "</p>");
                        out.println("<p>Friends who also enjoy this artist: " + clean_friends + "</p>");
                        out.println("<p>Music mediums purchased: " + clean_mediums + "</p>");
                        out.println("<p>Comments: " + clean_comments + "</p>");
                        out.println("</ol>");
                        out.println("<p><a id=\"buttonstyle\" href =\"listAuthorMessages?tempurlvar="+tempint+"\">Return to artist list</a></p>");
                    out.println("</div>");
                out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Artist Storage Problem</title>");
                out.println("</head>");
                out.println("<body>");
                    out.println("<div id=\"contentwrapper\">");
                        out.println("<h1>Error</h1>");
                        out.println("<p>We were unable to store the information for artist:</p><ol><p>");
                        out.println(request.getParameter("name"));
                        out.println("</p></ol>");
                        out.println("<p><a id=\"buttonstyle\" href =\"listAuthorMessages?tempurlvar="+tempint+"\">Return to artist list</a></p>");
                    out.println("</div>");
                out.println("</body>");
            out.println("</html>");
        }
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
