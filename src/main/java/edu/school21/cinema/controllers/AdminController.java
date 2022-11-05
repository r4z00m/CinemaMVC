package edu.school21.cinema.controllers;

import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/panel")
public class AdminController {

    private final HallService hallService;
    private final FilmService filmService;
    private final SessionService sessionService;

    @Autowired
    public AdminController(HallService hallService, FilmService filmService, SessionService sessionService) {
        this.hallService = hallService;
        this.filmService = filmService;
        this.sessionService = sessionService;
    }

    @GetMapping("/halls")
    public String getHalls() {
        System.out.println(hallService.findAll());
        return "hall";
    }

    @GetMapping("/films")
    public String getFilms() {
        System.out.println(filmService.findAll());
        return "film";
    }

    @GetMapping("/sessions")
    public String getSessions() {
        System.out.println(filmService.findAll());
        return "session";
    }
}
