package com.depromeet.coquality.inner.follow.port.driving;

import com.depromeet.coquality.inner.follow.vo.FollowCountResponse;

public interface GetMyFollowCountUseCase {
    FollowCountResponse execute(Long userId);
}
