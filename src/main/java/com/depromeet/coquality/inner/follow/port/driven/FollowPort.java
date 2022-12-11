package com.depromeet.coquality.inner.follow.port.driven;

import com.depromeet.coquality.inner.follow.domain.Follow;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import java.util.List;

public interface FollowPort {
    void save(Follow follow);
    void delete(Long fromUserId, Long toUserId);
    Long fetchFollowCount(Long userId);

    List<UserEntity> fetchFollowers(Long toUserId);
}
