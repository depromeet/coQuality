package com.depromeet.coquality.inner.comment.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private Long id;
    private String contents;
    private String nickname;
    private Long userId;
    private Long postId;
    private LocalDateTime createdAt;

    private CommentResponse(final Long id, final String contents, final String nickname, final Long userId, final Long postId, final LocalDateTime createdAt) {
        this.id = id;
        this.contents = contents;
        this.nickname = nickname;
        this.userId = userId;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public static CommentResponse of(final Long id, final String contents, final String nickname, final Long userId, final Long postId, final LocalDateTime createdAt){
        return new CommentResponse(id, contents, nickname, userId, postId, createdAt);
    }
}
