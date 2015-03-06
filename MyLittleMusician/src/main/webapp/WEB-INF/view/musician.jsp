<%-- 
    Document   : musician
    Created on : Mar 2, 2015, 10:49:26 AM
    Author     : tni20865
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musician</title>
    </head>
    <body>
        <h1>Hello ${username}!</h1>
        
        <p>${musician.getProfile()}</p>
        <p>${musician.getEmail()}</p>
         
    </body>
</html>
