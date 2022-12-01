package com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust;

import lombok.Getter;

import javax.validation.Valid;

@Getter
public class ModifyUserRequest {

    @Valid
    private String email;
    @Valid
    private String nickname;
    private String userSummary;

}
