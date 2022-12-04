package com.depromeet.coquality.inner.follow.application;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowCountUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFollowCountService implements GetFollowCountUserCase {

    private final FollowPort followPort;

    @Override
    public Long execute(final Long userId) {
        return followPort.fetchFollowCount(userId);
    }
}
