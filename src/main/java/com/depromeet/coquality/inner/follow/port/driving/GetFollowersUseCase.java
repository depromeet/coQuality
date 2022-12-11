package com.depromeet.coquality.inner.follow.port.driving;

import com.depromeet.coquality.inner.follow.vo.FollowUserResponse;
import java.util.List;

public interface GetFollowersUseCase {
    List<FollowUserResponse> execute(Long toUserId);
}
