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
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequestMapping("/mycard")
@RequiredArgsConstructor
public class MyCardController {
    private final PokemonInfoService infoService;
    private final HttpServletRequest request;

    /* @GetMapping("/privatecard") 에서
     ("/privatecard") 부분 지움         */
    @GetMapping("/privatecard")
    public String play(PokemonSearch search) {
        commonProcess();
        ListData<PokemonDetail> listData = infoService.getList(search);
        List<PokemonDetail> items = listData.getItems();
        Pagination pagination = listData.getPagination();

        request.setAttribute("items", items);
        request.setAttribute("pagination", pagination);
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
        request.setAttribute("addCss", new String[] {});
        request.setAttribute("addScript", List.of());
    }
}
