package com.depromeet.coquality.inner.user.port.driving.dto.request;


import lombok.Getter;

@Getter
public class SignUpDto {
    private String token;
    private String socialType;

    private SignUpDto(final String token, final String socialType) {
        this.token = token;
        this.socialType = socialType;
    }

    public static SignUpDto of(final String token, final String socialType) {
        return new SignUpDto(token, socialType);
    }
}
