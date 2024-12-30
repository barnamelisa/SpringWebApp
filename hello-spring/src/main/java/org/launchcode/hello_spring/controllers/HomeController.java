package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Doar va reda pagina principala
 */
@Controller
public class HomeController {

    @GetMapping
    public String index(){
        return "index"; // returneaza numele template-ului
    }
}
