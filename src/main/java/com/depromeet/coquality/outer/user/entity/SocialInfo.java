package com.depromeet.coquality.outer.user.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class SocialInfo {

    @Column(length = 200, nullable = false)
    private String socialId;

    @Column(length = 200, nullable = false)
    private String socialEmail;

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserSocialType socialType;

    private SocialInfo(final String socialId, final String socialEmail, final UserSocialType socialType) {
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        this.socialType = socialType;
    }
    public static SocialInfo of(final String socialId, final String socialEmail, final UserSocialType socialType) {
        return new SocialInfo(socialId, socialEmail, socialType);
    }

    public void modifySocialEmail(final String socialEmail) {
        this.socialEmail = socialEmail;
    }
}
