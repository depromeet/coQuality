package com.depromeet.coquality.inner.user.apllication.service.utils;

import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SignUpUserServiceUtils {
    private final JpaUserRepository jpaUserRepository;

    public void validateNotExistsUser(final String socialId, final UserSocialType socialType) {
        final Optional<UserEntity> existUser = jpaUserRepository.existsBySocialIdAndSocialType(socialId, socialType);
        if (existUser.isPresent()){
            throw new IllegalArgumentException(String.format("이미 존재하는 유저 (%s - %s) 입니다", socialId, socialType));
        }
    }
}
