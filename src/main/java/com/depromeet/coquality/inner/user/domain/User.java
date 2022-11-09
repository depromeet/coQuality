package com.depromeet.coquality.inner.user.domain;

import com.depromeet.coquality.inner.user.domain.policy.validation.UserValidationPolicy;
import lombok.Getter;

@Getter
public class User {
    private String nickname;
    private String socialId;
    private String socialEmail;

    private User(final String nickname, final String socialId, final String socialEmail) {
        this.nickname = nickname;
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        UserValidationPolicy.validate(this);
    }

    public static User of(final String socialId, final String socialEmail) {
        return new User(null, socialId, socialEmail);
    }

    public static User of(final String nickname, final String socialId, final String socialEmail){
        return new User(nickname, socialId, socialEmail);
    }
}
