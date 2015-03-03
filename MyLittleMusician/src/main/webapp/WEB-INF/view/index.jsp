<%-- 
    Document   : index
    Created on : Mar 3, 2015, 9:44:49 AM
    Author     : tni20865
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <h1>My Little Musician!</h1>
        <h2>Login</h2>
        <form method="POST" action="login">
            <table border="0">
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr><td colspan="2" align="center">
                <input type="submit" value="Login"></td>
            </tr>
            </table>
        </form>
        <h2>No Login? Sign Up NOW!</h2>
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
  
