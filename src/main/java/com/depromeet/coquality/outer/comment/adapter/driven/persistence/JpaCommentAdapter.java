package com.depromeet.coquality.outer.comment.adapter.driven.persistence;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.exception.CommentNotFoundException;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.vo.CommentResponse;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.outer.comment.entity.CommentEntity;
import com.depromeet.coquality.outer.comment.infrastructure.JpaCommentRepository;
import com.depromeet.coquality.outer.common.exception.CoQualityOuterExceptionCode;
import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.text.MessageFormat.format;

@Component
@RequiredArgsConstructor
public class JpaCommentAdapter implements CommentPort {
    private final JpaCommentRepository jpaCommentRepository;
    private final JpaUserRepository jpaUserRepository;
    private final JpaPostRepository jpaPostRepository;

    @Override
    public void save(final Comment comment) {
        final UserEntity user = jpaUserRepository.findById(comment.getUserId())
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);

        jpaCommentRepository.save(
                CommentEntity.factory()
                        .contents(comment.getContents())
                        .userId(user.getId())
                        .postId(comment.getPostId())
                        .newInstance()
        );
    }

    @Override
    public Comment findById(final Long commentId) {
        final Optional<CommentEntity> optionalCommentEntity = jpaCommentRepository.findById(commentId);

        if (optionalCommentEntity.isPresent()) {
            final CommentEntity commentEntity = optionalCommentEntity.get();
            return new Comment(
                    commentEntity.getContents(),
                    commentEntity.getUserId(),
                    commentEntity.getPostId()
            );
        }

        // TODO, change code or remove unnecessary code
        throw new CommentNotFoundException(0, format("Comment not found. id: {0}", commentId));
    }

    @Override
    public void delete(final Long commentId, final Long postId, final Long userId) {
        jpaUserRepository.findById(userId)
                .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);
        jpaPostRepository.findById(postId)
                .orElseThrow(CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL::newInstance);
        final CommentEntity commentEntity = jpaCommentRepository.findById(commentId)
                .orElseThrow(CoQualityDomainExceptionCode.COMMENT_ENTITY_IS_NULL::newInstance);

        //TODO 일단 하드 딜리트로
        jpaCommentRepository.delete(commentEntity);

    }

    @Override
    public List<CommentResponse> fetch(final Long postId) {
        jpaPostRepository.findById(postId)
                .orElseThrow(CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL::newInstance);

        final List<CommentEntity> comments = jpaCommentRepository.findAllByPostId(postId);

        return comments.stream()
                .map(p -> {
                    final var findUserEntity = jpaUserRepository.findById(p.getUserId())
                            .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);
                    return CommentResponse.of(
                            p.getId(),
                            p.getContents(),
                            findUserEntity.getNickname(),
                            p.getUserId(),
                            p.getPostId(),
                            p.getCreatedAt()
                    );
                })
                .toList();
    }
}
