<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Films</title>
</head>
<body>

<#list films as film>
    <h3>${film.getId()}</h3>
    <h3>${film.getTitle()}</h3>
    <h3>${film.getYearOfRelease()}</h3>
    <h3>${film.getAgeRestriction()}</h3>
    <h3>${film.getDescription()}</h3>
</#list>

<label for="form">Create a film:</label>
<form method="post" action="/admin/panel/films" id="form">
    <label for="title">Enter the title:</label>
    <input type="text" name="title" id="title">
    <br/>
    <label for="yearOfRelease">Enter year of release:</label>
    <input type="number" name="yearOfRelease" id="yearOfRelease">
    <br/>
    <label for="ageRestriction">Enter age restriction:</label>
    <input type="number" name="ageRestriction" id="ageRestriction">
    <br/>
    <label for="description">Enter the description:</label>
    <input type="text" name="description" id="description">
    <br/>
    <input type="submit" value="Create">
</form>

</body>
</html>