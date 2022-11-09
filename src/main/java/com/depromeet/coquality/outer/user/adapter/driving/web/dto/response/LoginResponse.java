package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;
    private Long userId;

    private LoginResponse(final String token, final Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public static LoginResponse of(final String token, final Long userId){
        return new LoginResponse(token,userId);
    }
}
