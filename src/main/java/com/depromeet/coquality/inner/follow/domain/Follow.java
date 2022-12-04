package com.depromeet.coquality.inner.follow.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Follow {
    private Long fromUserId;
    private Long toUserId;

    public static Follow of(final Long fromUserId, final Long toUserId){
        return new Follow(fromUserId, toUserId);
    }
}
