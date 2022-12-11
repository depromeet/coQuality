package com.depromeet.coquality.inner.follow.port.driven;

import com.depromeet.coquality.inner.follow.domain.Follow;

public interface FollowPort {
    void save(Follow follow);
    void delete(Long fromUserId, Long toUserId);
    Long fetchFollowCount(Long userId);
}