package org.choongang.boards.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/boards/pokemon")
public class PokemonController {
    @GetMapping
    public String index(){
        return "boards/pokemon/index";
    }
}
