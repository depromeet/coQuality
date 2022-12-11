package com.depromeet.coquality.inner.bookmark.port.driving;

import com.depromeet.coquality.inner.bookmark.port.driving.dto.BookmarkDto;

public interface PutBookmarkUseCase {
    void execute(Long bookmarkId, BookmarkDto bookmarkDto);
}
