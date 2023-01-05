package com.depromeet.coquality.inner.user.vo;


import lombok.Getter;

@Getter
public class UserResponse {
    private final Long userId;
    private final String nickname;

    private final String userSummary;
    private final String userRank;

    private UserResponse(final Long userId, final String nickname, final String userSummary, final String userRank) {
        this.userId = userId;
        this.nickname = nickname;
        this.userSummary = userSummary;
        this.userRank = userRank;
    }

    public static UserResponse of(final Long userId, final String nickname, final String userSummary, final String userRank){
        return new UserResponse(userId, nickname, userSummary, userRank);
    }

}
