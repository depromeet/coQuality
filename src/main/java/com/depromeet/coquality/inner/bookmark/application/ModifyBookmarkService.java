package com.depromeet.coquality.inner.bookmark.application;

import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.port.driving.ModifyBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.dto.BookmarkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyBookmarkService implements ModifyBookmarkUseCase {

    private final BookmarkPort bookmarkPort;

    @Override
    public void execute(final Long bookmarkId, final BookmarkDto bookmarkDto) {
        bookmarkPort.changeBookmark(bookmarkId, bookmarkDto.description());
    }
}
