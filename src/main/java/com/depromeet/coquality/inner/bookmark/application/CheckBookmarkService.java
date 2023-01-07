package com.depromeet.coquality.inner.bookmark.application;

import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.port.driving.CheckBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.vo.BookmarkConditionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CheckBookmarkService implements CheckBookmarkUseCase {
    private final BookmarkPort bookmarkPort;

    @Override
    public BookmarkConditionResponse execute(final Long userId, final Long postId) {
        return bookmarkPort.fetchBookmarkByUserIdAndPostId(userId, postId);
    }
}
