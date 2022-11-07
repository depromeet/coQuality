package com.depromeet.coquality.inner.comment.port.driving.dto;

import com.depromeet.coquality.inner.comment.domain.Comment;

public record CommentDto(
        String contents,
        Long userId,
        Long postId
) {
    public Comment toComment() {
        return new Comment(
                contents,
                userId,
                postId
        );
    }
}
