package com.depromeet.coquality.outer.comment.adapter.driving.web.response;

import com.depromeet.coquality.inner.comment.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long postId,
        Long userId,
        Long commentId,
        String contents,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CommentResponse from(Comment comment) {
        // TODO, refactor commentId and time
        return new CommentResponse(
                comment.getPostId(),
                comment.getUserId(),
                1L,
                comment.getContents(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
