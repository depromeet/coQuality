package com.depromeet.coquality.inner.comment.vo;

import java.time.LocalDateTime;

public class CommentResponse {
    private Long id;
    private String contents;
    private Long userId;
    private Long postId;
    private LocalDateTime createdAt;

    private CommentResponse(final Long id, final String contents, final Long userId, final Long postId, final LocalDateTime createdAt) {
        this.id = id;
        this.contents = contents;
        this.userId = userId;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public static CommentResponse of(final Long id, final String contents, final Long userId, final Long postId, final LocalDateTime createdAt){
        return new CommentResponse(id, contents, userId, postId, createdAt);
    }
}
