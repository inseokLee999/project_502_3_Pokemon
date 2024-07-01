package org.choongang.member.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
        private long userNo;
        private String email;
        private String password;
        private String userName;
        private UserType userType = UserType.USER;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
        private long myPokemonSeq;
}
