<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Display Flights</title>
</head>
<body>
<h2>Display Flights</h2>
<form>
    <table>
        <tr>
            <th>Airline</th>
            <th>Departure City</th>
            <th>Arrival City</th>
            <th>Departure Time</th>
        </tr>
        <c:forEach var="tempFlight" items="${flights}">
            <tr>
                <td>${tempFlight.operatingAirlines}</td>
                <td>${tempFlight.departureCity}</td>
                <td>${tempFlight.arrivalCity}</td>
                <td>${tempFlight.estimatedDepartureTime}</td>
                <td><a href="showCompleteReservation?flightId=${tempFlight.id}">Details</a> </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>