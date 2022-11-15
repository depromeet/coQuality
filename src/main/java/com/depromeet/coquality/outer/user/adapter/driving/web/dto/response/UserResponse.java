package com.depromeet.coquality.outer.user.adapter.driving.web.dto.response;


import lombok.Getter;

@Getter
public class UserResponse {
    private final Long userId;
    private final String nickname;
    private final String profileImageUrl;
    private final String email;
    private final String userSummary;

    private UserResponse(final Long userId, final String nickname, final String profileImageUrl, final String email, final String userSummary) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.email = email;
        this.userSummary = userSummary;
    }

    public static UserResponse of(final Long userId, final String nickname, final String profileImageUrl, final String email, final String userSummary){
        return new UserResponse(userId, nickname, profileImageUrl, email, userSummary);
    }

}
