package com.depromeet.coquality.inner.follow.domain.policy.validation;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.inner.follow.domain.Follow;

public final class FollowValidationPolicy {
    public static void validateFollow(final Follow follow){
        validateFollowFromUserId(follow.getFromUserId());
        validateFollowToUserId(follow.getToUserId());
    }

    private static void validateFollowToUserId(final Long toUserId) {
        if (toUserId == null){
            throw CoQualityDomainExceptionCode.USER_IS_NOT_EXIST.newInstance();
        }

    }

    private static void validateFollowFromUserId(final Long fromUserId) {
        if (fromUserId == null){
            throw CoQualityDomainExceptionCode.USER_IS_NOT_EXIST.newInstance();
        }
    }
}
