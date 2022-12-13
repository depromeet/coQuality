package com.depromeet.coquality.inner.bookmark.application;

import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.port.driving.ReadBookmarkPostsUseCase;
import com.depromeet.coquality.inner.bookmark.vo.BookmarkPostResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadBookmarkPostsService implements ReadBookmarkPostsUseCase {

    private final BookmarkPort bookmarkPort;

    @Override
    public List<BookmarkPostResponse> execute(final Long userId) {
        return bookmarkPort.readBookmarkPosts(userId);
    }
}
