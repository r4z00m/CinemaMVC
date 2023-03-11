package edu.school21.cinema.services;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.FilmRepository;
import edu.school21.cinema.repositories.HallRepository;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final HallRepository hallRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository, HallRepository hallRepository, FilmRepository filmRepository) {
        this.sessionRepository = sessionRepository;
        this.hallRepository = hallRepository;
        this.filmRepository = filmRepository;
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public void save(int hallId, int filmId, String date, String time, int cost) {
        Hall hall = hallRepository.findById(hallId);
        Film film = filmRepository.findById(filmId);
        Session session = new Session();
        session.setHall(hall);
        session.setFilm(film);
        session.setDateTime(getDate(date, time));
        session.setCost(cost);
        sessionRepository.save(session);
    }

    private LocalDateTime getDate(String date, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date + " " + time, formatter);
    }

    public List<Session> search(String filmName) {
        return sessionRepository.findByTitle(filmName);
    }
}
