<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<h3>Registration</h3>
<form method="post" action="/registration">
    Username: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    Phone number: <input type="text" name="phoneNumber" >
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Registration">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>