package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class JoinRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean termsAgree;
}