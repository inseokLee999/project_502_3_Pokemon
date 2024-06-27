package org.choongang.member.controllers;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private boolean saveEmail;
    private String redirectUrl;
}
