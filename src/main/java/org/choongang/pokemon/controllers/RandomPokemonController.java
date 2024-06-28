package org.choongang.pokemon.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
@Controller
@RequestMapping("/random")
public class RandomPokemonController {

    @GetMapping
    public String index(){
        return "random/index";
    }
}
