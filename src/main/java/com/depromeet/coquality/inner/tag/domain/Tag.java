package com.depromeet.coquality.inner.tag.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Tag {

    private Long postId;
    private Long userId;
    private String tagValue;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public Tag(Long postId, Long userId, String tagValue) {
        this.postId = postId;
        this.userId = userId;
        this.tagValue = tagValue;
    }
}
