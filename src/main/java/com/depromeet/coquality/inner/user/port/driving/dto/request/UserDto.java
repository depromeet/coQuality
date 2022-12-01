package com.depromeet.coquality.inner.user.port.driving.dto.request;

import lombok.Getter;

@Getter
public class UserDto {
    private String nickname;
    private String socialEmail;
    private String userSummary;

    private UserDto(final String nickname, final String socialEmail, final String userSummary) {
        this.nickname = nickname;
        this.socialEmail = socialEmail;
        this.userSummary = userSummary;
    }

    public static UserDto of(final String nickname, final String socialEmail, final String userSummary) {
        return new UserDto(nickname, socialEmail, userSummary);
    }
}
