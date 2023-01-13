package com.depromeet.coquality.outer.post.infrastructure;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long>,
    JpaPostRepositoryCustom {

    Optional<PostEntity> findByIdAndPostStatusCodeLike(Long id, PostStatusCode postStatusCode);

    Optional<PostEntity> findByIdAndPostStatusCodeNotLike(Long id, PostStatusCode postStatusCode);

    Long countByUserId(final Long userId);

    @Query(value = "select sum(p.clap_count) from posts p where p.user_id = :userId", nativeQuery = true)
    Optional<Long> selectClapCountByUserId(@Param("userId") Long userId);
}
