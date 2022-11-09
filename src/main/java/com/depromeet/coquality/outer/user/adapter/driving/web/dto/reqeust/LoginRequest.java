package com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust;


import com.depromeet.coquality.inner.user.port.driving.dto.request.LoginDto;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotBlank(message = "{auth.token.notBlank}")
    private String token;

    @NotNull(message = "{user.socialType.notNull}")
    private UserSocialType socialType;

    public LoginDto toInnerDto(){
        return LoginDto.of(token, String.valueOf(socialType));
    }
}
