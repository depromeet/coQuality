package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;
import com.depromeet.coquality.outer.comment.adapter.driven.persistence.JpaCommentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentService implements UpdateCommentUseCase {
    private final JpaCommentAdapter commentAdapter;

    @Override
    public Comment execute(Long commentId, CommentDto commentDto) {
        Comment comment = commentAdapter.findById(commentId);
        Comment updatedComment = comment.update(
                commentDto.userId(),
                commentDto.postId(),
                commentDto.contents()
        );

        commentAdapter.save(updatedComment);
        return updatedComment;
    }
}
