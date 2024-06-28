package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.services.PokemonInfoService;

@Controller
@RequestMapping("/random")
@RequiredArgsConstructor
public class RandomPokemonController {
    private final PokemonInfoService infoService;
    private final MemberUtil memberUtil;
    private final HttpServletRequest request;
    @GetMapping
    public String index(){
        Member member = memberUtil.getMember();
        long seq = member.getMyPokemonSeq();
        if (seq > 0L) {
            PokemonDetail data = infoService.get(seq).orElse(null);
            if (data != null) {
                System.out.println(data);
                request.setAttribute("data", data);
            }
        }
        return "random/index";
    }
}
