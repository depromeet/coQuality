package com.depromeet.coquality.inner.user.vo;

import lombok.Getter;

@Getter
public class SignUpResponse {
    private String token;

    private SignUpResponse(final String token) {
        this.token = token;
    }

    public static SignUpResponse of(final String token){
        return new SignUpResponse(token);
    }
}
