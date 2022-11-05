package com.depromeet.coquality.inner.user.domain;

import lombok.Getter;

@Getter
public class User {
    private String nickname;
    private String socialId;
    private String socialEmail;
    private String socialType;

    private User(final String socialId, final String socialEmail, final String socialType) {
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        this.socialType = socialType;
    }
    public static User of(final String socialId, final String socialEmail, final String socialType){
        return new User(socialId, socialEmail, socialType);
    }
}
