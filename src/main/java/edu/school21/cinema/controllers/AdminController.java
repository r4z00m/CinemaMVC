package edu.school21.cinema.controllers;

import edu.school21.cinema.dto.Greeting;
import edu.school21.cinema.dto.MessageDTO;
import edu.school21.cinema.dto.SessionResponseDTO;
import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/panel")
public class AdminController {

    private final HallService hallService;
    private final FilmService filmService;
    private final SessionService sessionService;
    private final ImageService imageService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

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
        return "halls";
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
        return "films";
    }

    @GetMapping("/films/{filmId}/chat")
    public String getFilmChat(Model model,
                              @PathVariable int filmId,
                              @CookieValue(value = "user", defaultValue = "") String cookie,
                              HttpServletResponse response) {
        System.out.println(cookie);
        if (cookie.isEmpty()) {
            Cookie userCookie = new Cookie("user", "1");
            userCookie.setPath("/");
            userCookie.setMaxAge(120);
            response.addCookie(userCookie);
        }
        model.addAttribute("film", filmService.findById(filmId));
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
        return "sessions";
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
    public ResponseEntity<SessionResponseDTO> searchResult(@RequestParam(value = "filmName") String filmName) {
        if (filmName.isEmpty()) {
            return new ResponseEntity<>(new SessionResponseDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>(sessionService.search(filmName), HttpStatus.OK);
    }

    @GetMapping("/session/{id}")
    public String session(Model model, @PathVariable String id) {
        model.addAttribute("session", sessionService.findById(Integer.parseInt(id)));
        return "session";
    }

    @MessageMapping("/hello")
//    @SendTo("/film/chat/messages")
    public Greeting greeting(MessageDTO messageDTO) throws Exception {
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend("/film/" + messageDTO.getFilmId() + "/chat/messages", new Greeting("Hello, " + HtmlUtils.htmlEscape(messageDTO.getName()) + "!"));
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(messageDTO.getName()) + "!");
    }

    @GetMapping("/haha")
    public String hello(Model model) {
        model.addAttribute("film", filmService.findById(1));
        return "index";
    }
}
