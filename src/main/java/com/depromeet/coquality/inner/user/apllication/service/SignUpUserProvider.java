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
    private final Map<UserSocialType, SignUpUserUseCase> signUserServiceMap = new HashMap<>();

    private final KaKaoSignUpService kaKaoSignUpService;
    //TODO 애플, 구글 확장 고려
//    private final AppleAuthService appleSignUpService;
//    private final GoogleAuthService googleSignUpService;

    @PostConstruct
    void initializeAuthServicesMap() {
        signUserServiceMap.put(UserSocialType.KAKAO, kaKaoSignUpService);
//        authServiceMap.put(UserSocialType.APPLE, appleSignUpService);
//        authServiceMap.put(UserSocialType.GOOGLE, googleSignUpService);
    }
    public SignUpUserUseCase getSignUpService(final UserSocialType socialType) {
        return signUserServiceMap.get(socialType);
    }
}
