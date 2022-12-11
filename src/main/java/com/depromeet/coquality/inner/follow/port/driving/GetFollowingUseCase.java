package com.depromeet.coquality.inner.follow.port.driving;

import com.depromeet.coquality.inner.follow.vo.FollowUserResponse;
import java.util.List;

public interface GetFollowingUseCase {
    List<FollowUserResponse> execute(Long fromUserId);
}
