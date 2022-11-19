package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentService implements UpdateCommentUseCase {
    private final CommentPort commentPort;

    @Override
    public Comment execute(Long commentId, CommentDto commentDto) {
        Comment comment = commentPort.findById(commentId);

        Comment updatedComment = comment.update(
                commentDto.userId(),
                commentDto.postId(),
                commentDto.contents()
        );

        commentPort.save(updatedComment);
        return updatedComment;
    }
}
