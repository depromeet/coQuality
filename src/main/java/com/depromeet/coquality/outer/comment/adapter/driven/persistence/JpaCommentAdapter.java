package com.depromeet.coquality.outer.comment.adapter.driven.persistence;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.exception.CommentNotFoundException;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.outer.comment.entity.CommentEntity;
import com.depromeet.coquality.outer.comment.infrastructure.JpaCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Optional;

import static java.text.MessageFormat.*;

@Component
@RequiredArgsConstructor
public class JpaCommentAdapter implements CommentPort {
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public void save(Comment comment) {
        jpaCommentRepository.save(
                CommentEntity.factory()
                        .contents(comment.getContents())
                        .userId(comment.getUserId())
                        .postId(comment.getPostId())
                        .newInstance()
        );
    }

    @Override
    public Comment findById(Long commentId) {
        Optional<CommentEntity> optionalCommentEntity = jpaCommentRepository.findById(commentId);

        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            return new Comment(
                    commentEntity.getContents(),
                    commentEntity.getUserId(),
                    commentEntity.getPostId()
            );
        }

        // TODO, change code or remove unnecessary code
        throw new CommentNotFoundException(0, format("Comment not found. id: {0}", commentId));
    }
}
