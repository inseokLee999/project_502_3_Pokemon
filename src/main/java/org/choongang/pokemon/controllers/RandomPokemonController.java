package org.choongang.pokemon.controllers;

import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@RequestMapping("random")
public class RandomPokemonController {

    @GetMapping
    public String index(){
        return "random/index";
    }
}
