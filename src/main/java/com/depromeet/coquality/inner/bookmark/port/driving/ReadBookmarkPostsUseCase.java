package com.depromeet.coquality.inner.bookmark.port.driving;

import com.depromeet.coquality.inner.bookmark.vo.BookmarkPostResponse;
import java.util.List;

public interface ReadBookmarkPostsUseCase {
    List<BookmarkPostResponse> execute(Long userId);
}
