<%-- 
    Author     : jdb117
--%>


<%@ page import ="java.sql.*" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.DateFormat" %>
<%@ page import ="java.text.SimpleDateFormat" %>



<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ss_message", "TEST", "TEST");
    Statement st = con.createStatement();
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String DateString = dateFormat.format(date);
    String q1 = new String("insert into MEMBERS(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', '" + DateString + "')");
           
    
    
    int i = st.executeUpdate(q1);
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("loginpage.jsp");
    }
%>