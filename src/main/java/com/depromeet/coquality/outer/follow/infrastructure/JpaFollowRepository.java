package com.depromeet.coquality.outer.follow.infrastructure;

import com.depromeet.coquality.outer.follow.entity.FollowEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFollowRepository extends JpaRepository<FollowEntity, Long> {
    Optional<FollowEntity> findFollowByFromUserIdAndToUserId(Long fromUserId, Long toUserId);
    Long countByToUserId(Long userId);
    List<FollowEntity> findFollowByToUserId(Long toUserId);
    List<FollowEntity> findFollowByFromUserId(Long fromUserId);
}
