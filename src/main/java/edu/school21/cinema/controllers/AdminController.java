package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin/panel")
public class AdminController {

    private final HallService hallService;
    private final FilmService filmService;
    private final SessionService sessionService;
    private final ImageService imageService;

    @Autowired
    public AdminController(HallService hallService, FilmService filmService, SessionService sessionService, ImageService imageService) {
        this.hallService = hallService;
        this.filmService = filmService;
        this.sessionService = sessionService;
        this.imageService = imageService;
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
        return "redirect:/admin/panel/halls";
    }

    @GetMapping("/films")
    public String getFilms(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "film";
    }

    @PostMapping(value = "/films", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createFilm(Model model, Film film,
                             @RequestPart MultipartFile image) {
        imageService.save(image);
        film.setPosterName(image.getOriginalFilename());
        filmService.save(film);
        model.addAttribute("films", filmService.findAll());
        return "redirect:/admin/panel/films";
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
                                @RequestParam int hallId,
                                @RequestParam int filmId,
                                @RequestParam String date,
                                @RequestParam String time,
                                @RequestParam int cost) {
        sessionService.save(hallId, filmId, date, time, cost);
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("films", filmService.findAll());
        model.addAttribute("sessions", sessionService.findAll());
        return "redirect:/admin/panel/sessions";
    }

    @ResponseBody
    @GetMapping(value = "/sessions/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Session>> searchResult(@RequestParam(value = "filmName") String filmName) {
        return new ResponseEntity<>(sessionService.search(filmName), HttpStatus.OK);
    }
}
