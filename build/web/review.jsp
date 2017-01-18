<%-- 
    Author     : jdb117
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Review Artist Listing</title>
        <link rel="stylesheet" href="main.css" >
    </head>
    <body>
        <div id="contentwrapper">
        <h1>Edit Artist Page</h1>
        <form method ="post" action = "acceptAuthorMessage">
            <input type="hidden" name="file" value="<%= request.getParameter("file")%>" >
            <table border="1"> <tbody>
                    <tr>
                        <td>Artist Name:</td>
                        <td><input type="text" name="name" value="<%=  request.getAttribute("artist_name")%>" size=50 ></td>
                    </tr>
                    <tr>
                        <td>Your favorite album(s) released by this artist:</td>
                        <td><input type="text" name="fav_a" value="<%=  request.getAttribute("fav_a")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Your favorite song(s) by this artist:</td>
                        <td><input type="text" name="fav_s" value="<%=  request.getAttribute("fav_s")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Your favorite member(s) of this group:</td>
                        <td><input type="text" name="fav_m" value="<%=  request.getAttribute("fav_m")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Shows attended:</td>
                        <td><input type="text" name="attended" value="<%=  request.getAttribute("attended")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Friends you know who also enjoy this artist:</td>
                        <td><input type="text" name="friends" value="<%=  request.getAttribute("friends")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Music mediums purchased:</td>
                        <td><input type="text" name="mediums" value="<%=  request.getAttribute("mediums")%>" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Comments:</td>
                        <td><textarea name="comments" rows="4" cols="50"><%=  request.getAttribute("comments")%></textarea></td>
                    </tr> 
                    <tr> 
                        <td>
                             <a id="buttonstyle" href ="listAuthorMessages?tempurlvar=<%=session.getAttribute("user_id")%>">Return to artist list</a>
                        </td>
                        <td>
                            <input id="buttonstyle" type="submit" value="Save Edited Artist" name="Submit" >
                        </td>
                    </tr>
                </table> 
            </form>
        </div>
    </body>
</html>
