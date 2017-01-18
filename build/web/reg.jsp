<%-- 
    Author     : jdb117
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site Registration</title>
        <link rel="stylesheet" href="main.css" >
    </head>
    <body>
        <div id="contentwrapper">
            <form method="post" action="registration.jsp">
                <center>
                    <h1>PERSONAL MUSIC ORGANIZER</h1>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registration:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>First Name</td>
                                <td><input type="text" name="fname" value="" /></td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                                <td><input type="text" name="lname" value="" /></td>
                            </tr>
                            <tr>
                                <td>Email Address</td>
                                <td><input type="text" name="email" value="" /></td>
                            </tr>
                            <tr>
                                <td>User Name</td>
                                <td><input type="text" name="uname" value="" /></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="pass" value="" /></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Submit" /></td>
                                <td><input type="reset" value="Reset" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><a id="buttonstyle" href="loginpage.jsp">Return to login page</a></td>
                            </tr>
                        </tbody>
                    </table>
                </center>
            </form>
        </div>
    </body>
</html>