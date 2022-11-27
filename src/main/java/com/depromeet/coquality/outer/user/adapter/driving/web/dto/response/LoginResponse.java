package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;

    private LoginResponse(final String token) {
        this.token = token;
    }

    public static LoginResponse of(final String token){
        return new LoginResponse(token);
    }
}
