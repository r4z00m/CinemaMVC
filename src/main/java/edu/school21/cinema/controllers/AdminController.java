package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getHalls(Model model) {
        model.addAttribute("halls", hallService.findAll());
        return "hall";
    }

    @PostMapping("/halls")
    public String createHall(Model model, Hall hall) {
        hallService.save(hall);
        model.addAttribute("halls", hallService.findAll());
        return "hall";
    }

    @GetMapping("/films")
    public String getFilms(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "film";
    }

    @PostMapping("/films")
    public String createFilm(Model model, Film film) {
        filmService.save(film);
        model.addAttribute("films", filmService.findAll());
        return "film";
    }

    @GetMapping("/sessions")
    public String getSessions(Model model) {
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("films", filmService.findAll());
        model.addAttribute("sessions", sessionService.findAll());
        return "session";
    }

    @PostMapping("/sessions")
    public String createSession(Model model,
                                @RequestParam int hall,
                                @RequestParam int film,
                                @RequestParam int cost) {
        System.out.println(cost);
        System.out.println(hall);
        System.out.println(film);
//        sessionService.save(session);
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("films", filmService.findAll());
        model.addAttribute("sessions", sessionService.findAll());
        return "session";
    }
}
