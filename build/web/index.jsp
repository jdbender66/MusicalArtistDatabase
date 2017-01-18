<%-- 
    Author     : jdb117
--%>

<%@ page language="java" import="javax.servlet.ServletException" %>
<%@ page language="java" import="javax.servlet.http.HttpServlet" %>
<%@ page language="java" import="javax.servlet.http.HttpServletRequest" %>
<%@ page language="java" import="javax.servlet.http.HttpServletResponse" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Author Listing Page</title>
        <link rel="stylesheet" href="main.css" />
    </head>
    <body>
        
        <div id="contentwrapper">
            <h1>FAVORITE ARTISTS ORGANIZER</h1>
            <form method ="post" action = "listAuthorMessages?tempurlvar=<%=request.getParameter("tempuservar")%>">
                <input type="hidden" name="tempuname" value="<%= session.getAttribute("user_name")%>">
                <h2>Welcome, you are now logged in.</h2>
                <h3>User Stats:</h3>
                <ul>
                    <%
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
                                    
                                    
                                    
                %>
                </ul>
                <input type="hidden" name="author" value="<%=rs.getString("first_name")%>">

                <%
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
                 %>
                  <input id="buttonstyle" type="submit" value="Enter Database" name="List" />
            </form>
            <p><a id="buttonstyle" href ="logout.jsp">LOGOUT</a></p>
        </div>
    </body>
</html>
