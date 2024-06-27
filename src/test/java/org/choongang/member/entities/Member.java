package org.choongang.member.entities;

import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
public class Member {
        private int userNo;
        private String email;
        private String password;
        private String userName;
        private UserType userType = UserType.USER;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
}
