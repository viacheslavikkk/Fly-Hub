<!DOCTYPE html>
<html>
<head>
    <title>FLY-HUB</title>
</head>
<body>
<h1>FLY-HUB</h1>
<hr>
<h3>Detail information about plane</h3>
<b>Plane:</b> ${plane.name}<br>
<b>Modification:</b> ${plane.modification}<br>
<b>Short description:</b> ${plane.shortDescription}<br>
<b>Country:</b> ${plane.country}<br>
<b>Price:</b> ${plane.price}<br>
<b> Crew and passengers capacity:</b> ${plane.crewAndPassengers}<br>
<b> Fuel capacity:</b> ${plane.fuelCapacity}<br>
<b>Consumption fuel per hour:</b> ${plane.consumeFuelPerHour}<br>
<b> Payload:</b> ${plane.payload}<br>
<b> Wing span:</b>${plane.wingSpan}<br>
<b> Wing area:</b> ${plane.wingArea}<br>
<b> Empty </b> ${plane.emptyMass}<br>
<b> Maximum take-off weight:</b> ${plane.maxTakeOffWeight}<br>
<b> Number of engines:</b> ${plane.engine}<br>
<b> Maximum speed:</b> ${plane.maxSpeed}<br>
<b> Cruising speed:</b> ${plane.cruisingSpeed}<br>
<b> Stall speed:</b> ${plane.stallSpeed}<br>
<b> Celling:</b> ${plane.celling}<br>
<b> Coefficient of aerodynamic quality:</b> ${plane.coeffOfAerodynamicQuality}<br><hr><br>

<form action="/plane/delete/${plane.id}" method="get">
    <input type="submit" value="Delete this plane">
</form>

</body>
</html>