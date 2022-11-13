package com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust;

import com.depromeet.coquality.inner.user.port.driving.dto.request.SignUpDto;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpRequest {
    @NotBlank(message = "{auth.token.notBlank}")
    private String token;

    @NotNull(message = "{user.socialType.notNull}")
    private UserSocialType socialType;

    @NotNull
    private String nickname;

    @NotNull
    private String email;

    public SignUpDto toInnerDto(){
        return SignUpDto.of(token, String.valueOf(socialType), nickname, email);
    }
}
