<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<h2>Calculation</h2>

<#if fuelConsumption??>
Fuel consumption on route with full fuel tank: ${fuelConsumption.consumeFuelOnRoute}<br>
Fuel remainder after trip: ${fuelConsumption.fuelRemainder}
<#else>Here will be ur result</#if>


</body>
</html>