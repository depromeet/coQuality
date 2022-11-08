package com.depromeet.coquality.inner.user.port.driving.dto.request;

import lombok.Getter;

@Getter
public class LoginDto {
    private String token;

    private String socialType;

    private LoginDto(final String token, final String socialType) {
        this.token = token;
        this.socialType = socialType;
    }
    public static LoginDto of(String token, String socialType) {
        return new LoginDto(token, socialType);
    }
}
