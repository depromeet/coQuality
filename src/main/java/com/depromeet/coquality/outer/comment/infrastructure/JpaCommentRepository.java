package com.depromeet.coquality.outer.comment.infrastructure;

import com.depromeet.coquality.outer.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long> {

    Long countByPostId(Long id);

}
