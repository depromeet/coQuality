package com.depromeet.coquality.outer.user.infrastructure;

import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserSocialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from users u where u.socialInfo.socialId = :socialId and u.socialInfo.socialType = :socialType")
    Optional<UserEntity> findBySocialIdAndSocialType(@Param("socialId") String socialId,
        @Param("socialType") UserSocialType socialType);

    Optional<UserEntity> findByNickname(String nickname);
}
