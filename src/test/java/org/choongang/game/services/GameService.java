package org.choongang.game.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.choongang.game.mappers.GameMapper;
import org.choongang.global.config.annotations.Service;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.entities.api.Pokemon;
import org.choongang.pokemon.mappers.PokemonMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;


@Getter
@Service
public class GameService {

    /**
     * 1. 게임시작 웹에서get
     * 2. DB에서 개인소유 포켓못 불러옴
     * 3. 대결할 상대 포켓몬 랜덤 선택후 대결 계산
     * 4. 승자 확인 후 디비에 저장
     * 5. 웹에post
     */

    /* km 추가  S */

//    Member member = gameMapper.get(form.getUserId());



    // 게임 루프




            /* km 추가  E */
        }











