<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Films</title>
</head>
<body>

<#list films as film>
    <#if film.getPosterName()?has_content >
        <img src="${springMacroRequestContext.contextPath}/images/${film.getPosterName()}" alt="${film.getPosterName()}">
    <#else>
        <img src="${springMacroRequestContext.contextPath}/images/default.jpeg" alt="default.jpeg">
    </#if>
    <h4>${film.getId()} ${film.getTitle()} ${film.getYearOfRelease()} ${film.getAgeRestriction()} ${film.getDescription()}</h4>
</#list>

<label for="form">Create a film:</label>
<form method="post" action="/Cinema/admin/panel/films" id="form" enctype="multipart/form-data">
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
    <label for="image">Choose a poster:</label>
    <input type="file" accept="image/*" name="image" id="image">
    <br/>
    <input type="submit" value="Create">
</form>

</body>
</html>