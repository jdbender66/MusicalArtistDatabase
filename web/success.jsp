<%
    if ((session.getAttribute("user_id") == null) || (session.getAttribute("user_id") == "")) {
%>
<%-- 
    Author     : jdb117
--%>
You are not logged in<br/>
<a href="loginpage.jsp">Please Login</a>
<%} else {
        
%>
Welcome <%=session.getAttribute("user_name")%>
<a href='logout.jsp'>Log out</a>
<a href='index.jsp?tempuservar="
   <%=request.getParameter("tempuservar")%>"
                 '>See your music organizer!</a>


<%
    }
%>