package com.depromeet.coquality.inner.user.port.driving.dto.request;

import lombok.Getter;

@Getter
public class UserDto {
    private String nickname;
    private String socialEmail;
    private String userSummary;
    private String profileImageUrl;

    private UserDto(final String nickname, final String socialEmail, final String userSummary, final String profileImageUrl) {
        this.nickname = nickname;
        this.socialEmail = socialEmail;
        this.userSummary = userSummary;
        this.profileImageUrl = profileImageUrl;
    }

    public static UserDto of(final String nickname, final String socialEmail, final String userSummary, final String profileImageUrl) {
        return new UserDto(nickname, socialEmail, userSummary, profileImageUrl);
    }
}
