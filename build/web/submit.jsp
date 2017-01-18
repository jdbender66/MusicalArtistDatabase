<%-- 
    Author     : jdb117
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit New Artist</title>
        <link rel="stylesheet" href="main.css" >
    </head>
    <body>
        <div id="contentwrapper">
            <h1>Submit New Artist</h1>
            <form method ="post" action = "submitMessage">
                <table border="1">
                    <tr>
                    <td>
                        <h2>Field:</h2>
                    </td>
                    <td>
                        <input type="hidden" name="uname" value="<%= session.getAttribute("user_name")%>"> 
                        <h2>Submission:</h2>
                    </td>
                     </tr>
                    <tr>
                        <td>Artist Name:</td>
                        <td><input type="text" name="name" value="" size="50" ></td>
                    </tr>
                     <tr>
                        <td>Your favorite album(s) released by this artist:</td>
                        <td><input type="text" name="fav_a" value="" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Your favorite song(s) by this artist:</td>
                        <td><input type="text" name="fav_s" value="" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Your favorite member(s) of this group:</td>
                        <td><input type="text" name="fav_m" value="" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Shows attended:</td>
                        <td><input type="text" name="attended" value="" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Friends you know who also enjoy this artist:</td>
                        <td><input type="text" name="friends" value="" size="50" ></td>
                    </tr>
                    <tr>
                        <td>Music mediums purchased:</td>
                        <td><input type="text" name="mediums" value="" size="50"></td>
                    </tr>
                    <tr>
                        <td>Comments:</td>
                        <td><textarea name="comments" rows="8" cols="50"></textarea></td>
                    </tr>
                    <tr>
                        <td> <a id="buttonstyle" href ="listAuthorMessages?tempurlvar=<%=session.getAttribute("user_id")%>">Return to artist list</a></td>
                        <td><input id="buttonstyle" type="submit" value="Submit" name="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
