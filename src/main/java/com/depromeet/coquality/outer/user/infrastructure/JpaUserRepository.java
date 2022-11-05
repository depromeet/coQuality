package com.depromeet.coquality.outer.user.infrastructure;

import com.depromeet.coquality.outer.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
