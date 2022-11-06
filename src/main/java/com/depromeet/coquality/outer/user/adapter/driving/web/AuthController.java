package com.depromeet.coquality.outer.user.adapter.driving.web;


import com.depromeet.coquality.inner.user.apllication.service.SignUpUserProvider;
import com.depromeet.coquality.inner.user.port.driving.SignUpUserUseCase;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final SignUpUserProvider userProvider;

    @PostMapping("/signup") // 동작확인을 위해 id 리턴시켰습니다~
    public Long signUp(@Valid @RequestBody final SignUpRequest request){
        final SignUpUserUseCase signUpUserUseCase = userProvider.getSignUpService(request.getSocialType());
        final Long userId = signUpUserUseCase.execute(request.toInnerDto());
        return userId;
    }
}
