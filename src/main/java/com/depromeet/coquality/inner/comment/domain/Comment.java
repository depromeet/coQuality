package com.depromeet.coquality.inner.comment.domain;

import lombok.Getter;

@Getter
public class Comment {
    private String contents;
    private Long userId;
    private Long postId;
}
