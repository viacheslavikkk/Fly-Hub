<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<h3>Authentication</h3>
<form method="post" action="/login">
    Email <input type="email" name="username"><br><br>
    Password <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Enter">
</form>

</body>
</html>