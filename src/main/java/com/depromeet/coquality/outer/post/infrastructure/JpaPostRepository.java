package com.depromeet.coquality.outer.post.infrastructure;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long>,
    JpaPostRepositoryCustom {

    Optional<PostEntity> findByIdAndPostStatusCodeLike(Long id, PostStatusCode postStatusCode);

    Optional<PostEntity> findByIdAndPostStatusCodeNotLike(Long id, PostStatusCode postStatusCode);
}
