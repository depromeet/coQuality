package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;

import lombok.Getter;

@Getter
public class SignUpResponse {
    private String token;
    private Long userId;

    private SignUpResponse(final String token, final Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public static SignUpResponse of(final String token, final Long userId){
        return new SignUpResponse(token,userId);
    }
}
