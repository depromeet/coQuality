package com.depromeet.coquality.inner.bookmark.application;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.port.driving.CreateBookmarkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBookmarkService implements CreateBookmarkUseCase {
    private final BookmarkPort bookmarkPort;

    @Override
    public void execute(final Long userId, final Long postId) {
        final Bookmark saveBookmark = Bookmark.of(userId, postId);
        bookmarkPort.save(saveBookmark);
    }
}
