<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Session </title>
</head>
<body>
<h3>${session.getId()}</h3>
<h3>${session.getDateTime()}</h3>
<h3>${session.getCost()}</h3>
<h3>${session.getHall().getId()}</h3>
<h3>${session.getHall().getNumberOfSeats()}</h3>
<h3>${session.getFilm().getId()}</h3>
<h3>${session.getFilm().getTitle()}</h3>
<h3>${session.getFilm().getYearOfRelease()}</h3>
<h3>${session.getFilm().getAgeRestriction()}</h3>
<h3>${session.getFilm().getDescription()}</h3>
<h3>${session.getFilm().getPosterName()}</h3>
</body>
</html>