package edu.school21.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/panel")
public class AdminController {

    @GetMapping("/halls")
    public String getHalls() {
        return "index";
    }

    @GetMapping("/films")
    public String getFilms() {
        return "index";
    }

    @GetMapping("/sessions")
    public String getSessions() {
        return "index";
    }
}
