package com.depromeet.coquality.inner.bookmark.application;

import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.port.driving.DeleteAllBookmarkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAllBookmarkService implements DeleteAllBookmarkUseCase {

    private final BookmarkPort bookmarkPort;

    @Override
    public void execute(final Long userId) {
        bookmarkPort.deleteAll(userId);
    }
}
