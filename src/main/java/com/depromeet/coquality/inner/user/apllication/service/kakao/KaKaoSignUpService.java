package com.depromeet.coquality.inner.user.apllication.service.kakao;

import com.depromeet.coquality.inner.common.util.HttpHeaderUtils;
import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.SignUpUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.dto.request.SignUpDto;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import com.depromeet.coquality.outer.user.external.client.kakao.KaKaoAuthApiClient;
import com.depromeet.coquality.outer.user.external.client.kakao.dto.response.KaKaoProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class KaKaoSignUpService implements SignUpUserUseCase {

    private static final UserSocialType socialType = UserSocialType.KAKAO;
    private final UserPort userPort;
    private final KaKaoAuthApiClient kakaoAuthApiCaller;

    @Override
    public Long execute(final SignUpDto request) {
        final KaKaoProfileResponse response = kakaoAuthApiCaller.getProfileInfo(HttpHeaderUtils.withBearerToken(request.getToken()));
        return userPort.insert(User.of(response.getId(), response.getAccount().getEmail(), String.valueOf(socialType)));
    }
}
