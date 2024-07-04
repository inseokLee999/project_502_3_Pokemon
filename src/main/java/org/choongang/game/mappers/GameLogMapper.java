package org.choongang.game.mappers;

import org.choongang.game.controllers.GameLogSearch;
import org.choongang.game.entities.GameLog;

import java.util.List;

public interface GameLogMapper {
    List<GameLog> getList(GameLogSearch search);
    int getTotal(GameLogSearch search);
    int register(GameLog log);
}