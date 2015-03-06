<%-- 
    Document   : index
    Created on : Mar 3, 2015, 9:44:49 AM
    Author     : tni20865
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="wrapper" >
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
        <h2>No Login? <a href="signup"> Sign Up NOW!</a></h2>
        
</div>
  
