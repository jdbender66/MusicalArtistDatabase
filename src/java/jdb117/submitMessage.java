/**
 *
 * @author jdb117
 */

package jdb117;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class submitMessage extends HttpServlet {
    private Connection conn;
    private Connection conn2;
    private ResultSet rs = null;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Boolean valid = false;
        String clean_name, clean_fava, clean_favs, clean_favm, clean_attended, clean_friends, clean_mediums, clean_comments;
        Statement st;
        Statement st2;
        int tempinteger = 0;
        String tempuserid = null;
        String q1 = null;
       
        clean_name = request.getParameter ("name");
        clean_fava = request.getParameter ("fav_a");
        clean_favs = request.getParameter ("fav_s");
        clean_favm = request.getParameter ("fav_m");
        clean_attended = request.getParameter ("attended");
        clean_friends = request.getParameter ("friends");
        clean_mediums = request.getParameter ("mediums");
        clean_comments = request.getParameter ("comments");
        
        String tempusername = request.getParameter("uname");
                
        //open the DBMS and insert the record
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/ss_message";
            conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
            conn2 = DriverManager.getConnection(connectionURL, "TEST", "TEST");
            st = conn.createStatement();
            st2 = conn2.createStatement();
            tempuserid = new String("SELECT id FROM members WHERE uname = '"+tempusername+"'");  
            rs = st2.executeQuery(tempuserid);
            while(rs.next())
            {
                tempinteger = rs.getInt("id");
            }
            q1 = new String("INSERT INTO artists (artist_name, fav_a, fav_s, fav_m, attended, friends, medium, comments, user_id) VALUES ('" +
                clean_name+"', '" +
                clean_fava+"', '" +
                clean_favs+"', '" +
                clean_favm+"', '" +
                clean_attended+"', '" +
                clean_friends+"', '" +
                clean_mediums+"', '" +
                clean_comments+"', " +    
                tempinteger + ")");
                st.execute(q1);
                valid=true;
        }
        catch( ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (SQLException se)
        {
            se.printStackTrace();  
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        out.println("<html>");
        out.println("<head><link rel=\"stylesheet\" href=\"main.css\" >");
        out.println("<title>Message Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=\"contentwrapper\">");
        out.println("<h1>Artist submit to database for user:  " + tempusername+ "</h1>");
        out.println("<p>We stored the following artist info:</p><ol>");
        out.println("<p>Artist name: "+clean_name+"</p>");
        out.println("<p>Favorite Artist: " + clean_fava + "</p>");
        out.println("<p>Favorite Song: " + clean_favs + "</p>");
        out.println("<p>Favorite Member: " + clean_favm + "</p>");
        out.println("<p>Shows Attended: " + clean_attended + "</p>");
        out.println("<p>Friends who also enjoy this artist: " + clean_friends + "</p>");
        out.println("<p>Music mediums purchased: " + clean_mediums + "</p>");
        out.println("<p>Comments: " + clean_comments + "</p>");
        out.println("</ol>");
        out.println("<h3><a id=\"buttonstyle\" href =\"listAuthorMessages?tempurlvar="+tempinteger+"\">Return to artist list</a></h3>");        
        out.println("</body>");
        out.println("</html>");
        }
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Storage Problem</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=\"contentwrapper\">");
        out.println("<h1>Error with artist submission for user: " + tempusername + "</h1>");
        out.println("<p>We were unable to store artist info for:</p><ol><p>");
        out.println("<p>Artist name: "+clean_name+"</p>");
        out.println("<p>Favorite Artist: " + clean_fava + "</p>");
        out.println("<p>Favorite Song: " + clean_favs + "</p>");
        out.println("<p>Favorite Member: " + clean_favm + "</p>");
        out.println("<p>Shows Attended: " + clean_attended + "</p>");
        out.println("<p>Friends who also enjoy this artist: " + clean_friends + "</p>");
        out.println("<p>Music mediums purchased: " + clean_mediums + "</p>");
        out.println("<p>Comments: " + clean_comments + "</p>");
        out.println("</p></ol>");
        out.println("<h3><a id=\"buttonstyle\" href =\"listAuthorMessages?tempurlvar="+tempinteger+"\">Return to artist list</a></h3>");   
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");   
        }
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
