package org.choongang.game.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.game.constants.GameResult;

import java.time.LocalDateTime;

@Data
@Builder
public class GameLog {
    private long num;
    private long seq;
    private long userNo;
    private String email;
    private String userName;
    private long userSeq;
    private String userPname;
    private String userPimg;
    private long userScore;
    private long comSeq;
    private String comPname;
    private String comPimg;
    private long comScore;
    private GameResult gameResult;
    private LocalDateTime regDt;
}