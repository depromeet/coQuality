package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.DeleteFollowUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteFollowService implements DeleteFollowUseCase {

    private final FollowPort followPort;

    @Override
    public void execute(final Long fromUserId, final Long toUserId) {
        followPort.delete(fromUserId, toUserId);
    }
}
