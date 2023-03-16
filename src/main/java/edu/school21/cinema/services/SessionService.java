package edu.school21.cinema.services;

import edu.school21.cinema.dto.FilmDTO;
import edu.school21.cinema.dto.SessionDTO;
import edu.school21.cinema.dto.SessionResponseDTO;
import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.FilmRepository;
import edu.school21.cinema.repositories.HallRepository;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
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

    @Transactional
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

    private Date getDate(String date, String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return formatter.parse(date + " " + time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public SessionResponseDTO search(String filmName) {
        SessionResponseDTO sessionResponseDTO = new SessionResponseDTO();
        List<Session> sessions = sessionRepository.findByTitle(filmName);
        List<SessionDTO> sessionDTOS = new ArrayList<>();
        for (Session session : sessions) {
            SessionDTO sessionDTO = new SessionDTO();
            sessionDTO.setId(session.getId());
            sessionDTO.setDateTime(session.getDateTime());
            FilmDTO filmDTO = new FilmDTO();
            filmDTO.setName(session.getFilm().getTitle());
            filmDTO.setPosterUrl(session.getFilm().getPosterName());
            sessionDTO.setFilm(filmDTO);
            sessionDTOS.add(sessionDTO);
        }
        sessionResponseDTO.setSessions(sessionDTOS);
        return sessionResponseDTO;
    }

    public Session findById(int id) {
        return sessionRepository.findById(id);
    }
}
