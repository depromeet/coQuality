package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowersUseCase;
import com.depromeet.coquality.inner.follow.vo.FollowerResponse;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetFollowersService implements GetFollowersUseCase {
    private final FollowPort followPort;

    @Override
    public List<FollowerResponse> execute(final Long toUserId) {
        final List<UserEntity> findFollowers = followPort.fetchFollowers(toUserId);
        return findFollowers
                .stream()
                .map(u -> FollowerResponse.of(u.getId(), u.getNickname(), u.getNickname()))
                .toList();
    }
}
