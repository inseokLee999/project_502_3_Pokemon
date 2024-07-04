package org.choongang.member.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean termsAgree;
}