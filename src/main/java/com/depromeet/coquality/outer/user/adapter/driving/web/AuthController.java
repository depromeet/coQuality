package com.depromeet.coquality.outer.user.adapter.driving.web;


import com.depromeet.coquality.inner.user.apllication.service.SignInUserProvider;
import com.depromeet.coquality.inner.user.apllication.service.SignUpUserProvider;
import com.depromeet.coquality.inner.user.port.driving.SignInUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.SignUpUserUseCase;
import com.depromeet.coquality.inner.user.vo.LoginResponse;
import com.depromeet.coquality.inner.user.vo.SignUpResponse;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.jwt.JwtService;
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
    private final JwtService jwtService;

    @PostMapping("/signup")
    public ApiResponse<SignUpResponse> signUp(@Valid @RequestBody final SignUpRequest request) {
        final SignUpUserUseCase signUpUserUseCase = signUpUserProvider.getSignUpService(
            request.getSocialType());
        final Long userId = signUpUserUseCase.execute(request.toInnerDto());
        final String token = jwtService.issuedToken(String.valueOf(userId), "USER", 60 * 60 * 24 * 30L);
        return ApiResponse.success(SignUpResponse.of(token));
    }

    @PostMapping("/singin")
    public ApiResponse<LoginResponse> signIn(@Valid @RequestBody final LoginRequest request) {
        final SignInUserUseCase signInUserUseCase = signInUserProvider.getSignUpService(
            request.getSocialType());
        final Long userId = signInUserUseCase.execute(request.toInnerDto());
        final String token = jwtService.issuedToken(String.valueOf(userId), "USER", 60 * 60 * 24 * 30L);
        return ApiResponse.success(LoginResponse.of(token));
    }
}
