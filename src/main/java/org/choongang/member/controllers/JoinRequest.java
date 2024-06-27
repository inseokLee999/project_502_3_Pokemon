package org.choongang.member.controllers;

import lombok.Data;

@Data
public class JoinRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean termsAgree;
}