package com.depromeet.coquality.inner.follow.domain;


import com.depromeet.coquality.inner.follow.domain.policy.validation.FollowValidationPolicy;
import lombok.Getter;

@Getter
public class Follow {
    private Long fromUserId;
    private Long toUserId;

    private Follow(final Long fromUserId, final Long toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        FollowValidationPolicy.validateFollow(this);
    }

    public static Follow of(final Long fromUserId, final Long toUserId){
        return new Follow(fromUserId, toUserId);
    }
}
