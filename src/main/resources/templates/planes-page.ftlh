<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<#--<#if member.email??>-->
<#--    <h3>Username: ${member.name}</h3>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <input type="submit" value="Exit">-->
<#--    </form>-->
<#--<#else>-->
<#--    <h2>Login</h2>-->
<#--    <form action="/login" method="get">-->
<#--        <input type="submit" value="Enter"><br><br>-->
<#--    </form>-->
<#--    <a href="/registration">Registration a new member</a>-->
<#--</#if>-->


<hr>
<h2>Planes</h2>

<#if planes??>
<#list planes as plane>
    <#if plane??>
        <p><b>${plane.name}</b> ${plane.country} | <a href="/plane/${plane.id}">Click for detail info</a><br>
        ${plane.shortDescription}</p>
    <#else>No planes on this site!</#if>
</#list>
</#if><br>

<form action="/getPlane" method="get">
    Find by name: <input type="text" name="name">
    <input type="submit" value="Search"/>
</form>


<#if plane??>

    <p><b>${plane.name}</b> ${plane.country} | <a href="/plane/${plane.id}">Click for detail info</a><br>
        ${plane.shortDescription}</p>

    <form method="get" action="/plane/fuel/${plane.id}">
        Enter distance: <input type="text" name="dist">
        <#--        <input type="hidden" name="planeId" placeholder="dont write" value=${plane.id}><br>-->
        <input type="submit" value="Calculate">
    </form>

<#--    <#if dist??>    ${dist}<#else>Here will be ur result</#if>-->

</#if>


<hr>
<#--<#if member.email??>-->
<h3>Post a new plane:</h3>
<form action="/plane/create" method="post">
    Plane: <input type="text" name="name"/><br><br>
    Modification: <input type="text" name="modification"/><br><br>
    Short description: <input type="text" name="shortDescription"
                              placeholder="Enter short description about this plane"/><br><br>
    Country: <input type="text" name="country"><br><br>
    Price: <input type="number" name="price"><br><br>
    Crew and passengers capacity: <input type="text" name="crewAndPassengers"><br><br>
    Fuel capacity: <input type="text" name="fuelCapacity"><br><br>
    Consumption fuel per hour: <input type="text" name="consumeFuelPerHour"><br><br>
    Payload: <input type="text" name="payload"><br><br>
    Wing span: <input type="text" name="wingSpan"><br><br>
    Wing area: <input type="text" name="wingArea"><br><br>
    Empty mass: <input type="text" name="emptyMass"><br><br>
    Maximum take-off weight: <input type="text" name="maxTakeOffWeight"><br><br>
    Number of engines: <input type="text" name="engine"><br><br>
    Maximum speed: <input type="text" name="maxSpeed"><br><br>
    Cruising speed: <input type="text" name="cruisingSpeed"><br><br>
    Stall speed: <input type="text" name="stallSpeed"><br><br>
    Celling: <input type="text" name="celling"><br><br>
    Coefficient of aerodynamic quality: <input type="text" name="coeffOfAerodynamicQuality"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Post plane!">
</form>
<#--</#if>-->
</body>
</html>