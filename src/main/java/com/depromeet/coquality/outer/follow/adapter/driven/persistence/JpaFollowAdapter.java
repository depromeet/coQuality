package com.depromeet.coquality.outer.follow.adapter.driven.persistence;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.inner.follow.domain.Follow;
import com.depromeet.coquality.inner.follow.exception.FollowDuplicateException;
import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.outer.follow.entity.FollowEntity;
import com.depromeet.coquality.outer.follow.infrastructure.JpaFollowRepository;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaFollowAdapter implements FollowPort {

    private final JpaFollowRepository jpaFollowRepository;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public void save(final Follow follow) {
        jpaUserRepository.findById(follow.getToUserId())
                .orElseThrow(CoQualityDomainExceptionCode.FOLLOW_TO_USER_IS_NULL::newInstance);

        final Optional<FollowEntity> findFollow = jpaFollowRepository.findFollowByFromUserIdAndToUserId(
                follow.getFromUserId(), follow.getToUserId());

        if (findFollow.isPresent()) {
            throw new FollowDuplicateException(1, "follow entity is duplicate");
        }

        final FollowEntity followEntity = FollowEntity.factory()
                .fromUserId(follow.getFromUserId())
                .toUserId(follow.getToUserId())
                .newInstance();

        jpaFollowRepository.save(followEntity);
    }

    @Override
    public void delete(final Long fromUserId, final Long toUserId) {
        final FollowEntity findFollowEntity = jpaFollowRepository
                .findFollowByFromUserIdAndToUserId(fromUserId, toUserId)
                .orElseThrow(CoQualityDomainExceptionCode.FOLLOW_ENTITY_IS_NULL::newInstance);

        jpaFollowRepository.delete(findFollowEntity);
    }

    @Override
    public Long fetchFollowCount(final Long userId) {
        final UserEntity findUserEntity = jpaUserRepository.findById(userId)
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);

        final Long followCount = jpaFollowRepository.countByToUserId(findUserEntity.getId());
        return followCount;
    }

}
