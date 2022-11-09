package com.depromeet.coquality.inner.user.domain.policy.validation;

import com.depromeet.coquality.inner.user.domain.User;

public final class UserValidationPolicy {

    private UserValidationPolicy() {
    }

    public static void validate(final User user) {
        validateSocialId(user.getSocialId());
        validateSocialEmail(user.getSocialEmail());
    }

    //TODO exception 정리 필요
    private static void validateSocialEmail(final String socialEmail) {
        if (socialEmail == null){
            throw new IllegalArgumentException();
        }
    }

    private static void validateSocialId(final String socialId) {
        if (socialId == null){
            throw new IllegalArgumentException();
        }
    }
}
