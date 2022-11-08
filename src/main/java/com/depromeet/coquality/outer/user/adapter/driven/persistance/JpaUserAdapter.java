package com.depromeet.coquality.outer.user.adapter.driven.persistance;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaUserAdapter implements UserPort {

    private final JpaUserRepository jpaUserRepository;


    @Override
    public Long insert(final User user, UserSocialType socialType) {
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
    public void delete(final Long id) {

    }

    @Override
    public void update() {

    }
}
