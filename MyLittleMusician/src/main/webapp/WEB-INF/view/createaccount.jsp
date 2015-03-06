<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert account information</title>
    </head>
    <h2>Hello ${username}</h2>
    <h2>Insert account information</h2>
    <form method="POST" action="accountinformation">
        <table border="0">
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" ></td>
            </tr>
            <tr>
                <td>Profile</td>
                <td><textarea type="text" name="profile"> </textarea></td>
            </tr>

            <tr><td colspan="2" align="center">
                    <input type="submit" value="Save changes"></td>
            </tr>
        </table>
    </form> 
</html>

