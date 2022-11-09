package com.depromeet.coquality.outer.user.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserSocialType {
    KAKAO("카카오톡"),
    APPLE("애플"),
    GOOGLE("구글"),
    ;
    private final String value;

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
