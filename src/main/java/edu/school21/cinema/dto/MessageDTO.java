package edu.school21.cinema.dto;

public class MessageDTO {
    private int id;
    private String message;
    private int filmId;
    private int userId;

    public MessageDTO() {
    }

    public MessageDTO(int id, String message, int filmId, int userId) {
        this.id = id;
        this.message = message;
        this.filmId = filmId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
