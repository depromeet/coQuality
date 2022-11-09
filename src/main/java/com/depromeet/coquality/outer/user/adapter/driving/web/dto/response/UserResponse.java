package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;


import lombok.Getter;

@Getter
public class UserResponse {
    private final Long userId;
    private final String nickname;

    private UserResponse(final Long userId, final String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public static UserResponse of(final Long userId, final String nickname){
        return new UserResponse(userId, nickname);
    }

}
