package com.depromeet.coquality.inner.bookmark.domain;

import com.depromeet.coquality.inner.bookmark.domain.policy.validation.BookmarkValidationPolicy;
import lombok.Getter;

@Getter
public class Bookmark {
    private Long userId;
    private Long postId;
    private String description;

    private Bookmark(final Long userId, final Long postId, final String description) {
        this.userId = userId;
        this.postId = postId;
        this.description = description;
        BookmarkValidationPolicy.validateBookmark(this);
    }
    public static Bookmark of(final Long userId, final Long postId){
        return new Bookmark(userId, postId, null);
    }
}
