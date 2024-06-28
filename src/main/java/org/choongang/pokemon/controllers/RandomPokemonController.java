package org.choongang.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.services.PokemonInfoService;

@Controller
@RequestMapping("/randompoke")
@RequiredArgsConstructor
public class RandomPokemonController {
    private final PokemonInfoService pokemonInfoService;
}
