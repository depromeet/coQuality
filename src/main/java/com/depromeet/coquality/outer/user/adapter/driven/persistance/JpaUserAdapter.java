package com.depromeet.coquality.outer.user.adapter.driven.persistance;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaUserAdapter implements UserPort {

    private final JpaUserRepository jpaUserRepository;


    @Override
    public Long insert(final User user, final UserSocialType socialType) {
        final UserEntity saveUser = jpaUserRepository.save(
                UserEntity.factory()
                        .socialId(user.getSocialId())
                        .socialEmail(user.getSocialEmail())
                        .socialType(socialType)
                        .newInstance()
        );
        return saveUser.getId();
    }

    @Override
    public Long selectUserWhereSocialIdAndSocialType(final String socialId, final UserSocialType socialType) {
        final UserEntity findUser = jpaUserRepository.findBySocialIdAndSocialType(socialId, socialType)
                .orElseThrow(() -> new IllegalArgumentException());
        if (Objects.isNull(findUser)){
            throw new IllegalArgumentException(String.format("존재하지 않는 유저 (%s - %s) 입니다", socialId, socialType));
        }
        return findUser.getId();
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public void update() {

    }
}
