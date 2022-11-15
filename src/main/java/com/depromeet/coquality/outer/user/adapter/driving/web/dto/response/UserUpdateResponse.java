package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;

import lombok.Getter;

@Getter
public class UserUpdateResponse {

    private final Long userId;
    private final String nickname;
    private final String email;
    private final String userSummary;

    private UserUpdateResponse(final Long userId, final String nickname, final String email, final String userSummary) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.userSummary = userSummary;
    }

    public static UserUpdateResponse of(final Long userId, final String nickname, final String email, final String userSummary) {
        return new UserUpdateResponse(userId, nickname, email, userSummary);
    }
}
