package com.depromeet.coquality.outer.user.adapter.driving.web;


import com.depromeet.coquality.inner.user.apllication.service.SignInUserProvider;
import com.depromeet.coquality.inner.user.apllication.service.SignUpUserProvider;
import com.depromeet.coquality.inner.user.port.driving.SignInUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.SignUpUserUseCase;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.LoginRequest;
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
    private final SignUpUserProvider signUpUserProvider;
    private final SignInUserProvider signInUserProvider;

    @PostMapping("/signup")
    public Long signUp(@Valid @RequestBody final SignUpRequest request){
        final SignUpUserUseCase signUpUserUseCase = signUpUserProvider.getSignUpService(request.getSocialType());
        final Long userId = signUpUserUseCase.execute(request.toInnerDto());
        return userId;
    }
    @PostMapping("/singin")
    public Long signIn(@Valid @RequestBody final LoginRequest request){
        final SignInUserUseCase signInUserUseCase = signInUserProvider.getSignUpService(request.getSocialType());
        final Long userId = signInUserUseCase.execute(request.toInnerDto());
        return userId;
    }
}
