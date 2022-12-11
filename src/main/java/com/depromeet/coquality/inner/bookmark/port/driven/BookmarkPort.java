package com.depromeet.coquality.inner.bookmark.port.driven;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;

public interface BookmarkPort {
    Long save(Bookmark bookmark);
}
