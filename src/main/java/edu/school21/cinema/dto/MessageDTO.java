package edu.school21.cinema.dto;

public class MessageDTO {
    private String name;
    private String filmId;

    public MessageDTO() {
    }

    public MessageDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
