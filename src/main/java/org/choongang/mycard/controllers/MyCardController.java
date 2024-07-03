package org.choongang.mycard.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
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
    private final MemberUtil memberUtil;
    private final MemberMapper mapper;

    private HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);

    /*@GetMapping
    public String privatecard() {
        commonProcess();
        if (memberUtil.isLogin()) {
            Member member = mapper.get(((Member) session.getAttribute("member")).getEmail());
            long seq = member.getMyPokemonSeq();
            if (seq > 0L) {
                PokemonDetail data = infoService.get(seq).orElse(null);
                if (data != null) {
                    session.setAttribute("member", member);
                    request.setAttribute("data", data);
                }
            }
        }
        return "mycard/privatecard";
    }*/

    @GetMapping()
    public String play(PokemonSearch search) {
        commonProcess();
        addCssAttribute("mypage/style");

        List<PokemonDetail> items = pokemonService.getList();

        request.setAttribute("addScript", List.of("mypage/profile","mypage/info"));
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
        request.setAttribute("addCss", List.of("mycard/index"));
        request.setAttribute("addScript", List.of());

    }
    private void addCssAttribute(String css){
        List<String> addCss = new ArrayList<>();
        addCss.addAll((List<String>) request.getAttribute("addCss"));//기존에 있던 css들 불러오기
        addCss.add(css);
        request.setAttribute("addCss", addCss);

    }

}
