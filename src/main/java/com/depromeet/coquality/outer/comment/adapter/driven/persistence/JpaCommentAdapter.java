package com.depromeet.coquality.outer.comment.adapter.driven.persistence;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.outer.comment.entity.CommentEntity;
import com.depromeet.coquality.outer.comment.infrastructure.JpaCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaCommentAdapter implements CommentPort {
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public void insert(Comment comment) {
        jpaCommentRepository.save(
                CommentEntity.factory()
                        .contents(comment.getContents())
                        .userId(comment.getUserId())
                        .postId(comment.getPostId())
                        .newInstance()
        );
    }
}
