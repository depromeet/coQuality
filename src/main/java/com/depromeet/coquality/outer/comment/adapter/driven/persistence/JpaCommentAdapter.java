package com.depromeet.coquality.outer.comment.adapter.driven.persistence;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.exception.CommentNotFoundException;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.outer.comment.entity.CommentEntity;
import com.depromeet.coquality.outer.comment.infrastructure.JpaCommentRepository;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.text.MessageFormat.format;

@Component
@RequiredArgsConstructor
public class JpaCommentAdapter implements CommentPort {
    private final JpaCommentRepository jpaCommentRepository;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public void save(Comment comment) {
        final UserEntity user = jpaUserRepository.findById(comment.getUserId())
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);

        jpaCommentRepository.save(
                CommentEntity.factory()
                        .contents(comment.getContents())
                        .user(user)
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
                    commentEntity.getUser().getId(),
                    commentEntity.getPostId()
            );
        }

        // TODO, change code or remove unnecessary code
        throw new CommentNotFoundException(0, format("Comment not found. id: {0}", commentId));
    }
}
