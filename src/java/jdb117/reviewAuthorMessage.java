/**
 *
 * @author jdb117
 */
package jdb117;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class reviewAuthorMessage extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = (Connection) request.getSession(false).getAttribute("myconn");
            Statement st = conn.createStatement();
            String q1 = new String("SELECT * FROM artists WHERE artist_id = " +
                    request.getParameter("file"));
            ResultSet rs = st.executeQuery(q1);
            if (rs.next()) {
                request.setAttribute("artist_name", rs.getString("artist_name"));
                request.setAttribute("fav_a", rs.getString("fav_a"));
                request.setAttribute("fav_s", rs.getString("fav_s"));
                request.setAttribute("fav_m", rs.getString("fav_m"));
                request.setAttribute("attended", rs.getString("attended"));
                request.setAttribute("friends", rs.getString("friends"));
                request.setAttribute("mediums", rs.getString("medium"));
                request.setAttribute("comments", rs.getString("comments"));
            } else {
                request.setAttribute("author", "");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/review.jsp");
        rd.forward(request, response);
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
    protected void

doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void

doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

/** 
 * Returns a short description of the servlet.
 * @return a String containing servlet description
 */
@Override
    public String getServletInfo(

) {
        return "Short description";
    }// </editor-fold>
}
