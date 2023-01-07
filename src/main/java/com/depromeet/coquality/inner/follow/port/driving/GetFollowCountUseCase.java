package com.depromeet.coquality.inner.follow.port.driving;

import com.depromeet.coquality.inner.follow.vo.FollowCountResponse;

public interface GetFollowCountUseCase {
    FollowCountResponse execute(Long userId);
}
