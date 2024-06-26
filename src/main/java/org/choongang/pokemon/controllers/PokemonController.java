package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.services.PokemonInfoService;
import org.choongang.pokemon.services.PokemonSaveService;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {
    private final HttpServletRequest request;
    private final PokemonInfoService pokemonInfoService;
    private final PokemonSaveService pokemonSaveService;

    @GetMapping()
    public String index() {
        commonProcess();
//        pokemonSaveService.save(pokemonInfoService);
        String uri = request.getRequestURI();

        System.out.println(uri);
        return "pokemon/index";
    }

    private void commonProcess() {
        request.setAttribute("addCss", List.of("pokemon/style"));
    }
}