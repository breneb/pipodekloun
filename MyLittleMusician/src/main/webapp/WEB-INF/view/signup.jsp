<%-- 
    Document   : signup
    Created on : Mar 6, 2015, 9:53:18 AM
    Author     : tni20865
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SIGN UP</h1>
        <p>${success}</p>
        <form method="POST" action="registration">
            <table border="0">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"  value="${usernamereg}" ></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password1" value="${password1}"></td>
                </tr>
                <tr>
                    <td>Retype Password</td>
                    <td><input type="password" name="password2"></td>
                </tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" value="Sign Up"></td>
                </tr>
            </table>
        </form> 
    </body>
</html>
