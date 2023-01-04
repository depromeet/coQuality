package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.GetMyFollowCountUseCase;
import com.depromeet.coquality.inner.follow.vo.FollowCountResponse;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetMyFollowCountService implements GetMyFollowCountUseCase {

    private final FollowPort followPort;

    @Override
    public FollowCountResponse execute(Long userId) {
        List<UserEntity> followers = followPort.fetchFollowers(userId);
        List<UserEntity> followings = followPort.fetchFollowings(userId);
        return FollowCountResponse.of(followers.size(), followings.size());
    }
}
