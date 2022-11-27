package com.depromeet.coquality.outer.comment.adapter.driving.web.response;


import com.depromeet.coquality.inner.comment.domain.Comment;

public record CommentResponse(
        Long commentId,
        Long postId,
        Long userId,
        String contents
) {
    public static CommentResponse from(final Long commentId, final Comment comment) {
        return new CommentResponse(
                commentId,
                comment.getPostId(),
                comment.getUserId(),
                comment.getContents()
        );
    }
}
