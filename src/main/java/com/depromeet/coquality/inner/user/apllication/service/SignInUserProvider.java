package com.depromeet.coquality.inner.user.apllication.service;


import com.depromeet.coquality.inner.user.apllication.service.kakao.KakaoSignInService;
import com.depromeet.coquality.inner.user.port.driving.SignInUserUseCase;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SignInUserProvider {
    private final Map<UserSocialType, SignInUserUseCase> signInUserUseCaseMap = new HashMap<>();

    private final KakaoSignInService kaKaoSignUpService;
    //TODO 애플, 구글 확장 고려
//    private final AppleAuthService appleSignUpService;
//    private final GoogleAuthService googleSignUpService;

    @PostConstruct
    void initializeAuthServicesMap() {
        signInUserUseCaseMap.put(UserSocialType.KAKAO, kaKaoSignUpService);
//        authServiceMap.put(UserSocialType.APPLE, appleSignUpService);
//        authServiceMap.put(UserSocialType.GOOGLE, googleSignUpService);
    }
    public SignInUserUseCase getSignUpService(final UserSocialType socialType) {
        return signInUserUseCaseMap.get(socialType);
    }
}
