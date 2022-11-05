package com.depromeet.coquality.inner.user.port.driving.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpDto {
    private String token;
    private String socialType;

    private SignUpDto(final String token, final String socialType) {
        this.token = token;
        this.socialType = socialType;
    }

    public static SignUpDto of(String token, String socialType) {
        return new SignUpDto(token, socialType);
    }
}
