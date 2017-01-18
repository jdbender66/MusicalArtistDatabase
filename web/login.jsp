<%-- 
    Author     : jdb117
--%>
<%@ page import ="java.sql.*" %>



<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ss_message", "TEST", "TEST");
    Statement st = con.createStatement();
    ResultSet rs;
    ResultSet rs2;
    
    String q1 = new String("select * from members where uname='" + userid + "' and pass='" + pwd + "'");
            rs =  st.executeQuery(q1);
    
    if (rs.next()) {
        session.setAttribute("user_name", userid);
        String tempuserid = new String("select id from members where uname='" + userid + "'");
        rs2 =  st.executeQuery(tempuserid);
        
        if(rs2.next()) {
        
        session.setAttribute("user_id", rs2.getInt("id"));
        
       
        
        
        } else {
            out.println("Not Registered");
        }
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("index.jsp?tempuservar="+session.getAttribute("user_id")+"");
        
    } else {
        out.println("Invalid password <a href='loginpage.jsp'>try again</a>");
    }
   
%>