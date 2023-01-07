package com.depromeet.coquality.inner.bookmark.port.driving;

import com.depromeet.coquality.inner.bookmark.vo.BookmarkConditionResponse;

public interface CheckBookmarkUseCase {
    BookmarkConditionResponse execute(Long userId, Long postId);
}
