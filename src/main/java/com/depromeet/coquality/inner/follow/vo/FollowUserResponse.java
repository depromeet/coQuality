package com.depromeet.coquality.inner.follow.vo;

import lombok.Getter;

@Getter
public class FollowUserResponse {
    private Long userId;
    private String nickname;
    private String profileImage;

    private FollowUserResponse(final Long userId, final String nickname, final String profileImage) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileImage = profileImage;
    }
    public static FollowUserResponse of(final Long userId, final String nickname, final String profileImage){
        return new FollowUserResponse(userId, nickname, profileImage);
    }
}
