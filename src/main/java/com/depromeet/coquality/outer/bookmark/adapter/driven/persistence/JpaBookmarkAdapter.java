package com.depromeet.coquality.outer.bookmark.adapter.driven.persistence;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import com.depromeet.coquality.outer.bookmark.infrastructure.JpaBookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaBookmarkAdapter implements BookmarkPort {

    private final JpaBookmarkRepository jpaBookmarkRepository;

    @Override
    public Long save(final Bookmark bookmark) {
        final BookmarkEntity saveBookmarkEntity = BookmarkEntity.factory()
                .userId(bookmark.getUserId())
                .postId(bookmark.getPostId())
                .description(bookmark.getDescription())
                .newInstance();
        jpaBookmarkRepository.save(saveBookmarkEntity);
        return saveBookmarkEntity.getId();
    }

    @Override
    public void delete(final Bookmark bookmark) {
        final BookmarkEntity findBookmarkEntity = jpaBookmarkRepository.findBookmarkByUserIdAndPostId(bookmark.getUserId(),
                        bookmark.getPostId())
                .orElseThrow(CoQualityDomainExceptionCode.BOOKMARK_ENTITY_IS_NULL::newInstance);
        jpaBookmarkRepository.delete(findBookmarkEntity);
    }

    @Override
    public void changeBookmark(final Long bookmarkId, final String description) {
        final BookmarkEntity findBookmarkEntity = jpaBookmarkRepository.findById(bookmarkId)
                .orElseThrow(CoQualityDomainExceptionCode.BOOKMARK_ENTITY_IS_NULL::newInstance);

        findBookmarkEntity.changeBookmarkDescription(description);
        jpaBookmarkRepository.save(findBookmarkEntity);
    }
}
