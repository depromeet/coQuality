package com.depromeet.coquality.inner.user.vo;

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
