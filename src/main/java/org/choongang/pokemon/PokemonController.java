package org.choongang.pokemon;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    @GetMapping("/board")
    public String board(){
        return "pokemon/board";
    }
}
