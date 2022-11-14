package com.depromeet.coquality.inner.user.domain.policy.validation;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.inner.user.domain.User;

public final class UserValidationPolicy {

    private UserValidationPolicy() {
    }

    public static void validate(final User user) {
        validateSocialId(user.getSocialId());
        validateSocialEmail(user.getSocialEmail());
        validateNickname(user.getNickname());
    }

    private static void validateSocialEmail(final String socialEmail) {
        if (socialEmail == null){
            throw CoQualityDomainExceptionCode.User_SOCIAL_EMAIL_IS_NULL.newInstance();
        }
    }

    private static void validateSocialId(final String socialId) {
        if (socialId == null){
            throw CoQualityDomainExceptionCode.USER_SOCIAL_ID_IS_NULL.newInstance();
        }
    }

    private static void validateNickname(final String nickname) {
        if (nickname == null){
            throw CoQualityDomainExceptionCode.USER_SOCIAL_NICKNAME_IS_NULL.newInstance();
        }
    }

}
