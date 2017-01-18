<%-- 
    Author     : jdb117
--%>

<%
session.setAttribute("user_id", null);
session.invalidate();
response.sendRedirect("loginpage.jsp");
%>
