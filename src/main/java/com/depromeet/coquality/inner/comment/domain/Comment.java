package com.depromeet.coquality.inner.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comment {
    private String contents;
    private Long userId;
    private Long postId;
}
