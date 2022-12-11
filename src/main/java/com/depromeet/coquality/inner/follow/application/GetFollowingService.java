package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowingUseCase;
import com.depromeet.coquality.inner.follow.vo.FollowUserResponse;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetFollowingService implements GetFollowingUseCase {

    private final FollowPort followPort;

    @Override
    public List<FollowUserResponse> execute(final Long fromUserId) {
        final List<UserEntity> findFollowings = followPort.fetchFollowings(fromUserId);
        return findFollowings
                .stream()
                .map(f -> FollowUserResponse.of(f.getId(), f.getNickname(), f.getProfileImageUrl()))
                .toList();

    }
}
