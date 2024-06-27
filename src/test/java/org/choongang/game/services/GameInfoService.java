package org.choongang.game.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.services.ApiRequestService;
import org.choongang.global.services.ObjectMapperService;
import org.choongang.pokemon.entities.api.Pokemon;
import org.choongang.pokemon.services.PokemonSaveService;

import java.net.http.HttpResponse;
import java.util.Optional;
@RequiredArgsConstructor
public class GameInfoService {

    private final ApiRequestService service;
    private final ObjectMapperService om;
    private final PokemonSaveService saveService;


    /**
     * 조회 번호로 포켓몬 상세 정보 조회 업데이트
     *
     * @param seq
     * @return
     */
    public Optional<Pokemon> update(long seq) {
/*        String url = apiUrl + "/pokemon/" + seq;

        Pokemon pokemon = null;
        HttpResponse<String> response = service.request(url);

        if (response.statusCode() == HttpServletResponse.SC_OK) {
            try {
                pokemon = om.readValue(response.body(), Pokemon.class);
                pokemon.setRawData(response.body());

                saveService.save(pokemon);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }*/

        return null;
    }
}
