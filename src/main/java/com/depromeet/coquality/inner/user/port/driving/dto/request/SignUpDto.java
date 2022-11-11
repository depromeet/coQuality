package com.depromeet.coquality.inner.user.port.driving.dto.request;


import lombok.Getter;

@Getter
public class SignUpDto {
    private String token;
    private String socialType;

    private String nickname;

    private String email;

    private SignUpDto(final String token, final String socialType, final String nickname, final String email) {
        this.token = token;
        this.socialType = socialType;
        this.nickname = nickname;
        this.email = email;
    }

    public static SignUpDto of(final String token, final String socialType, final String nickname, final String email) {
        return new SignUpDto(token, socialType, nickname, email);
    }
}
