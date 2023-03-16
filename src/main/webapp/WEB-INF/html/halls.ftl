<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Halls</title>
</head>
<body>

<#list halls as hall>
    <h3>Hall id: ${hall.getId()}</h3>
    <h3>Number of seats: ${hall.getNumberOfSeats()}</h3>
</#list>

<label for="form">Create a hall: </label>
<form method="post" action="/Cinema/admin/panel/halls" id="form">
    <label for="id">Enter a hall id:</label>
    <input type="number" name="id" id="id">
    <br/>
    <label for="number">Enter number of seats:</label>
    <input type="number" name="numberOfSeats" id="number">
    <input type="submit" value="Create">
</form>

</body>
</html>
