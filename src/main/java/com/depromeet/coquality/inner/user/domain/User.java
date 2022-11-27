package com.depromeet.coquality.inner.user.domain;

import com.depromeet.coquality.inner.user.domain.policy.validation.UserValidationPolicy;
import lombok.Getter;

@Getter
public class User {
    private String nickname;
    private String socialId;
    private String socialEmail;
    private String profileImageUrl;
    private String userSummary;

    private User(final String nickname, final String socialId, final String socialEmail, final String profileImageUrl, final String userSummary) {
        this.nickname = nickname;
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        UserValidationPolicy.validate(this);
    }

    public static User of(final String nickname, final String socialId, final String socialEmail){
        return new User(nickname, socialId, socialEmail, null, null);
    }
    public static User of(final String nickname, final String socialEmail, final String profileImageUrl, final String userSummary){
        return new User( nickname,null, socialEmail, profileImageUrl, userSummary);
    }

    public void updateUserInfo(final String nickname, final String socialEmail, final String userSummary) {
        this.nickname = nickname;
        this.socialEmail = socialEmail;
        this.userSummary = userSummary;
    }
}
