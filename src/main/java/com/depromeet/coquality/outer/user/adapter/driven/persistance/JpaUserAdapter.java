package com.depromeet.coquality.outer.user.adapter.driven.persistance;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.vo.UserResponse;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserAdapter implements UserPort {

    private final JpaUserRepository jpaUserRepository;


    @Override
    public Long insert(final User user, final UserSocialType socialType) {
        final UserEntity saveUser = jpaUserRepository.save(
                UserEntity.factory()
                        .nickname(user.getNickname())
                        .socialId(user.getSocialId())
                        .socialEmail(user.getSocialEmail())
                        .socialType(socialType)
                        .newInstance()
        );
        return saveUser.getId();
    }

    @Override
    public Long findUserBySocialIdAndSocialType(final String socialId, final UserSocialType socialType) {
        final UserEntity findUser = jpaUserRepository.findBySocialIdAndSocialType(socialId, socialType)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("존재하지 않는 유저 (%s - %s) 입니다", socialId, socialType)));
        return findUser.getId();
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public void update(final Long userId, final User user) {
        final UserEntity foundUser = jpaUserRepository.findById(userId)
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);

        foundUser.modifyNickname(user.getNickname());
        foundUser.getSocialInfo().modifySocialEmail(user.getSocialEmail());
        foundUser.modifyUserSummary(user.getUserSummary());

        jpaUserRepository.save(foundUser);
    }

    @Override
    public UserResponse fetch(final Long userId) {
        final UserEntity findUser = jpaUserRepository.findById(userId)
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);

        return UserResponse.of(findUser.getId(), findUser.getNickname(), findUser.getProfileImageUrl(), findUser.getSocialInfo().getSocialEmail(), findUser.getUserSummary(), String.valueOf(findUser.getRank()));
    }

    @Override
    public boolean existNickname(final String nickname) {
        Optional<UserEntity> findUser = jpaUserRepository.findByNickname(nickname);
        return findUser.isEmpty();
    }

    @Override
    public UserEntity fetchUser(final Long userId) {
        return jpaUserRepository.findById(userId)
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);
//        return User.of(findUser.getNickname(), findUser.getSocialInfo().getSocialEmail(), findUser.getUserSummary(), String.valueOf(findUser.getRank()));
    }
}
