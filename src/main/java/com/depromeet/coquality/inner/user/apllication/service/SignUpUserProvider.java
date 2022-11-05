package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.user.apllication.service.kakao.KaKaoSignUpService;
import com.depromeet.coquality.inner.user.port.driving.SignUpUserUseCase;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class SignUpUserProvider {
    private static final Map<UserSocialType, SignUpUserUseCase> signUserServiceMap = new HashMap<>();

    private final KaKaoSignUpService kaKaoAuthService;
    //TODO 애플, 구글 확장 고려
//    private final AppleAuthService appleAuthService;
//    private final GoogleAuthService googleAuthService;

    @PostConstruct
    void initializeAuthServicesMap() {
        signUserServiceMap.put(UserSocialType.KAKAO, kaKaoAuthService);
//        authServiceMap.put(UserSocialType.APPLE, appleAuthService);
//        authServiceMap.put(UserSocialType.GOOGLE, googleAuthService);
    }
    public SignUpUserUseCase getSignUpService(final UserSocialType socialType) {
        return signUserServiceMap.get(socialType);
    }
}
