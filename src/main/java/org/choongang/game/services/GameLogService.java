package org.choongang.game.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.game.controllers.GameLogSearch;
import org.choongang.game.entities.GameLog;
import org.choongang.game.mappers.GameLogMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameLogService {
    private final GameLogMapper mapper;

    public ListData<GameLog> getList(GameLogSearch search) {
        int page = Math.max(search.getPage(), 1);
        int limit = search.getLimit();
        limit = limit < 1 ? 20 : limit;

        int offset = (page - 1) * limit + 1;
        int endRows = offset + limit;

        search.setOffset(offset);
        search.setEndRows(endRows);

        List<GameLog> items = mapper.getList(search);

        int total = mapper.getTotal(search);

        Pagination pagination = new Pagination(page, total, 10, limit, BeanContainer.getInstance().getBean(HttpServletRequest.class));

        return new ListData<>(items, pagination);
    }
}