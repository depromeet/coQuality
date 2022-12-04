package com.depromeet.coquality.outer.follow.infrastructure;

import com.depromeet.coquality.outer.follow.entity.FollowEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFollowRepository extends JpaRepository<FollowEntity, Long> {
}
