package com.depromeet.coquality.outer.user.entity;

import com.depromeet.coquality.outer.common.entity.BaseEntity;
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

@Entity(name = "User")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nickname;

    @Column
    private String profileImageUrl;

    @Column
    private String userSummary;

    @Embedded
    private SocialInfo socialInfo;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private UserEntity(final String nickname, final String socialId, final UserSocialType socialType, final String socialEmail) {
        this.nickname = nickname;
        this.socialInfo = SocialInfo.of(socialId, socialEmail, socialType);
    }

    public void modifyUserSummary(final String userSummary) {
        this.userSummary = userSummary;
    }

    public void modifyNickname(final String nickname) {
        //TODO 닉네임 중복 체크 API 필요.
        this.nickname = nickname;
    }

}
