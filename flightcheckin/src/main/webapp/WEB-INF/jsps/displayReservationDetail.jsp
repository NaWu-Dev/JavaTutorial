<html>
<head>
    <title>Display reservation details</title>
</head>
<body>
<pre>
<h2>Flight Details</h2>
Airline: ${reservation.flight.operatingAirlines} <br>
Flight Number: ${reservation.flight.flightNumber}<br>
Departure City: ${reservation.flight.departureCity}<br>
Arrival City: ${reservation.flight.arrivalCity}<br>
Date of departure: ${reservation.flight.dateOfDeparture}<br>
Estimated departure time: ${reservation.flight.estimatedDepartureTime}<br>

<h2>Passenger Details</h2>
First Name: ${reservation.passenger.firstName}<br>
Last Name: ${reservation.passenger.lastName}<br>
Email: ${reservation.passenger.email}<br>
Phone: ${reservation.passenger.phone}<br>

<form action="completeCheckin" method="post">
    Enter number of bags: <input type="text" name="numberOfBags"/><br>
    <input type="hidden" name="reservationId" value="${reservation.id}"/>
    <input type="submit" value="Checkin"/>
</form>
</pre>
</body>
</html>