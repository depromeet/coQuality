package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentService implements UpdateCommentUseCase {
    private final CommentPort commentPort;

    @Override
    @Transactional
    public Comment execute(final Long commentId, final CommentDto commentDto) {
        final Comment comment = commentPort.findById(commentId);

        final Comment updatedComment = comment.update(
                commentDto.userId(),
                commentDto.postId(),
                commentDto.contents()
        );

        commentPort.save(updatedComment);
        return updatedComment;
    }
}
