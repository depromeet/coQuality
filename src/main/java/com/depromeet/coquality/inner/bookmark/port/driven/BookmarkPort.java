package com.depromeet.coquality.inner.bookmark.port.driven;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.bookmark.vo.BookmarkPostResponse;
import java.util.List;

public interface BookmarkPort {
    Long save(Bookmark bookmark);
    void delete(Bookmark bookmark);
    void changeBookmark(Long bookmarkId, String description);
    List<BookmarkPostResponse> readBookmarkPosts(Long userId);
}
