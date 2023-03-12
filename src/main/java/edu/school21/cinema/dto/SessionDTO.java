package edu.school21.cinema.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SessionDTO {
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateTime;
    private FilmDTO film;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
        this.film = film;
    }
}
