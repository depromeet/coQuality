package com.depromeet.coquality.inner.tag.domain;


import lombok.Getter;

@Getter
public class Tag {

    private final Long postId;
    private final Long userId;
    private final String tagValue;

    public Tag(Long postId, Long userId, String tagValue) {
        this.postId = postId;
        this.userId = userId;
        this.tagValue = tagValue;
    }
}
