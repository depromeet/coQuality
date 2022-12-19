package com.depromeet.coquality.inner.bookmark.domain.policy.validation;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;

public final class BookmarkValidationPolicy {
    public static void validateBookmark(final Bookmark bookmark) {
        validateBookmarkUserId(bookmark.getUserId());
        validateBookmarkPostId(bookmark.getPostId());
    }

    private static void validateBookmarkPostId(final Long postId) {
        if (postId == null){
            throw CoQualityDomainExceptionCode.BOOKMARK_USERID_IS_NULL.newInstance();
        }
    }

    private static void validateBookmarkUserId(final Long userId) {
        if (userId == null){
            throw CoQualityDomainExceptionCode.BOOKMARK_POSTID_IS_NULL.newInstance();
        }
    }
}
