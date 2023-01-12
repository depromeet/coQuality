package com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust;

import com.depromeet.coquality.inner.user.port.driving.dto.request.UserDto;
import lombok.Getter;

import javax.validation.Valid;

@Getter
public class ModifyUserRequest {

    @Valid
    private String email;
    @Valid
    private String nickname;
    private String userSummary;
    private String profileImageUrl;


    public UserDto toUserDto() {
        return UserDto.of(nickname, email, userSummary, profileImageUrl);
    }
}
