<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sessions</title>
</head>
<body>
<label for="form">Create a session: </label>
<form method="post" action="/admin/panel/sessions" id="form">
    <label for="hall">Select a hall:</label>
    <select size="1" id="hall" name="hall">
        <#list halls as hall>
            <option value="${hall.getId()}">Hall id: ${hall.getId()} Number of seats: ${hall.getNumberOfSeats()}</option>
        </#list>
    </select>
    <br/>
    <label for="film">Select a film:</label>
    <select size="1" id="film" name="film">
        <#list films as film>
            <option value="${film.getId()}">Film id: ${film.getId()} Title: ${film.getTitle()}</option>
        </#list>
    </select>
    <br/>
    <label for="date">Select a date:</label>
    <input id="date" type="date" name="dateTime">
    <br/>
    <label for="cost">Select a cost:</label>
    <input id="cost" type="number" name="cost">
    <input type="submit" value="Create">
</form>
</body>
</html>