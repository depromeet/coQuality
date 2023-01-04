package com.depromeet.coquality.inner.follow.vo;

import lombok.Getter;

@Getter
public class FollowCountResponse {
    //Long 변환
    private int followerCount;
    private int followingCount;

    private FollowCountResponse(final int followerCount, final int followingCount) {
        this.followerCount = followerCount;
        this.followingCount = followingCount;
    }
    public static FollowCountResponse of(final int followerCount, final int followingCount){
        return new FollowCountResponse(followerCount, followingCount);
    }
}
