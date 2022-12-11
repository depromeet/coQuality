package com.depromeet.coquality.inner.follow.port.driving;

import com.depromeet.coquality.inner.follow.vo.FollowerResponse;
import java.util.List;

public interface GetFollowersUseCase {
    List<FollowerResponse> execute(Long toUserId);
}
