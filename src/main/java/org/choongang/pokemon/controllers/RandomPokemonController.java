package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.GetRandPokemon;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/random")
@RequiredArgsConstructor
public class RandomPokemonController {
    private final PokemonInfoService infoService;
    private final MemberUtil memberUtil;
    private final HttpServletRequest request;
    private final MemberMapper mapper;

    private HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
    @GetMapping
    public String index() {
        commonProcess();
        if (memberUtil.isLogin()) {
            Member member = mapper.get(((Member) session.getAttribute("member")).getEmail());
            long seq = member.getMyPokemonSeq();
            if (seq > 0L) {
                PokemonDetail data = infoService.get(seq).orElse(null);
                if (data != null) {
                    request.setAttribute("data", data);
                }
            }
        }
        return "random/index";
    }
    @PostMapping()
    public int getRandPokemon() {
        Member member = (Member) session.getAttribute("member");
        PokemonDetail data = infoService.getRandom().orElse(null);
        GetRandPokemon getRandPokemon = new GetRandPokemon();
        getRandPokemon.setSeq(data.getSeq());
        getRandPokemon.setUserNo(member.getUserNo());
        return mapper.getPokemon(getRandPokemon);
    }
    private void commonProcess() {
        request.setAttribute("addCss", new String[] {});
        request.setAttribute("addScript", List.of("random/getRandom"));
    }
}
