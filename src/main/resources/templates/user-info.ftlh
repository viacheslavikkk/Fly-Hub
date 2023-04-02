<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<h3>User info</h3>
<hr>
<b>Name:</b> ${member.name}<br>
<b>Email:</b> ${member.email}<br>
<b>Phone number:</b> ${member.phoneNumber}<br>

<h4><b>${member.name}</b> planes</h4>
<#list plane as plane>
    <div>
        <p><b>${plane.name}</b>${plane.country} | <a href="/plane/${plane.id}">Click for detail info about plane</a></p>
    </div>
</#list>
</body>
</html>