<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <title>Sessions</title>
</head>
<body>
<#--<script>$("search-input").click(function(text) { alert(text) });</script>-->
<label for="search-input">Search the movie:</label>
<input type="search" id="search-input" name="search">
<button id="search">Search</button>
<#--<script>$.ajax({-->
<#--url: 'http://localhost:8080/Cinema/admin/panel/sessions/search',-->
<#--method: 'get',-->
<#--dataType: 'html',-->
<#--data: {text: 'Текст'},-->
<#--success: function(data){-->
<#--alert(data);-->
<#--}-->
<#--});</script>-->
<#list sessions as session>
    <h3>${session.getCost()}</h3>
    <h3>${session.getDateTime()}</h3>
    <h3>${session.getFilm().getTitle()}</h3>
</#list>
<label for="form">Create a session: </label>
<form method="post" action="/Cinema/admin/panel/sessions" id="form">
    <label for="hall">Select a hall:</label>
    <select size="1" id="hall" name="hallId">
        <#list halls as hall>
            <option value="${hall.getId()}">Hall id: ${hall.getId()} Number of seats: ${hall.getNumberOfSeats()}</option>
        </#list>
    </select>
    <br/>
    <label for="film">Select a film:</label>
    <select size="1" id="film" name="filmId">
        <#list films as film>
            <option value="${film.getId()}">Film id: ${film.getId()} Title: ${film.getTitle()}</option>
        </#list>
    </select>
    <br/>
    <label for="date">Select a date:</label>
    <input id="date" type="date" name="date">
    <br/>
    <label for="time">Select a time:</label>
    <input id="time" type="time" name="time">
    <br/>
    <label for="cost">Select a cost:</label>
    <input id="cost" type="number" name="cost">
    <input type="submit" value="Create">
</form>
</body>
</html>