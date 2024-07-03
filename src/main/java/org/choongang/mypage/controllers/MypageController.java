package org.choongang.mypage.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.mypage.services.ProfileService;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.services.MyPokemonService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    private final ProfileService profileService;
    private final MyPokemonService pokemonService;
    private final HttpServletRequest request;

    /**
     * 마이페이지 메인
     *
     * @return
     */
    @GetMapping
    public String index() {
        commonProcess();
//        request.setAttribute("addCss", new String[] {"mypage/mypageStyle"});
        addCssAttribute("mypage/mypageStyle");

        return "mypage/index";
    }

    /**
     * 회원 정보 확인 및 수정
     *
     * @return
     */
    @GetMapping("/info")
    public String info() {
        commonProcess();
        List<PokemonDetail> items = pokemonService.getList();

        request.setAttribute("addScript", List.of("mypage/profile","mypage/info"));
        addCssAttribute("mypage/profileUpdateStyle");
//        request.setAttribute("addCss", new String[] {"mypage/profileUpdateStyle"});
        request.setAttribute("items", items);

        return "mypage/info";
    }

    /**
     * 회원 정보 확인 및 수정
     * @return
     */
    @PostMapping("/info")
    public String infoPs(RequestProfile form) {

        profileService.update(form);

        String url = request.getContextPath() + "/mypage";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }

    @GetMapping("/alert")
    public String alert() {

        request.setAttribute("addCss", new String[] {"mypage/alertStyle"});

        return "mypage/alert";
    }

    private void commonProcess(){
        request.setAttribute("addCss", List.of("mypage/style"));
    }

    private void addCssAttribute(String css){
        List<String> addCss = new ArrayList<>();
        addCss.addAll((List<String>) request.getAttribute("addCss"));//기존에 있던 css들 불러오기
        addCss.add(css);
        request.setAttribute("addCss", addCss);
    }
}