package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.domain.Follow;
import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.CreateFollowUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CreateFollowService implements CreateFollowUseCase {
    private final FollowPort followPort;

    @Override
    public void execute(final Long fromUserId, final Long toUserId) {
        final Follow follow = Follow.of(fromUserId, toUserId);
        followPort.save(follow);
    }
}
