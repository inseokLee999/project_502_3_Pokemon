package org.choongang.mycard.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.controllers.PokemonSearch;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.MyPokemonService;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mycard")
@RequiredArgsConstructor
public class MyCardController {
    private final PokemonInfoService infoService;
    private final HttpServletRequest request;
    private final MyPokemonService pokemonService;
    /* @GetMapping("/privatecard") 에서
     ("/privatecard") 부분 지움         */
    @GetMapping("/privatecard")
    public String play(PokemonSearch search) {
        commonProcess();
        List<PokemonDetail> items = pokemonService.getList();
        addCssAttribute("mypage/profileUpdateStyle");
        request.setAttribute("items", items);
        return "mycard/privatecard";
    }


//    @GetMapping("/{seq}")
//    public String view(@PathVariable("seq") long seq){
//        commonProcess();
//        PokemonDetail data = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);
//        request.setAttribute("data", data);
//        return "mycard/view";
//    }

    private void commonProcess() {
        request.setAttribute("addCss", List.of("../mypage/profileUpdateStyle"));
        request.setAttribute("addScript", List.of());
    }
    private void addCssAttribute(String css){
        List<String> addCss = new ArrayList<>();
        addCss.addAll((List<String>) request.getAttribute("addCss"));//기존에 있던 css들 불러오기
        addCss.add(css);
        request.setAttribute("addCss", addCss);
    }
}
