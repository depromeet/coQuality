package com.depromeet.coquality.outer.bookmark.adapter.driven.persistence;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import com.depromeet.coquality.outer.bookmark.infrastructure.JpaBookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaBookmarkAdapter implements BookmarkPort {

    private final JpaBookmarkRepository jpaBookmarkRepository;

    @Override
    public void save(final Bookmark bookmark) {
        final BookmarkEntity saveBookmarkEntity = BookmarkEntity.factory()
                .userId(bookmark.getUserId())
                .postId(bookmark.getPostId())
                .description(bookmark.getDescription())
                .newInstance();
        jpaBookmarkRepository.save(saveBookmarkEntity);
    }
}
