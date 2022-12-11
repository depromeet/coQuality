package com.depromeet.coquality.inner.follow.vo;

import lombok.Getter;

@Getter
public class FollowerResponse {
    private Long userId;
    private String nickname;
    private String profileImage;

    private FollowerResponse(final Long userId, final String nickname, final String profileImage) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileImage = profileImage;
    }
    public static FollowerResponse of(final Long userId, final String nickname, final String profileImage){
        return new FollowerResponse(userId, nickname, profileImage);
    }
}
