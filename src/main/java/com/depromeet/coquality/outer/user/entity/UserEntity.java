package com.depromeet.coquality.outer.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nickname;

    @Embedded
    private SocialInfo socialInfo;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private UserEntity(final String socialId, final UserSocialType socialType, final String socialEmail) {
        this.socialInfo = SocialInfo.of(socialId, socialEmail, socialType);
    }
}
