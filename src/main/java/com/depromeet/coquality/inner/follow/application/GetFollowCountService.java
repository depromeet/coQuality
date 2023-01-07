package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowCountUseCase;
import com.depromeet.coquality.inner.follow.vo.FollowCountResponse;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GetFollowCountService implements GetFollowCountUseCase {

    private final FollowPort followPort;
    private final UserPort userPort;

    @Override
    public FollowCountResponse execute(final Long userId) {
        List<UserEntity> followers = followPort.fetchFollowers(userId);
        List<UserEntity> followings = followPort.fetchFollowings(userId);
        return FollowCountResponse.of(followers.size(), followings.size());
    }
}
