<%-- 
    Author     : jdb117
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Organizer</title>
        <link rel="stylesheet" href="main.css" >
    </head>
    <body>
        <div id="contentwrapper">
            <form method="post" action="login.jsp">
                <center>
                    <h1>FAVORITE ARTISTS ORGANIZER</h1>
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">User Login</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="uname" value="" /></td>
                        </tr>

                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value="" /></td>
                        </tr>
                        <tr>
                            <td><input id="buttonstyle" type="submit" value="Login" /></td>
                            <td><input id="buttonstyle" type="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><a id="buttonstyle" href="reg.jsp">REGISTER</a></td>
                        </tr>
                    </tbody>
                </table>
                </center>
            </form>
            <p id="demo"> </p>

            <script>
            document.getElementById("demo").innerHTML = "Current Date & Time: "+Date();
            </script>

        </div>
    </body>
</html>
